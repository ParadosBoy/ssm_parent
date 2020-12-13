package com.dao;

import com.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 10574
 */
public interface ProductDao {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update(Product product);

    void delete(Integer id);

    Integer findTotalCount();

    List<Product> findByPage(Integer startIndex, Integer pageSize);
}
