package com.coppco.action.cargo;

import com.coppco.action.BaseAction;
import com.coppco.domain.ContractProduct;
import com.coppco.domain.Factory;
import com.coppco.service.ContractProductService;
import com.coppco.service.FactoryService;
import com.coppco.utils.Page;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Controller(value = "contractProductAction")
@Scope(value = "prototype")
public class ContractProductAction extends BaseAction implements ModelDriven<ContractProduct> {
    private ContractProduct model = new ContractProduct();

    public ContractProduct getModel() {
        return model;
    }

    //分页查询
    private Page page = new Page();

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Resource(name = "contractProductService")
    private ContractProductService contractProductService;

    @Resource(name = "factoryService")
    private FactoryService factoryService;


    /**
     * 进入新增页面
     */
    public String tocreate() throws Exception {
        //查询生产厂家
        List<Factory> factoryList = factoryService.find("from Factory where CTYPE = '货物' and state = 1", Factory.class, null);

        //存值栈
        super.put("factoryList", factoryList);

        //查询当前合同下的货物列表
        Page<ContractProduct> contractProduct = contractProductService.findPage("from ContractProduct where contract_id = ?", page, ContractProduct.class, new String[]{model.getContract().getId()});

        contractProduct.setUrl("contractProductAction_tocreate");
        //存栈顶
        super.push(contractProduct);
        return "tocreate";
    }

    public String insert() throws Exception {

        //购销合同总金额要变化

        contractProductService.saveOrUpdate(model);
        //跳页面
        return "tocreate";
    }


    /**
     * 进入修改页面
     */
    public String toupdate() throws Exception {
        //1.根据id,得到一个对象
        ContractProduct obj = contractProductService.get(ContractProduct.class, model.getId());

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
        ContractProduct obj = contractProductService.get(ContractProduct.class, model.getId());//根据id,得到一个数据库中保存的对象

        //2.设置修改的属性

        contractProductService.saveOrUpdate(obj);
        return "alist";
    }

    /**
     * 批量删除
     *
     * @return
     * @throws Exception
     */
    public String delete() throws Exception {

        contractProductService.delete(ContractProduct.class,model);
        return "tocreate";
    }

}
