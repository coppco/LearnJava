package com.coppco.service;

import com.coppco.common.pojo.EasyUIDataGridResult;
import com.coppco.common.pojo.TaotaoResult;
import com.coppco.pojo.TbItem;

public interface ItemService {

    TbItem getItemById(Long id);
    EasyUIDataGridResult getItemList(Integer page, Integer rows);
    TaotaoResult addItem(TbItem item, String desc);
}
