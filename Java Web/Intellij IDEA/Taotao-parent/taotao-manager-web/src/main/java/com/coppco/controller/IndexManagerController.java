package com.coppco.controller;

import com.coppco.common.pojo.TaotaoResult;
import com.coppco.search.service.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 索引库维护
 */

@Controller
public class IndexManagerController {

    @Autowired
    private SearchItemService searchItemService;

    /**
     * 导入索引, 比较耗时
     * @return
     */
    @RequestMapping("/index/import")
    @ResponseBody
    public TaotaoResult importIndex() {
        return searchItemService.importItemToIndex();
    }
}
