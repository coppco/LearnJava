package com.coppco.content.service;

import com.coppco.common.pojo.EasyTreeNode;
import com.coppco.common.pojo.TaotaoResult;

import java.util.List;


public interface ContentCategoryService {

    List<EasyTreeNode> getContentCategoryList(long parentId);
    TaotaoResult addContentCategory(long parentId, String name);
    TaotaoResult updateContentCategory(long id, String name);
    TaotaoResult deleteContentCategory(long id);
}
