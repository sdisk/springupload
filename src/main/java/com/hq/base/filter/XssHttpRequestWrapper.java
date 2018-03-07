package com.hq.base.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by huang on 2018/3/7.
 * xss攻击威胁
 */
public class XssHttpRequestWrapper  extends HttpServletRequestWrapper
{
    protected Map parameters;
    public XssHttpRequestWrapper(HttpServletRequest request)
    {
        super(request);
    }
    public void setCharacterEncoding(String encode) throws UnsupportedEncodingException
    {

    }
}
