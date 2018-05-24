package com.coppco.item.controller;

import com.coppco.item.pojo.Item;
import com.coppco.pojo.TbItem;
import com.coppco.pojo.TbItemDesc;
import com.coppco.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品详情页面
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    public String showItem(@PathVariable("itemId") long id, Model model) {
        //商品信息
        TbItem tbItem = itemService.getItemById(id);

        Item item = new Item(tbItem);

        //商品详情
        TbItemDesc tbItemDesc = itemService.getItemDescById(id);

        model.addAttribute("item", item);
        model.addAttribute("itemDesc", tbItemDesc);
        return "item";
    }
}
