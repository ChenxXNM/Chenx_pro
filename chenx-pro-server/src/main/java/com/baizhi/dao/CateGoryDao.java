package com.baizhi.dao;

import com.baizhi.entity.CateGory;

import java.util.List;

public interface CateGoryDao {
    List<CateGory> queryAll();

    void delete(int id);

    void update(CateGory cateGory);

    void insert(CateGory cateGory);


}
