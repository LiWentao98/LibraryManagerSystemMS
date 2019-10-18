package com.MtLi.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 统一设置字符格式
 * @Author: Mt.Li
*/
public class EncodingFilter implements Filter {
    private String encoding = "UTF-8";

    public void init(FilterConfig filterConfig) throws ServletException {
        if(filterConfig.getInitParameter("encoding") != null){
            encoding = filterConfig.getInitParameter("encoding");
        }
    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        filterChain.doFilter(request,response);
    }


    public void destroy() {

    }
}
