package com.coppco.order.service.serviceImpl;


import com.coppco.common.jedis.JedisClient;
import com.coppco.common.pojo.TaotaoResult;
import com.coppco.mapper.TbOrderItemMapper;
import com.coppco.mapper.TbOrderMapper;
import com.coppco.mapper.TbOrderShippingMapper;
import com.coppco.order.pojo.OrderInfo;
import com.coppco.order.service.OrderService;
import com.coppco.pojo.TbOrderItem;
import com.coppco.pojo.TbOrderShipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 订单处理
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TbOrderShippingMapper orderShippingMapper;

    @Autowired
    private TbOrderItemMapper orderItemMapper;

    @Autowired
    private TbOrderMapper orderMapper;

    @Autowired
    private JedisClient jedisClient;

    /**
     * redis中的订单号key
     */
    @Value("${ORDER_ID_KEY}")
    private String ORDER_ID_KEY;

    /**
     * redis中的订单号起始值
     */
    @Value("${ORDER_ID_VALUE_BEGIN}")
    private String ORDER_ID_VALUE_BEGIN;

    /**
     * redis中的订单明细key
     */
    @Value("${ORDER_DETAIL_ID_KEY}")
    private String ORDER_DETAIL_ID_KEY;


    @Override
    public TaotaoResult createOrder(OrderInfo orderInfo) {

        if (!jedisClient.exists(ORDER_ID_KEY)) {
            jedisClient.set(ORDER_ID_KEY, ORDER_ID_VALUE_BEGIN);
        }

        //生成订单号, 利用redis的incr自增
        String orderID = jedisClient.incr(ORDER_ID_KEY).toString();

        //补全数据
        //订单id
        orderInfo.setOrderId(orderID);
        //状态
        orderInfo.setStatus(1);
        //时间
        orderInfo.setCreateTime(new Date());
        orderInfo.setUpdateTime(new Date());

        //向数据库写数据
        orderMapper.insert(orderInfo);

        //订单明细
        List<TbOrderItem> orderItems = orderInfo.getOrderItems();
        for (TbOrderItem item: orderItems) {
            //生成订单明细号码, 利用redis的incr自增
            String detailID = jedisClient.incr(ORDER_DETAIL_ID_KEY).toString();
            item.setId(detailID);
            item.setOrderId(orderID);

            //插入明细数据
            orderItemMapper.insert(item);
        }

        //物流表
        TbOrderShipping orderShipping = orderInfo.getOrderShipping();
        orderShipping.setCreated(new Date());
        orderShipping.setUpdated(new Date());
        orderShipping.setOrderId(orderID);

        orderShippingMapper.insert(orderShipping);

        return TaotaoResult.ok(orderID);
    }
}
