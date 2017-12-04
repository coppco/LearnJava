package com.coppco.action.cargo;

import com.coppco.action.BaseAction;
import com.coppco.domain.Contract;
import com.coppco.service.ContractService;
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
@Controller(value = "contractAction")
@Scope(value = "prototype")
public class ContractAction extends BaseAction implements ModelDriven<Contract> {
	private Contract model = new Contract ();
	public Contract getModel() {
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

	@Resource(name = "contractService")
	private ContractService contractService;


	
	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		contractService.findPage("from Contract", page, Contract.class, null);
		
		//设置分页的url地址
		page.setUrl("contractAction_list");
		
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
		Contract contract = contractService.get(Contract.class, model.getId());
		
		//放入栈顶
		super.push(contract);
		
		//3.跳页面
		return "toview";
	}
	
	/**
	 * 进入新增页面
	 */
	public String tocreate() throws Exception {

		//调用业务方法

		List<Contract> contractList = contractService.find("from Contract", Contract.class, null);
		//将查询的结果放入值栈中 ,它放在context区域中
		super.put("contractList", contractList);

		return "tocreate";
	}

	public String insert() throws Exception {

		contractService.saveOrUpdate(model);
		//跳页面
		return "alist";
	}
	
	
	/**
	 * 进入修改页面
	 */
	public String toupdate() throws Exception {
		//1.根据id,得到一个对象
		Contract obj = contractService.get(Contract.class, model.getId());
		
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
		Contract obj = contractService.get(Contract.class, model.getId());//根据id,得到一个数据库中保存的对象
		
		//2.设置修改的属性


		contractService.saveOrUpdate(obj);
		return "alist";
	}

	/**
	 * 批量删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		String [] ids = model.getId().split(", ");
		contractService.delete(Contract.class, ids);
		return "alist";
	}
}
