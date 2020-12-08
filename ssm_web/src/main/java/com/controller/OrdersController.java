package com.controller;

import com.domain.Orders;
import com.domain.Product;
import com.service.OrdersService;
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
        modelAndView.setViewName("order-List");
        modelAndView.addObject("ordersList", ordersList);
        return modelAndView;
    }
}