package com.coppco.controller;

import com.coppco.common.pojo.EasyUIDataGridResult;
import com.coppco.common.pojo.TaotaoResult;
import com.coppco.pojo.TbItem;
import com.coppco.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;



/**
 * 商品管理Controller
 */

@Controller
public class ItemController {

    @Resource
    private ItemService itemService;

    /**
     * 根据商品id查询
     * @param itemId
     * @return
     */
    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {
        System.out.println(itemService.getClass());
        TbItem item = itemService.getItemById(itemId);
        System.out.println(item.getId());
        return item;
    }

    /**
     * 分页显示商品列表
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult list(Integer page, Integer rows) {
        return itemService.getItemList(page, rows);
    }


    @RequestMapping(value = "/item/save", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult saveItem(TbItem item, String desc) {
        return itemService.addItem(item, desc);
    }


}
