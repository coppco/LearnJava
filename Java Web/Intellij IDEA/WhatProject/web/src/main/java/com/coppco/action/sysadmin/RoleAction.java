package com.coppco.action.sysadmin;

import com.coppco.action.BaseAction;
import com.coppco.domain.Role;
import com.coppco.service.RoleService;
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
@Controller(value = "roleAction")
@Scope(value = "prototype")
public class RoleAction extends BaseAction implements ModelDriven<Role> {
	private Role model = new Role ();
	public Role getModel() {
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

	@Resource(name = "roleService")
	private RoleService roleService;


	
	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		roleService.findPage("from Role", page, Role.class, null);
		
		//设置分页的url地址
		page.setUrl("roleAction_list");
		
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
		Role role = roleService.get(Role.class, model.getId());
		
		//放入栈顶
		super.push(role);
		
		//3.跳页面
		return "toview";
	}
	
	/**
	 * 进入新增页面
	 */
	public String tocreate() throws Exception {

		//调用业务方法

		List<Role> roleList = roleService.find("from Role", Role.class, null);
		//将查询的结果放入值栈中 ,它放在context区域中
		super.put("roleList", roleList);

		return "tocreate";
	}

	public String insert() throws Exception {

		roleService.saveOrUpdate(model);
		//跳页面
		return "alist";
	}
	
	
	/**
	 * 进入修改页面
	 */
	public String toupdate() throws Exception {
		//1.根据id,得到一个对象
		Role obj = roleService.get(Role.class, model.getId());
		
		//2.将对象放入值栈中
		super.push(obj);
		
		//5.跳页面
		return "toupdate";
	}
	
	/**
	 * 修改
	 */
	public String update() throws Exception {
		//调用业务
		Role obj = roleService.get(Role.class, model.getId());//根据id,得到一个数据库中保存的对象
		
		//2.设置修改的属性
		obj.setName(model.getName());
		obj.setRemark(model.getRemark());


		roleService.saveOrUpdate(obj);
		return "alist";
	}

	/**
	 * 批量删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		String [] ids = model.getId().split(", ");
		roleService.delete(Role.class, ids);
		return "alist";
	}
}
