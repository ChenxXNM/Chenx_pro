package com.baizhi.service;

import com.baizhi.dao.ProductDao;
import com.baizhi.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Product> queryAllS(int page, int row, String searValue) {
        int begin = (page-1)*row;
        return productDao.queryAll(begin, row, "%"+searValue+"%");
    }

    @Override
    public void deleteS(int id) {
        productDao.delete(id);
    }

    @Override
    public void insertS(Product product) {
        productDao.insert(product);
    }

    @Override
    public void updateS(Product product) {
        productDao.update(product);
    }

    @Override
    public int getTotalS() {
        return productDao.getTotal();
    }
}
