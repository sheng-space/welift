package com.example.demo.token;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 拦截器拦截token
 * @author sheng
 * @date 2019/11/22
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    private String tokenStr = "token";

    @Autowired
    private TokenManager tokenManager;

    /**
     * 在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制等处理；
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        NoLogin annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(NoLogin.class);
        }else{
            return true;
        }

        //如果有@AuthIgnore注解，则不验证token
        if(annotation != null){
            return true;
        }

        //获取用户凭证
        String token = request.getHeader(tokenStr);
        if(StringUtils.isBlank(token)){
            token = request.getParameter(tokenStr);
        }
        if(StringUtils.isBlank(token)){
            Object obj = request.getAttribute(tokenStr);
            if(null!=obj){
                token=obj.toString();
            }
        }

        //token凭证为空
        if(StringUtils.isBlank(token)){
            returnJson(response, "token不能为空");
            return false;
        }else{
            try{
                String userinfo = tokenManager.getUserInfoByToken(token);
                if(userinfo == null){
                    returnJson(response, "登录已失效");
                    return false;
                }
                System.out.println("userinfo:"+userinfo+handler.toString());
            }catch (Exception e){
                e.printStackTrace();
                returnJson(response, "登录已失效");
                return false;
            }
        }
        return true;
    }

    /**
     * 在业务处理器处理请求执行完成后，生成视图之前执行。后处理（调用了Service并返回ModelAndView，但未进行页面渲染），有机会修改
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。返回处理（已经渲染了页面），可以根据ex是否为null判断是否发生了异常，进行日志记录；
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private void returnJson(HttpServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
