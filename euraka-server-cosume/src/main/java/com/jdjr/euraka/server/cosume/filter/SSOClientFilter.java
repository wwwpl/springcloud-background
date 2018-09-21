package com.jdjr.euraka.server.cosume.filter;


import com.jdjr.euraka.server.cosume.util.SSOClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author wangfei
 * @date 2018/9/20 10:52
 */
@Slf4j
@SpringBootConfiguration
@WebFilter(filterName="SSOClientFilter",urlPatterns="/*")
public class SSOClientFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        log.info("session:{}",session.getAttribute("token"));
        if(!StringUtils.isEmpty(session.getAttribute("token"))) {
            log.info("有权限");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //跳转至sso认证中心
       // res.sendRedirect("http://localhost:18080");
        SSOClientUtil.redirectToSSOURL(req,res);
    }
    @Override
    public void destroy() {

    }
}
