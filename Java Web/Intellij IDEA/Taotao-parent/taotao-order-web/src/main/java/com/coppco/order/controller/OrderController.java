package com.coppco.order.controller;

import com.coppco.common.pojo.TaotaoResult;
import com.coppco.common.utils.CookieUtils;
import com.coppco.common.utils.JsonUtils;
import com.coppco.order.pojo.OrderInfo;
import com.coppco.order.service.OrderService;
import com.coppco.pojo.TbItem;
import com.coppco.pojo.TbUser;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 订单处理页面
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${CART_KEY_LIST}")
    private String CART_KEY_LIST;

    @RequestMapping(value = "/order-cart")
    public String showOrderCart(HttpServletRequest request) {
        //用户必须是登录状态, 通过拦截器拦截

        //取用户id
        TbUser user = (TbUser) request.getAttribute("user");
        System.out.print(user.getUsername());
        //取收货地址

        //取购物车商品列表展示
        List<TbItem> list = getListFromCookies(request);
        request.setAttribute("cartList", list);
        //返回视图
        return "order-cart";
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
     * 生成订单
     * @param orderInfo
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createOrder(OrderInfo orderInfo, Model model) {
        TaotaoResult result = orderService.createOrder(orderInfo);

        model.addAttribute("orderId", result.getData().toString());

        model.addAttribute("payment", orderInfo.getPayment());

        DateTime dateTime = new DateTime().plusDays(3);

        model.addAttribute("date", dateTime.toString("yyyy-MM-dd HH:mm:ss"));

        return "success";
    }

}
