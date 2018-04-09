package com.coppco.content.service;

import com.coppco.common.pojo.EasyUIDataGridResult;
import com.coppco.common.pojo.TaotaoResult;
import com.coppco.pojo.TbContent;

import java.util.List;

public interface ContentService {
    EasyUIDataGridResult getContentList(int page, int rows, long categoryId);
    TaotaoResult addContent(TbContent content);
    TaotaoResult editContent(TbContent content);
    TaotaoResult deleteContents(String ids);
    List<TbContent> queryContentByCid(long categoryId);
}
