package com.mtli.lms.librarymanager.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description: 登录限制拦截器
 * @Author: Mt.Li
*/
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        /*
        登录前的操作
         */
        //获取路径
        String url = httpServletRequest.getRequestURI();
        //检查是否有包含“login”关键字(去登录允许放过)
        if(url.toLowerCase().indexOf("login")>=0){//将字母都转换成小写，如果没有则返回-1
            return true;
        }

        //访问其他路径有没有登录
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("reader")!=null){//已登录
            return true;
        }

        //其他情况都是没有登录的，不允许通过
        httpServletResponse.sendRedirect("/reader/to_login");
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
