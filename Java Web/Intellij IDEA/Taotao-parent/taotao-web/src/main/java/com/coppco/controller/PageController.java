package com.coppco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 页面展示jsp
 */
@Controller
public class PageController {

    /**
     * /跳转到首页
     * @return
     */
    @RequestMapping(value = "/")
    public String showIndex() {
        return "index";
    }

    /**
     * 页面跳转
     * @param page
     * @return
     */
    @RequestMapping(value = "/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
