package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;
    @Override
    public List<User> queryAllS(int page, int row,String name) {
        int begin = (page-1)*row;
        return userDao.queryAll(begin,row,"%"+name+"%");
    }


    @Override
    @Transactional
    public void insertS(User user) {
        userDao.insert(user);
    }

    @Override
    @Transactional
    public void deleteS(int id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void updateS(User user) {
        userDao.update(user);
    }

    @Override
    public int getTotalS() {
        return userDao.getTotal();
    }
}
