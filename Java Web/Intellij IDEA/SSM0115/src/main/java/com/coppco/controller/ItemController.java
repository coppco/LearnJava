package com.coppco.controller;

import com.coppco.dao.ItemsMapper;
import com.coppco.pojo.Items;
import com.coppco.pojo.Login;
import com.coppco.service.ItemService;
import com.coppco.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class ItemController {

    @Resource(name = "itemService")
    private ItemService itemService;

//    @Autowired
//    private  HttpServletRequest request;


    @RequestMapping("/list")
    public ModelAndView items() throws Exception{

        List<Items> list = itemService.list();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList", list);
        modelAndView.setViewName("itemList");
        return modelAndView;
    }


    @RequestMapping(value = {"/itemEdit", "/haha"})
    public String itemEdit(HttpServletRequest request, Model model) throws Exception {

//        request.setAttribute();

        String id = request.getParameter("id");

        Items items = itemService.findById(Integer.parseInt(id));

        model.addAttribute("item", items);
        return "editItem";
    }

    /*
    @RequestMapping("/updateitem")
    public String update(Integer id, String name, Float price, String detail) throws Exception {
        Items items = new Items();
        items.setId(id);
        items.setName(name);
        items.setPrice(price);
        items.setDetail(detail);
        items.setCreatetime(new Date());

        itemService.updateItems(items);
        return "success";
    }
    */

    @RequestMapping("/updateitem")
    public String update(Items items) throws Exception {
//        items.setCreatetime(new Date());

        itemService.updateItems(items);
        return "success";
    }

    @RequestMapping(value = {"/search", "/list"}, method = RequestMethod.POST)
    public String search(SearchVo searchVo) throws Exception {
        return "itemList";
    }

    @RequestMapping("/delAll")
    public String delAll(Model model) throws Exception{
        List<Items> list = itemService.list();
        model.addAttribute("itemList", list);
        return "itemList";
    }

    @RequestMapping(value = "/jsonString", consumes = "application/json")
    public @ResponseBody Login json(@RequestBody Login login) {
        return login;
    }
}
