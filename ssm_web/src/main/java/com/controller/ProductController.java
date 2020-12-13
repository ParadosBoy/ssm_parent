package com.controller;

import com.domain.PageBean;
import com.domain.Product;
import com.github.pagehelper.PageInfo;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 10574
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @RequestMapping("/findAll")
    public ModelAndView findAll(
            @RequestParam(value = "currPage", required = false, defaultValue = "1") Integer currPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Product> pageInfo = productService.findByPageHeper(currPage, pageSize);
        modelAndView.setViewName("product-list");
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }

    @RequestMapping("/findAll3")
    public ModelAndView findAll3(
            @RequestParam(value = "currPage", required = false, defaultValue = "1") Integer currPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        PageBean<Product> pageBean = productService.findByPage(currPage, pageSize);
        modelAndView.setViewName("product-list");
        modelAndView.addObject("pageBean", pageBean);
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Product product) {
        productService.save(product);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/updateUI")
    public ModelAndView updateUI(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        modelAndView.setViewName("product-update");
        return modelAndView;
    }

    @RequestMapping("/update")
    public String uodate(Product product) {
        productService.update(product);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/delOne")
    public String delOne(Integer id) {
        productService.delOne(id);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/delMany")
    public String delMany(Integer[] ids) {
        productService.delMany(ids);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/findAll2")
    public ModelAndView findAll2() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.findAll();
        modelAndView.setViewName("product-list");
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }
}
