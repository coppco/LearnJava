package com.coppco.portal.controller;

import com.coppco.common.utils.JsonUtils;
import com.coppco.content.service.ContentService;
import com.coppco.pojo.TbContent;
import com.coppco.portal.pojo.ADNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页展示
 */

@Controller
public class IndexController {

    @Value("${AD_CONTENT_CATEGORY_ID}")
    private long AD_CONTENT_CATEGORY_ID;
    @Value("${AD_WIDTH}")
    private Integer AD_WIDTH;
    @Value("${AD_WIDTH_B}")
    private Integer AD_WIDTH_B;
    @Value("${AD_HEIGHT}")
    private Integer AD_HEIGHT;
    @Value("${AD_HEIGHT_B}")
    private Integer AD_HEIGHT_B;


    @Autowired
    private ContentService contentService;

    @RequestMapping("/index")
    public String showIndex(Model model) {

        //根据cid查询轮播图
        List<TbContent> tbContents = contentService.queryContentByCid(AD_CONTENT_CATEGORY_ID);

        //转出ADNode列表
        List<ADNode> list = new ArrayList<>();
        for (TbContent content:tbContents) {
            ADNode node = new ADNode();
            node.setAlt(content.getTitle());
            node.setHeight(AD_HEIGHT);
            node.setHeightB(AD_HEIGHT_B);
            node.setWidth(AD_WIDTH);
            node.setWidthB(AD_WIDTH_B);
            node.setSrc(content.getPic());
            node.setSrcB(content.getPic2());
            node.setHerf(content.getUrl());
            list.add(node);
        }

        String result = JsonUtils.objectToJson(list);

        //ADNode类别转为json传递给数据
        model.addAttribute("ad1", result);
        return "index";
    }


}
