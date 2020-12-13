package com.service;

import com.domain.PageBean;
import com.domain.Product;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 10574
 */
public interface ProductService {




    List<Product> findAll();

    Product findById(Integer id);

    void update(Product product);


    void save(Product product);

    void delOne(Integer id);

    void delMany(Integer[] ids);


    PageBean<Product> findByPage(Integer currPage, Integer pageSize);

    void testPageHelper(Integer currPage, Integer pageSize);

    PageInfo<Product> findByPageHeper(Integer currPage, Integer pageSize);
}
