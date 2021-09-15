package com.baizhi.service;

import com.baizhi.entity.CateGory;

import java.util.List;

public interface CateGoryService {
    public List<CateGory> queryAllS();

    void deleteS(int id);

    void updateS(CateGory cateGory);

    void insertS(CateGory cateGory);

}
