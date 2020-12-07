package com.dao;

import com.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 10574
 */
public interface ProductDao {
     List<Product> findAll();
     static void save(Product product) {

     };
}
