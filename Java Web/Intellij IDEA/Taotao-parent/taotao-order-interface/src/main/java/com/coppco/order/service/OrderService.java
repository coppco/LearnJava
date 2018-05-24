package com.coppco.order.service;


import com.coppco.common.pojo.TaotaoResult;
import com.coppco.order.pojo.OrderInfo;

public interface OrderService {

    TaotaoResult createOrder(OrderInfo orderInfo);
}
