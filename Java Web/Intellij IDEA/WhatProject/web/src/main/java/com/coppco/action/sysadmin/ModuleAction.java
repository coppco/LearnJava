package com.coppco.action.sysadmin;

import com.coppco.action.BaseAction;
import com.coppco.domain.Module;
import com.coppco.domain.Role;
import com.coppco.service.ModuleService;
import com.coppco.service.RoleService;
import com.coppco.utils.Page;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author Administrator
 *
 */
@Controller(value = "moduleAction")
@Scope(value = "prototype")
public class ModuleAction extends BaseAction implements ModelDriven<Module> {
	private Module model = new Module ();
	public Module getModel() {
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

	@Resource(name = "moduleService")
	private ModuleService moduleService;


	
	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		moduleService.findPage("from Module", page, Module.class, null);
		
		//设置分页的url地址
		page.setUrl("moduleAction_list");
		
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
		Module module = moduleService.get(Module.class, model.getId());
		
		//放入栈顶
		super.push(module);
		
		//3.跳页面
		return "toview";
	}
	
	/**
	 * 进入新增页面
	 */
	public String tocreate() throws Exception {

		//调用业务方法

		List<Module> moduleList = moduleService.find("from Module", Module.class, null);
		//将查询的结果放入值栈中 ,它放在context区域中
		super.put("moduleList", moduleList);

		return "tocreate";
	}

	public String insert() throws Exception {

		moduleService.saveOrUpdate(model);
		//跳页面
		return "alist";
	}
	
	
	/**
	 * 进入修改页面
	 */
	public String toupdate() throws Exception {
		//1.根据id,得到一个对象
		Module obj = moduleService.get(Module.class, model.getId());
		
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
		Module obj = moduleService.get(Module.class, model.getId());//根据id,得到一个数据库中保存的对象
		
		//2.设置修改的属性
		obj.setName(model.getName());
		obj.setLayerNum(model.getLayerNum());
		obj.setCpermission(model.getCpermission());
		obj.setCurl(model.getCurl());
		obj.setCtype(model.getCtype());
		obj.setState(model.getState());
		obj.setBelong(model.getBelong());
		obj.setCwhich(model.getCwhich());
		obj.setRemark(model.getRemark());
		obj.setOrderNo(model.getOrderNo());

		moduleService.saveOrUpdate(obj);
		return "alist";
	}

	/**
	 * 批量删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		String [] ids = model.getId().split(", ");
		moduleService.delete(Module.class, ids);
		return "alist";
	}
}
