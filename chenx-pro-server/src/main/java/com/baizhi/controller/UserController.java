package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController{
    @Resource
    private UserService userService;

    @GetMapping("/queryAll")
    public Map<String,Object> queryAll(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "rows",defaultValue = "3")Integer rows,@RequestParam(value = "name") String name){
        System.out.println("ok"+"====="+name);
        HashMap<String,Object> result=new HashMap<>();
            List<User> users = userService.queryAllS(page, rows,name);
            int total = userService.getTotalS();
            result.put("total",total);
            result.put("users",users);

        return result;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        userService.deleteS(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        userService.updateS(user);
    }
}
