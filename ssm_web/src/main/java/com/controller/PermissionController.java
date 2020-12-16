package com.controller;

import com.domain.Permission;
import com.domain.Product;
import com.domain.Role;
import com.service.PermissionService;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 10574
 */
@Controller
@RequestMapping("/permission")
@Secured("ROLE_SUPERADMIN")
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
    public String save(Permission permission) {
        permissionService.save(permission);
        return "redirect:/permission/findAll";
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI() {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = permissionService.findParentPermission();
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.setViewName("permission-add");
        return modelAndView;
    }
}
