package com.log;

import com.domain.Log;
import com.domain.Role;
import com.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 10574
 */
@Aspect
@Component
@Controller
@RequestMapping("/pages")
public class LogController {

    @Autowired
    HttpServletRequest request;
    @Autowired
    LogService logService;


    @Pointcut("execution(* com.controller.*.*(..))")
    public void pc() {
    }

    @Before("pc()")
    public void before(JoinPoint joinPoint) {
        Log log = new Log();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(date);
        log.setVisitTime(str);
        //获取安全框架上下文对象
        SecurityContext securityContext = SecurityContextHolder.getContext();
        //获取认证对象
        Authentication authentication = securityContext.getAuthentication();
        //获取用户对象
        Object obj = authentication.getPrincipal();
        User user = (User) obj;
        //获取用户名
        String username = user.getUsername();
        log.setUsername(username);
        //获取IP地址
        String ip = request.getRemoteAddr();
        log.setIp(ip);
        //获取目标对象
        Object target = joinPoint.getTarget();
        //获取类全名
        String classname = target.getClass().getName();
        //获取方法名称
        String methodname = joinPoint.getSignature().getName();
        log.setMethod(classname + "." + methodname);
        logService.save(log);
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Log> logList = logService.findAll();
        modelAndView.setViewName("syslog-list");
        modelAndView.addObject("logList", logList);
        return modelAndView;
    }
}
