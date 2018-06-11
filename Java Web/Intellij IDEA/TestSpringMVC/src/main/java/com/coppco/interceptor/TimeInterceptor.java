package com.coppco.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    /**
     * 请求发生前执行
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        long timeMillis = System.currentTimeMillis();
        httpServletRequest.setAttribute("startTime", timeMillis);
        return true;
    }

    /**
     * 请求完成后但是视图未返回前执行
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        long startTime = (long) httpServletRequest.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("本次请求时间: " + (endTime - startTime) + " ms");
    }

    /**
     * 请求完成后视图返回后执行, 可以获取异常、资源处理
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
