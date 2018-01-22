package com.coppco.service;

import com.coppco.pojo.Items;

import java.util.List;

public interface ItemService {
    List<Items> list();

    Items findById(Integer id);

    void updateItems(Items items);
}
