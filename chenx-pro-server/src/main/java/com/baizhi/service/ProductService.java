package com.baizhi.service;

import com.baizhi.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> queryAllS(int page, int row, String searValue);

    public void deleteS(int id);

    public void insertS (Product product);

    public void updateS(Product product);

    public int getTotalS();
}
