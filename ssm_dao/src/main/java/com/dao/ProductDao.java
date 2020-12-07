package com.dao;

import com.domain.Product;

import java.util.List;

/**
 * @author 10574
 */
public interface ProductDao {
     List<Product> findAll();

     void save(Product product);
}
