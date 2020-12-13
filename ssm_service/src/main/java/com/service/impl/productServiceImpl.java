package com.service.impl;

import com.domain.PageBean;
import com.dao.ProductDao;
import com.domain.Product;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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

    @Override
    public void testPageHelper(Integer currPage, Integer pageSize) {
        PageHelper.startPage(currPage, pageSize);
        List<Product> productList = productDao.findAll();
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("总条数:"+pageInfo.getTotal());
        System.out.println("每页条数:"+pageInfo.getPageSize());
        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("数据:"+pageInfo.getList().size());
        System.out.println("上一页:"+pageInfo.getPrePage());
        System.out.println("下一页:"+pageInfo.getNextPage());
        System.out.println("是否第一页:"+pageInfo.isIsFirstPage());
        System.out.println("是否最后一页:"+pageInfo.isIsLastPage());
        System.out.println("页面是展示的第一个页码:"+pageInfo.getNavigateFirstPage());
        System.out.println("页面是展示的最后一个页码:"+pageInfo.getNavigateLastPage());
    }

    @Override
    public PageInfo<Product> findByPageHeper(Integer currPage, Integer pageSize) {
        PageHelper.startPage(currPage, pageSize);
        List<Product> productList = productDao.findAll();
        PageInfo<Product> pageInfo = new PageInfo<>(productList,5);
        return pageInfo;
    }

}
