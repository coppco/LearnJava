package com.coppco.controller;

import com.coppco.pojo.TbItem;
import com.coppco.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/*
 * 商品管理Controller
 */

@Controller
public class ItemController {

    @Resource(name = "itemServiceImpl")
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {
        System.out.println(itemService.getClass());
        TbItem item = itemService.getItemById(itemId);
        System.out.println(item.getId());
        return item;
    }

}
