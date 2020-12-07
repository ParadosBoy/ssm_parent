package com.controller;

import com.domain.Product;
import com.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private productService productService;

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
        com.service.productService.save(product);
        return "redirect:/product/findAll";
    }
}
