package com.baizhi;

import com.baizhi.dao.AdminDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Admin;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@RunWith(Runner.class)
@SpringBootTest(classes = ChenxProServerApplication.class)
class ChenxProServerApplicationTests {
    @Autowired
    private UserDao userDao;
    /*@Test*/
   /* void contextLoads() {
        System.out.println(userDao.queryAll(1, 3));
    }*/

}
