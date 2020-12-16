package com.controller;

import com.domain.Role;
import com.domain.Sysuser;
import com.service.RoleService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 10574
 */
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

    @RequestMapping("/details")
    public ModelAndView details(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Sysuser user = userService.findById(id);
        modelAndView.setViewName("user-show");
        modelAndView.addObject("user", user);
        return modelAndView;
    }


    @Autowired
    RoleService roleService;

    @RequestMapping("/addRolesToUserUI")
    public ModelAndView addRolesToUserUI(Integer userId) {
        ModelAndView modelAndView = new ModelAndView();
        Sysuser user = userService.findById(userId);
        System.out.println(user);
        List<Role> roleList = roleService.findAll();
        StringBuilder sb = new StringBuilder();
        for (Role role : user.getRoleList()) {
            sb.append(",");
            sb.append(role.getId());
            sb.append(",");
        }
        modelAndView.addObject("roleList", roleList);
        modelAndView.addObject("str", sb.toString());
        modelAndView.addObject("userId", user.getId());
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    @RequestMapping("/addRolesToUser")
    public String addRolesToUser(Integer userId, Integer[] ids) {
        userService.savaRoleToUser(userId,ids);
        return "redirect:/user/findAll";
    }
}
