package com.baizhi.dao;

import com.baizhi.entity.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> queryAll(int begin,int row,String searValue);

    public void delete(int id);

    public void insert (Product product);

    public void update(Product product);

    public int getTotal();

}
