package com.controller;

import com.domain.Permission;
import com.domain.Role;
import com.service.PermissionService;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 10574
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        modelAndView.setViewName("permission-list");
        modelAndView.addObject("permissionList", permissionList);
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role) {
        permissionService.save(role);
        return "redirect:/permission/findAll";
    }
}
