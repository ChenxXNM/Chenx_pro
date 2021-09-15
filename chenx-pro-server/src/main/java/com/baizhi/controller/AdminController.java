package com.baizhi.controller;

import com.baizhi.constants.RedisPrefix;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.ValidateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /*
     *
     * 用户登录
     *
     * */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> map) {
        //接受前端传递的参数
        String username = map.get("username");
        String password = map.get("password");
        //验证码
        String code = map.get("code");
        //token是它的唯一标识
        String token = map.get("token");
        //请求返回的结果
        HashMap<String, Object> result = new HashMap<>();
        try {
            //判断参数是否合法
            //获取redis中的验证码
            String redisCode = stringRedisTemplate.opsForValue().get(RedisPrefix.CAPTCHA_CODE + token);
            System.out.println(code + "======" + redisCode);
            //比对验证码是否一致  判断验证码是否正确
            if (redisCode == null) throw new RuntimeException("验证码已过期");
            if (!redisCode.equalsIgnoreCase(code)) throw new RuntimeException("您输入的验证码错误");
            //TODO 根据用户名密码 到数据库中进行查询
            Admin admin = adminService.queryByUsernameS(new Admin(null, username, password, null));
            //将用户保存到redis中
            stringRedisTemplate.opsForValue().set(RedisPrefix.CAPTCHA_CODE + token, username, 30, TimeUnit.MINUTES);
            result.put("success", true);
            result.put("username", admin.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
        }
        // 返回登录成功与否
        return result;
    }


    /*
     * 前端返回字符验证码
     *
     * */

    @GetMapping("/captcha")
    public Map<String, String> captcha() {
        //返回验证码
        HashMap<String, String> hashMap = new HashMap<>();
        //为每一个验证码生成一个唯一的key
        String token = DigestUtils.md5DigestAsHex(UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8));
        System.out.println(token);
        //生成value字符串的值
        ValidateCodeUtil.Validate validate = ValidateCodeUtil.getRandomCode();
        String value = validate.getValue();
        System.out.println("valeu" + "============" + value);

        stringRedisTemplate.opsForValue().set(RedisPrefix.CAPTCHA_CODE + token, value, 10, TimeUnit.MINUTES);
        //生成base64
        String base64Str = validate.getBase64Str();
        //返回base64
        hashMap.put("code", "data:image/png;base64," + base64Str);
        hashMap.put("token", token);
        return hashMap;
    }

    //退出系统，删除redis
    @DeleteMapping("/delete")
    public void delete(String token) {
        System.out.println(token + "======");
        stringRedisTemplate.delete(RedisPrefix.CAPTCHA_CODE + token);
    }

    /*
     * 检验用户状态
     *
     * */
    @GetMapping("/selLogin")
    public int selLogin(String token) {
        System.out.println(token+"盐");
        Boolean aBoolean = stringRedisTemplate.hasKey(RedisPrefix.USER_LOGIN + token);
        if (aBoolean == true) {
            return 1;
        } else {
            return 2;
        }
    }

}
