package com.hq.base.filter;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

/**
 * Created by huang on 2018/3/7.
 */
@Configuration //使用Configuration注解将自定义filter加入过滤链
public class WebConfiguration
{
    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }
    @Bean
    public FilterRegistrationBean testFilterRegistration(){
        FilterRegistrationBean filterRegistrationBean =  new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("paramName", "paramValue");
        filterRegistrationBean.setName("MyFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
    public class MyFilter implements Filter
    {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException
        {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
        {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            XssHttpRequestWrapper xssRequrst = new XssHttpRequestWrapper(request);
            request = XssSecurityManager.wrapRequest(xssRequrst);
            filterChain.doFilter(request,servletResponse);
        }

        @Override
        public void destroy()
        {

        }
    }
}
