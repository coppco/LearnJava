package com.coppco.search.service;

import com.coppco.common.pojo.TaotaoResult;

public interface SearchItemService {
    /**
     * 导入商品信息到索引库
     * @return
     */
    TaotaoResult importItemToIndex();
}
