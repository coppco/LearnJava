package com.coppco.sso.controller;

import com.coppco.common.pojo.TaotaoResult;
import com.coppco.common.utils.CookieUtils;
import com.coppco.common.utils.JsonUtils;
import com.coppco.pojo.TbUser;
import com.coppco.sso.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 检测用户名手机号邮箱是否可用
     * @param param
     * @param type
     * @return
     */
    @RequestMapping("/check/{param}/{type}")
    @ResponseBody
    public TaotaoResult checkUserData(@PathVariable String param, @PathVariable int type) {
        return userService.checkUserData(param, type);
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value="/register", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult userRegister(TbUser user) {
        return userService.userRegister(user);
    }


    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult login(HttpServletRequest request, HttpServletResponse response,TbUser user) {

        TaotaoResult result = userService.login(user.getUsername(), user.getEmail());
        if (result.getStatus() == 200) {
            //Token写入cookies
            CookieUtils.setCookie(request, response, "token", (String)result.getData());
        }
        return result;
    }

//    /**
//     *
//     * @param token 令牌
//     * @return
//     */
//    @RequestMapping(value = "/token/{token}", method = RequestMethod.GET,
//            //指定返回的类型 json
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
//    public String getUserByToken(@PathVariable String token, String callback) {
//        TaotaoResult result = userService.getUserByToken(token);
//        if (StringUtils.isNoneBlank(callback)) {
//            return callback + "(" + JsonUtils.objectToJson(result) + ")";
//        }
//        return JsonUtils.objectToJson(result);
//
//    }

    /**
     * spring4.1以后版本还可以这样写
     * @param token 令牌
     * @return
     */
    @RequestMapping(value = "/token/{token}", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserByToken(@PathVariable String token, String callback) {
        TaotaoResult result = userService.getUserByToken(token);
        if (StringUtils.isNoneBlank(callback)) {
            MappingJacksonValue value = new MappingJacksonValue(result);
            //设置回调方法
            value.setJsonpFunction(callback);
            return value;
        }
        return result;

    }

    /**
     * 安全退出
     * @param token
     * @return
     */
    @RequestMapping(value = "/logout/{token}")
    @ResponseBody
    public TaotaoResult logout(@PathVariable String token) {
        return userService.logoutByToken(token);
    }


}
