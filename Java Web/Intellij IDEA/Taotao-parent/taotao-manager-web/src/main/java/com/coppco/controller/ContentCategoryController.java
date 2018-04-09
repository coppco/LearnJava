package com.coppco.controller;

import com.coppco.common.pojo.EasyTreeNode;
import com.coppco.common.pojo.TaotaoResult;
import com.coppco.content.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    /**
     * 获取内容分类列表
     *
     * @param parentId
     * @return
     */
    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyTreeNode> getContentCategoryList(@RequestParam(value = "id", defaultValue = "0") long parentId) {
        return contentCategoryService.getContentCategoryList(parentId);
    }

    /**
     * 新增内容分类
     *
     * @param parentId
     * @param name
     * @return
     */
    @RequestMapping("/content/category/create")
    @ResponseBody
    public TaotaoResult addContentCategory(long parentId, String name) {
        return contentCategoryService.addContentCategory(parentId, name);
    }

    /**
     * 更新内容分类
     *
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("/content/category/update")
    @ResponseBody
    public TaotaoResult updateContentCategory(long id, String name) {
        return contentCategoryService.updateContentCategory(id, name);
    }

    /**
     * 删除内容分类
     *
     * @param id
     * @return
     */
    @RequestMapping("/content/category/delete")
    @ResponseBody
    public TaotaoResult deleteContentCategory(long id) {
        return contentCategoryService.deleteContentCategory(id);
    }

}
