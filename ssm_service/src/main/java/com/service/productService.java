package com.service;

import com.domain.Product;

import java.util.List;

/**
 * @author 10574
 */
public interface productService {

    static void save(Product product) {
    }

    List<Product> findAll();
}
