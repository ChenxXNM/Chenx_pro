package com.baizhi;

import com.baizhi.dao.AdminDao;
import com.baizhi.dao.ProductDao;
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
    @Autowired
    private ProductDao productDao;

    /*@Test*/
   /* void contextLoads() {
        System.out.println(userDao.queryAll(1, 3));
    }*/

    @Test
    public void test(){
        System.out.println(productDao.queryAll(1, 3, null));
    }
}
