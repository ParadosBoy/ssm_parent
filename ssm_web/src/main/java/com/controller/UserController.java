package com.controller;

import com.domain.Sysuser;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Sysuser> userList = userService.findAll();
        modelAndView.setViewName("user-list");
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Sysuser user) {
        userService.save(user);
        return "redirect:/user/findAll";
    }

    @ResponseBody
    @RequestMapping("/checkUsername")
    public String checkUsername(String username) {
        Sysuser user = userService.findByUsernameCheck(username);
        if (user == null) {
            return "0";
        } else {
            return "1";
        }
    }
}
