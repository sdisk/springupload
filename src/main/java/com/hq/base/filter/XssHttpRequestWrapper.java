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
    @Override
    public void setCharacterEncoding(String enc) throws UnsupportedEncodingException
    {
        super.setCharacterEncoding(enc);

        refiltParams();
    }
    void refiltParams(){
        parameters = null;
    }
    @Override
    public String getParameter(String string){
        String [] strList = getParameterValues(string);
        if(strList !=null && strList.length>1){
            return strList[0];
        }else{
            return null;
        }
    }
    @Override
    public String [] getParameterValues(String string){
        if(parameters == null){
            paramXssFilter();
        }
        return (String [] )parameters.get(string);
    }
    @Override
    public Map getParameterMap(){
        if(parameters == null){
            paramXssFilter();
        }
        return parameters;
    }
    private void paramXssFilter(){
        parameters = getRequest().getParameterMap();
        XssSecurityManager.filtRequestParams(parameters, this.getServletPath());
    }
}
