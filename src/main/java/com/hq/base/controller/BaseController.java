package com.hq.base.controller;

import com.hq.constant.WebConst;
import com.hq.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * Created by huang on 2018/3/9.
 */
@Controller
public class BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    public static final String ENCODE_GBK = "GBK";
    public static final String ENCODE_UTF8 = "UTF-8";

    /**
     * ThreadLocal确保高并发下每个请求的request，response都是独立的
     */
    private static ThreadLocal<HttpServletRequest> currentRequest = new ThreadLocal<>();
    private static ThreadLocal<HttpServletResponse> currentResponse = new ThreadLocal<>();

    public static String THEME = "themes/default";

    /**
     * 线程安全初始化reque，respose对象
     *
     * @param request
     * @param response
     * @throws UnsupportedEncodingException
     */
    @ModelAttribute
    public void initReqAndRes(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException

    {
        currentRequest.set(request);
        currentResponse.set(response);
    }
    public HttpServletRequest request(){
        return (HttpServletRequest)currentRequest.get();
    }
    public HttpServletResponse response(){
        return (HttpServletResponse)currentResponse.get();
    }

    public User getUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(null == session){
            return null;
        }
        return (User)session.getAttribute(WebConst.LOGIN_SESSION_KEY);
    }
    public String getUserId(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(null == session){
            return "";
        }
        User user = (User)session.getAttribute(WebConst.LOGIN_SESSION_KEY);
        return user.getId().toString();
    };


}
