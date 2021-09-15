package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    public List<User> queryAllS(int page, int row,String name);


    public void insertS(User user);

    public void deleteS(int id);

    public void updateS(User user);

    public int getTotalS();
}
