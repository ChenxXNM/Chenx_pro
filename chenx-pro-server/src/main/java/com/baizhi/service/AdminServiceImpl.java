package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.util.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class AdminServiceImpl implements AdminService{
    @Resource
    private AdminDao adminDao;


    @Override
    public Admin queryByUsernameS(Admin admin) {
        Admin admin1 = adminDao.queryByUsername(admin);
        String solt = admin1.getSolt();
        String password = admin.getPassword();
        if(admin1!=null){
            if(Md5Utils.getMd5Code(password+solt).equals(admin1.getPassword())){
                return admin1;
            }
            throw new  RuntimeException("密码不一致");
        }
        throw new RuntimeException("用户不存在");
    }
}
