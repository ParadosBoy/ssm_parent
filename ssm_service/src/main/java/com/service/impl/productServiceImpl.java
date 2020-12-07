package com.service.impl;

import com.dao.ProductDao;
import com.domain.Product;
import com.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author 10574
 */
@Service
public class productServiceImpl implements productService {
    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
    public void save(Product product){
        productDao.save(product);
    }

}
