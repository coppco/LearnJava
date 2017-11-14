package com.coppco.web.action;

import com.coppco.domain.Customer;
import com.coppco.domain.Dict;
import com.coppco.domain.PageBean;
import com.coppco.service.CustomerService;
import com.coppco.utils.FastJsonUtil;
import com.coppco.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 客户的控制层
 *
 * @author Administrator
 */
@Component(value = "customerAction")
@Scope(value = "prototype")
public class CustomerAction extends BaseAction implements ModelDriven<Customer> {

    private static final long serialVersionUID = 113695314694166436L;

    /**
     * 模型封装, 需要实现ModelDriven接口, 私有化一个model属性, 并且初始化
     */
    private Customer customer = new Customer();

    //默认已经在值栈了, 可以通过它来取
    public Customer getModel() {
        return customer;
    }

    @Resource(name = "customerService")
    private CustomerService customerService;


    /**
     * 接受文件上传
     */

    //上传的文件, 必须和表单里面input的name一样
    private File upload;

    //上传文件的名称
    private String uploadFileName;

    //上传文件的类型(MIME类型)
    private String uploadContentType;

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    /**
     * 保存客户的方法
     *
     * @return
     */
    public String save() throws IOException {
        System.out.println("WEB层：保存客户...");
        /*// WEB的工厂
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
		CustomerService cs = (CustomerService) context.getBean("customerService");
		// 调用方法
		cs.save(customer);*/

        //文件
        if (null != uploadFileName) {
            String fileName = UploadUtils.getUUIDName(uploadFileName);
            File file = new File("/Users/apple/Tomcat8/webapps/upload/" + fileName);
            FileUtil.copyFile(upload, file);
            customer.setFilePath(file.getAbsolutePath());
        }
        customerService.save(customer);

        return "save";
    }

    /**
     * 属性驱动, 当前页
     */
    private Integer pageCode = 1;

    public void setPageCode(Integer pageCode) {
        if (pageCode == null) {
            pageCode = 1;
        }
        this.pageCode = pageCode;
    }

    /**
     * 属性驱动, 每页显示数据条数
     */
    private Integer pageSize = 10;

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 10;
        }
        this.pageSize = pageSize;
    }

    /**
     * 分页查询
     *
     * @return
     */
    public String findByPage() {
        //值栈
        ValueStack valueStack = ActionContext.getContext().getValueStack();

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);

        //拼接查询条件
        //用户名
        String cust_name = customer.getCust_name();
        if (null != cust_name && !cust_name.trim().isEmpty()) {
            detachedCriteria.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
        }

        //用户来源
        Dict source = customer.getSource();
        if (null != source && !source.getDict_id().trim().isEmpty()) {
            detachedCriteria.add(Restrictions.eq("source.dict_id", source.getDict_id()));
        }
        //用户级别
        Dict level = customer.getLevel();
        if (null != level && !level.getDict_id().trim().isEmpty()) {
            detachedCriteria.add(Restrictions.eq("level.dict_id", level.getDict_id()));
        }

        PageBean<Customer> page = customerService.findByPage(pageCode, pageSize, detachedCriteria);
        //压栈
        valueStack.set("page", page);
        return "page";
    }

    /**
     * 初始化到添加页面
     * @return
     */
    public String initADD() {

        return "initADD";
    }

    /**
     * 删除客户
     * @return
     */
    public String delete() {

        //查询客户
        Customer c = customerService.findById(customer.getCust_id());

        if (null != c) {
            String fileName = c.getFilePath();

            //删除用户
            customerService.delete(c);

            if (fileName != null){
                File file = new File(fileName);
                if (file.exists()) file.delete();
            }

        }

        return "delete";
    }

    /**
     * 修改初始化方法
     * @return
     */
    public String initUpdate() {
        customer = customerService.findById(customer.getCust_id());
        return "initUpdate";
    }

    /**
     * 修改客户方法
     * @return
     */
    public String update() throws IOException {
        //文件
        if (null != uploadFileName) {
            //删除旧图片
            String oldFile = customer.getFilePath();
            if (oldFile != null && !oldFile.trim().isEmpty()) {
                File file = new File(oldFile);
                file.delete();
            }

            //上传图片
            File newFile = new File("/Users/apple/Tomcat8/webapps/upload/" + UploadUtils.getUUIDName(uploadFileName));
            FileUtil.copyFile(upload ,newFile);

            customer.setFilePath(newFile.getAbsolutePath());
        }

        //更新客户信息
        customerService.update(customer);

        return "update";
    }

    public String findAll() throws IOException {
        List<Customer> list = customerService.findAll();

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;utf-8");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().print(FastJsonUtil.toJSONString(list));
        return NONE;
    }


}












