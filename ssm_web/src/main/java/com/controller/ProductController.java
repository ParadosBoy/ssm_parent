package com.controller;

import com.domain.Product;
import com.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 10574
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    productService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.findAll();
        modelAndView.setViewName("product-list");
        modelAndView.addObject("productList", productList);
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
}
