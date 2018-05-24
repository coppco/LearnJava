package com.coppco.order.interceptor;

import com.coppco.common.pojo.TaotaoResult;
import com.coppco.common.utils.CookieUtils;
import com.coppco.common.utils.JsonUtils;
import com.coppco.pojo.TbUser;
import com.coppco.sso.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 判断用户是否登录的拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Value("${TOKEN_COOKIE_KEY}")
    private String TOKEN_COOKIE_KEY;

    @Value("${REDIRECT_ADDRESS}")
    private String REDIRECT_ADDRESS;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handle) throws Exception {
        //在handle之前运行该方法, 返回false则拦截请求

        //从Cookie中取token
        String token = CookieUtils.getCookieValue(httpServletRequest, TOKEN_COOKIE_KEY);

        //没有token   跳转到 sso登录页面, 登录成功后需要回到该页面
        if (StringUtils.isBlank(token)) {
            httpServletResponse.sendRedirect(REDIRECT_ADDRESS + "/page/login?url=" + httpServletRequest.getRequestURL().toString());
            return false;
        }

        //有token,  redis中没有用户信息 调到登录页面
        TaotaoResult result = userService.getUserByToken(token);

        if (result.getStatus() != 200) {
            httpServletResponse.sendRedirect(REDIRECT_ADDRESS + "/page/login?url=" + httpServletRequest.getRequestURL().toString());
            return false;
        }
        httpServletRequest.setAttribute("user", result.getData());
        //取到用户信息 放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handle, ModelAndView modelAndView) throws Exception {
        //在handle执行之后, modelAndView返回之前
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handle, Exception e) throws Exception {
        //在modelAndView返回之后
    }
}
