package com.coppco.search.controller;

import com.coppco.common.pojo.SearchResult;
import com.coppco.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 搜索服务Controller
 */

@Controller
public class SearchController {

    @Value("${SEARCH_RESULT_ROW}")
    private Integer SEARCH_RESULT_ROW;

    @Autowired
    private SearchService searchService;

    @RequestMapping("/search")
//    @ResponseBody
    public String search(@RequestParam("q") String queryString, @RequestParam(defaultValue = "1") Integer page, Model model) {

        try {
            queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
            SearchResult result = searchService.search(queryString, page, SEARCH_RESULT_ROW);
            model.addAttribute("query", queryString);
            model.addAttribute("totalPages", result.getTotalPages());
            model.addAttribute("itemList", result.getItemList());
            model.addAttribute("page", page);
            return "search";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
