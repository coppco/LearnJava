package com.coppco.controller;

import com.coppco.common.pojo.EasyUIDataGridResult;
import com.coppco.common.pojo.TaotaoResult;
import com.coppco.content.service.ContentService;
import com.coppco.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容控制器
 */
@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/content/query/list")
    @ResponseBody
    public EasyUIDataGridResult getContentList(Integer page, Integer rows, @RequestParam(value = "categoryId", defaultValue = "0") long categoryId) {
        return contentService.getContentList(page, rows, categoryId);
    }

    @RequestMapping("/content/save")
    @ResponseBody
    public TaotaoResult addContent(TbContent content) {
        return contentService.addContent(content);
    }

    @RequestMapping("/rest/content/edit")
    @ResponseBody
    public TaotaoResult editContent(TbContent content) {
        return contentService.editContent(content);
    }

    @RequestMapping("/content/delete")
    @ResponseBody
    public TaotaoResult deleteContents(String ids) {
        return contentService.deleteContents(ids);
    }
}