package com.coppco.action;


import com.coppco.domain.User;
import com.coppco.utils.SysConstant;
import com.coppco.utils.UtilFuns;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Description: 登录和退出类
 * @Author:		传智播客 java学院	传智.宋江
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月31日
 */

@Component(value = "loginAction")
@Scope(value = "prototype")
public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;



	//SSH传统登录方式
	public String login() throws Exception {
		
//		if(true){
//			String msg = "登录错误，请重新填写用户名密码!";
//			this.addActionError(msg);
//			throw new Exception(msg);
//		}
//		User user = new User(username, password);
//		User login = userService.login(user);
//		if (login != null) {
//			ActionContext.getContext().getValueStack().push(user);
//			session.put(SysConstant.CURRENT_USER_INFO, login);	//记录session
//			return SUCCESS;
//		}
//		return "login";

		if (UtilFuns.isEmpty(username)){
			return "login";
		}

		try {
			//得到subject
			Subject subject = SecurityUtils.getSubject();
			//登录方法
			System.out.println("登录");
			subject.login(new UsernamePasswordToken(username, password));//会自动跳到AuthRealm中的认证方法

			//登录成功时, 从shiro中取出用户的登录信息
			User user = (User) subject.getPrincipal();
			session.put(SysConstant.CURRENT_USER_INFO, user);
		} catch (Exception e) {
			System.out.print(e);
			request.put("errorInfo", "对不起, 用户名或者密码错误!");
			return "login";
		}

		return SUCCESS;
	}
	
	
	//退出
	public String logout(){
		session.remove(SysConstant.CURRENT_USER_INFO);		//删除session
		
		return "logout";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

