package com.coppco.action.sysadmin;

import com.coppco.action.BaseAction;
import com.coppco.domain.Dept;
import com.coppco.domain.User;
import com.coppco.service.DeptService;
import com.coppco.service.UserService;
import com.coppco.utils.Page;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户的Action
 * @author Administrator
 *
 */
@Controller(value = "userAction")
@Scope(value = "prototype")
public class UserAction extends BaseAction implements ModelDriven<User> {
	private User model = new User();
	public User getModel() {
		return model;
	}
	
	//分页查询
	private Page page  = new Page();
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "deptService")
	private DeptService deptService;

	
	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		userService.findPage("from User", page, User.class, null);
		
		//设置分页的url地址
		page.setUrl("userAction_list");
		
		//将page对象压入栈顶
		super.push(page);

		return "list";
	}
	
	/**
	 * 查看
	 *     id=rterytrytrytr
	 * model对象
	 *      id属性：rterytrytrytr
	 */
	public String toview() throws Exception {
		//1.调用业务方法，根据id,得到对象
		User user = userService.get(User.class, model.getId());
		
		//放入栈顶
		super.push(user);
		
		//3.跳页面
		return "toview";
	}
	
	/**
	 * 进入新增页面
	 */
	public String tocreate() throws Exception {

		//调用业务方法
		List<Dept> deptList = deptService.find("from Dept where state= 1", Dept.class,null);
		super.put("deptList", deptList);

		List<User> userList = userService.find("from User where state = 1", User.class, null);
		//将查询的结果放入值栈中 ,它放在context区域中
		super.put("userList", userList);

		return "tocreate";
	}

	public String insert() throws Exception {

		userService.saveOrUpdate(model);
		//跳页面
		return "alist";
	}
	
	
	/**
	 * 进入修改页面
	 */
	public String toupdate() throws Exception {
		//1.根据id,得到一个对象
		User obj = userService.get(User.class, model.getId());
		
		//2.将对象放入值栈中
		super.push(obj);
		
		//3.查询父部门
		List<Dept> deptList = deptService.find("from Dept where state = 1", Dept.class, null);

		deptList.remove(obj);

		//4.将查询的结果放入值栈中 ,它放在context区域中
		super.put("deptList", deptList);
		
		//5.跳页面
		return "toupdate";
	}
	
	/**
	 * 修改
	 */
	public String update() throws Exception {
		//调用业务
		User obj = userService.get(User.class, model.getId());//根据id,得到一个数据库中保存的对象
		
		//2.设置修改的属性
		obj.setDept(model.getDept());
		obj.setUserName(model.getUserName());
		obj.setState(model.getState());
		userService.saveOrUpdate(obj);
		return "alist";
	}

	/**
	 * 批量删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		String [] ids = model.getId().split(", ");
		userService.delete(User.class, ids);
		return "alist";
	}
}
