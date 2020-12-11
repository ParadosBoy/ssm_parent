package com.service.impl;

import com.controller.PageBean;
import com.dao.ProductDao;
import com.domain.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10574
 */
@Service
public class productServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void delOne(Integer id) {
        productDao.delete(id);
    }

    @Override
    public void delMany(Integer[] ids) {
        if (ids != null) {
            for (Integer id : ids) {
                productDao.delete(id);
            }
        }
    }

    @Override
    public PageBean<Product> findByPage(Integer currPage, Integer pageSize) {
        PageBean<Product> pageBean = new PageBean<>();
        pageBean.setCurrPage(currPage);
        pageBean.setPageSize(pageSize);
        Integer totalCount = productDao.findTotalCount();
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));
        Integer startIndex = (currPage - 1) * pageSize;
        List<Product> productList = productDao.findByPage(startIndex, pageSize);
        pageBean.setList(productList);
        return pageBean;
    }

}
