package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> queryAll(int begin,int row,String name);

    public void insert(User user);

    public void delete(int id);

    public void update(User user);

    public int getTotal();

}
