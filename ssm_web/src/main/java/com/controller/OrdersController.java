package com.controller;

import com.domain.Orders;
import com.domain.Product;
import com.service.OrdersService;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 10574
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll();
        modelAndView.addObject("ordersList", ordersList);
        modelAndView.setViewName("order-list");
        return modelAndView;
    }

    @Autowired
    ProductService productService;

    @RequestMapping("/saveUI")
    public ModelAndView saveUI() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.findAll();
        modelAndView.addObject("productList", productList);
        modelAndView.setViewName("order-add");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Orders orders) {
        ordersService.save(orders);
        return "redirect:/orders/findAll";
    }
}