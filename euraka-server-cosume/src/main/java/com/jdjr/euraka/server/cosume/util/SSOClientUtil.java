package com.jdjr.euraka.server.cosume.util;

/**
 * @author wangfei
 * @date 2018/9/20 11:20
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ConfigurationProperties
public class SSOClientUtil {

    public static String SERVER_URL_PREFIX="http://localhost:8080";//统一认证中心地址:http://www.sso.com:8443,在sso.properties配置
    public static String CLIENT_HOST_URL="http://localhost:10003";//当前客户端地址:http://www.crm.com:8088,在sso.properties配置
    /**
     * 当客户端请求被拦截,跳往统一认证中心,需要带redirectUrl的参数,统一认证中心登录后回调的地址
     * 通过Request获取这次请求的地址 http://www.crm.com:8088/main
     *
     * @param request
     * @return
     */
    public static String getRedirectUrl(HttpServletRequest request){
        //获取请求URL
        return CLIENT_HOST_URL+request.getServletPath();
    }
    /**
     * 根据request获取跳转到统一认证中心的地址 http://www.sso.com:8443//checkLogin?redirectUrl=http://www.crm.com:8088/main
     * 通过Response跳转到指定的地址
     * @param request
     * @param response
     * @throws IOException
     */
    public static void redirectToSSOURL(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String redirectUrl = getRedirectUrl(request);
        StringBuilder url = new StringBuilder(50)
                .append(SERVER_URL_PREFIX)
                .append("/checkLogin?redirectUrl=")
                .append(redirectUrl);
        log.info("跳转路径:"+url.toString());
        response.sendRedirect(url.toString());
    }


    /**
     * 获取客户端的完整登出地址
     * @return
     */
    public static String getClientLogOutUrl(){
        return CLIENT_HOST_URL+"/logOut";
    }
    /**
     * 获取认证中心的登出地址
     * @return
     */
    public static String getServerLogOutUrl(){
        return SERVER_URL_PREFIX+"/logOut";
    }

}
