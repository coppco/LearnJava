package com.coppco.controller;

import com.coppco.common.pojo.EasyTreeNode;
import com.coppco.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品分类控制器
 */
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    /**
     * 获取商品分类
     * @param parentId 商品id
     * @return
     */
    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyTreeNode> getItemCatList(@RequestParam(name = "id", defaultValue = "0") Long parentId) {
        //默认是顶层节点
        List<EasyTreeNode> catList = itemCatService.getCatList(parentId);
        return catList;
    }
}
