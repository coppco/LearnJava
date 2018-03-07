package com.coppco.service.impl;

import com.coppco.mapper.TbItemMapper;
import com.coppco.pojo.TbItem;
import com.coppco.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    public TbItem getItemById(Long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }
}
