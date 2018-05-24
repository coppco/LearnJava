package com.coppco.cart.controller;

import com.coppco.common.pojo.TaotaoResult;
import com.coppco.common.utils.CookieUtils;
import com.coppco.common.utils.JsonUtils;
import com.coppco.pojo.TbItem;
import com.coppco.service.ItemService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 购物车控制器
 */
@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Value("${CART_KEY_LIST}")
    private String CART_KEY_LIST;

    @Value("${CART_TIME}")
    private int CART_TIME;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/add/{itemid}")
    public String addCartResult(@PathVariable Long itemid, @RequestParam(defaultValue = "1") Integer num, HttpServletRequest request, HttpServletResponse response) {
        //先查询cookies有没有
        List<TbItem> list = getListFromCookies(request);

        //存在, 数量+1
        Boolean flag = false;
        for (TbItem item : list) {
            if (item.getId() == itemid.longValue()) {
                item.setNum(item.getNum() + num);
                flag = true;
                break;
            }
        }

        //不存在 新增
        if (!flag) {
            TbItem addItem = itemService.getItemById(itemid);
            if (null != addItem) {
                addItem.setNum(num);
                String image = addItem.getImage();
                if (StringUtils.isNoneBlank(image)) {
                    String[] split = image.split(",");
                    addItem.setImage(split[0]);
                }
                list.add(addItem);
            }
        }

        CookieUtils.setCookie(request, response, CART_KEY_LIST, JsonUtils.objectToJson(list), CART_TIME, true);

        //返回页面

        return "cartSuccess";

    }

    /**
     * 从cookie中取值
     *
     * @param request
     * @return
     */
    private List<TbItem> getListFromCookies(HttpServletRequest request) {
        String json = CookieUtils.getCookieValue(request, CART_KEY_LIST, true);

        if (StringUtils.isNoneBlank(json)) {
            return JsonUtils.jsonToList(json, TbItem.class);
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 展示购物车
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/cart")
    public String showCart(HttpServletRequest request) {
        //从cookie中取数据
        List<TbItem> list = getListFromCookies(request);

        request.setAttribute("cartList", list);

        return "cart";
    }

    /**
     * 更新购物车 数量变化
     * @param request
     * @param response
     * @param itemid
     * @param num
     * @return
     */
    @RequestMapping(value = "/update/num/{itemid}/{num}")
    @ResponseBody
    public TaotaoResult updateCart(HttpServletRequest request, HttpServletResponse response, @PathVariable Long itemid, @PathVariable Integer num) {
        List<TbItem> list = getListFromCookies(request);

        for (TbItem item:list) {
            if (item.getId() == itemid.longValue()) {
                item.setNum(num);
                break;
            }
        }

        //写入cookies
        CookieUtils.setCookie(request, response, CART_KEY_LIST, JsonUtils.objectToJson(list), CART_TIME, true);

        return TaotaoResult.ok();
    }

    /**
     * 购物车删除商品
     * @param itemid
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete/{itemid}")
    public String delete(@PathVariable Long itemid, HttpServletRequest request, HttpServletResponse response) {
        List<TbItem> list = getListFromCookies(request);

        for (TbItem item:list) {
            if (item.getId() == itemid.longValue()) {
                list.remove(item);
                break;
            }
        }
        //写入cookies
        CookieUtils.setCookie(request, response, CART_KEY_LIST, JsonUtils.objectToJson(list), CART_TIME, true);

        //重定向
        return "redirect:/cart/cart.html";
    }

}
