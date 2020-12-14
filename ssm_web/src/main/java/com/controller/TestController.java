package com.controller;

import javax.servlet.http.*;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Security;
import java.util.Enumeration;

/**
 * @author 10574
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/showUsername")
    public void showUsername(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Enumeration attributeNames = session.getAttributeNames();
        /*while (attributeNames.hasMoreElements()){
            System.out.println(attributeNames.nextElement());
        }*/
        Object o = session.getAttribute("SPRING_SECURITY_CONTEXT");
        SecurityContext securityContext = (SecurityContext) o;
        Authentication authentication = securityContext.getAuthentication();
        Object principal = authentication.getPrincipal();
        User user = (User) principal;
        String username = user.getUsername();

        SecurityContext securityContext1 = SecurityContextHolder.getContext();
        System.out.println(securityContext1 == securityContext);
    }
}
