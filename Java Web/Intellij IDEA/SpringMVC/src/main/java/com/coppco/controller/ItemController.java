package com.coppco.controller;

import com.coppco.pojo.Items;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
//@Repository
//@Service
//@Component
public class ItemController {

    @RequestMapping("/list") //配置访问路径
    public ModelAndView itemList() throws Exception {

        List<Items> itemList = new ArrayList<Items>();

        //商品列表
        Items items_1 = new Items();
        items_1.setName("联想笔记本_3");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
        items_1.setCreatetime(new Date());

        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6苹果手机！");
        items_2.setCreatetime(new Date());

        itemList.add(items_1);
        itemList.add(items_2);

        //创建modelandView对象
        ModelAndView modelAndView = new ModelAndView();

        //添加model
        modelAndView.addObject("itemList", itemList);

        //添加视图
        modelAndView.setViewName("/WEB-INF/jsp/itemList.jsp");

        return modelAndView;

    }
}
