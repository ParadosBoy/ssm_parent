package com.controller;

import com.domain.Permission;
import com.domain.Role;
import com.domain.Sysuser;
import com.service.PermissionService;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 10574
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        modelAndView.setViewName("role-list");
        modelAndView.addObject("roleList", roleList);
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:/role/findAll";
    }

    @Autowired
    PermissionService permissionService;

    @RequestMapping("/addPermissionsToRoleUI")
    public ModelAndView addPermissionsToRoleUI(Integer roleId) {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        Role role = roleService.findById(roleId);
        StringBuilder sb = new StringBuilder();
        for (Permission permission : role.getPermissionList()) {
            sb.append(",");
            sb.append(permission.getId());
            sb.append(",");
        }
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.addObject("str", sb.toString());
        modelAndView.addObject("roleId", role.getId());
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    @RequestMapping("/addPermissionsToRole")
    public String addPermissionsToRole(Integer roleId, Integer[] ids) {
        roleService.savePermissionsToRole(roleId, ids);
        return "redirect:/role/findAll";
    }
}
