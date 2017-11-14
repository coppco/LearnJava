package com.coppco.web.action;

import com.alibaba.fastjson.JSON;
import com.coppco.domain.Dict;
import com.coppco.service.DictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller(value = "dictAction")
@Scope(value = "prototype")
public class DictAction extends ActionSupport implements ModelDriven<Dict> {
    private Dict dict = new Dict();

    @Override
    public Dict getModel() {
        return dict;
    }


    @Resource(name = "dictService")
    private DictService dictService;


    /**
     * 根据code查询 字典
     * @return
     */
    public String findByCode() {

        List<Dict> list = dictService.findByCode(dict.getDict_type_code());

        HttpServletResponse response = ServletActionContext.getResponse();

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;utf-8");
        try {
            response.getWriter().print(JSON.toJSONString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return NONE;
    }
}
