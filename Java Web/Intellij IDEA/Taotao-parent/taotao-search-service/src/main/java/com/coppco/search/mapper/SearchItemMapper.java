package com.coppco.search.mapper;

import com.coppco.common.pojo.SearchItem;

import java.util.List;

public interface SearchItemMapper {

    public List<SearchItem> getItemList();

    public SearchItem getItemById(long id);
}
