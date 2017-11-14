package com.coppco.web.action;


import com.coppco.HJLog;
import com.coppco.domain.User;
import com.coppco.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component(value = "userAction")
@Scope(value = "prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    @Resource(name = "userService")
    private UserService userService;

    /**
     * 注册
     *
     * @return
     */
    public String regist() {
        HJLog.logger.info("======注册======" + user);
        userService.saveUser(user);
        return LOGIN;
    }

    /**
     * 通过登录名来校验登录名是否存在
     *
     * @return
     */
    public String checkCode() {
        User selectUser = userService.checkCode(user.getUser_code());

        //获取Response
        HttpServletResponse response = ServletActionContext.getResponse();

        //设置编码
        response.setContentType("text/html;charset=UTF-8");

        //获取输出流
        try {
            PrintWriter writer = response.getWriter();
            if (null == selectUser) {
                HJLog.logger.info("可以注册!");
                writer.print("yes");
            } else {
                HJLog.logger.info("已经注册!");
                writer.print("no");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return NONE;
    }

    public String login() {
        String v_code = ServletActionContext.getRequest().getParameter("v_code");
        String s_code = (String) ServletActionContext.getRequest().getSession().getAttribute("MSG");
        HJLog.logger.info(v_code.toLowerCase() + "=====" + s_code.toLowerCase());
        if (v_code.toLowerCase().equals(s_code.toLowerCase())) {
            ServletActionContext.getRequest().getSession().removeAttribute("MSG");
            //登录
            User loginUser = userService.login(user);
            if (null == loginUser) {
                return LOGIN;
            } else {
                ServletActionContext.getRequest().getSession().setAttribute("existUser", loginUser);
                return "loginOK";
            }
        } else {
//            ServletActionContext.getRequest().getSession().removeAttribute("MSG");
            return ERROR;
        }
    }

    public String logout() {
        ServletActionContext.getRequest().getSession().removeAttribute("existUser");
        return LOGIN;
    }

}
