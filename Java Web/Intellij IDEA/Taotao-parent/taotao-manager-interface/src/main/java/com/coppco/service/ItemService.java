package com.coppco.service;

import com.coppco.common.pojo.EasyUIDataGridResult;
import com.coppco.common.pojo.TaotaoResult;
import com.coppco.pojo.TbItem;
import com.coppco.pojo.TbItemDesc;

public interface ItemService {

    TbItem getItemById(Long id);
    EasyUIDataGridResult getItemList(Integer page, Integer rows);
    TaotaoResult addItem(TbItem item, String desc);
    TbItemDesc getItemDescById(Long id);
}
