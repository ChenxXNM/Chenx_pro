package com.baizhi.service;

import com.baizhi.dao.CateGoryDao;
import com.baizhi.entity.CateGory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class CateGoryServiceImpl implements CateGoryService {
    @Resource
    private CateGoryDao cateGoryDao;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<CateGory> queryAllS() {
        return cateGoryDao.queryAll();
    }

    @Override
    public void deleteS(int id) {
        cateGoryDao.delete(id);
    }

    @Override
    public void updateS(CateGory cateGory) {
        cateGoryDao.update(cateGory);
    }

    @Override
    public void insertS(CateGory cateGory) {
        cateGoryDao.insert(cateGory);
    }
}
