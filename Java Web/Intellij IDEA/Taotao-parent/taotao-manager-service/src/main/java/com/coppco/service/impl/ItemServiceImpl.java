package com.coppco.service.impl;

import com.coppco.common.pojo.EasyUIDataGridResult;
import com.coppco.common.pojo.TaotaoResult;
import com.coppco.common.utils.IDUtils;
import com.coppco.mapper.TbItemDescMapper;
import com.coppco.mapper.TbItemMapper;
import com.coppco.pojo.TbItem;
import com.coppco.pojo.TbItemDesc;
import com.coppco.pojo.TbItemExample;
import com.coppco.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;
import java.util.Date;
import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource(name = "itemAddTopic")
    private Topic topic;

    /**
     * 根据商品id查询
     *
     * @param id
     * @return
     */
    public TbItem getItemById(Long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询商品列表
     *
     * @param page
     * @param rows
     * @return
     */
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        //设置信息
        PageHelper.startPage(page, rows);
        //查询
        List<TbItem> list = tbItemMapper.selectByExample(new TbItemExample());
        //取查询结果
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);

        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    /**
     * 添加商品
     *
     * @param item
     * @param desc
     * @return
     */
    @Override
    public TaotaoResult addItem(TbItem item, String desc) {
        final long id = IDUtils.genItemId();
        //生成商品id
        item.setId(id);
        //属性补全
        //商品状态 1-正常 2-下架 3-删除
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //商品表插入
        tbItemMapper.insert(item);
        //生成商品描述pojo
        TbItemDesc pojo = new TbItemDesc();
        pojo.setItemId(id);
        pojo.setItemDesc(desc);
        pojo.setCreated(new Date());
        pojo.setUpdated(new Date());

        tbItemDescMapper.insert(pojo);

        //发送消息
        jmsTemplate.send(topic, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(id + "");
                return textMessage;
            }
        });

        return TaotaoResult.ok();

    }
}
