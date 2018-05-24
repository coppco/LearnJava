package com.coppco.search.listener;

import com.coppco.common.pojo.SearchItem;
import com.coppco.search.mapper.SearchItemMapper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 监听商品添加事件
 */
public class ItemAddListener implements MessageListener {

    @Autowired
    private SearchItemMapper searchItemMapper;

    @Autowired
    private SolrClient solrClient;

    @Override
    public void onMessage(Message message) {
        try {
            //获取itemid
            TextMessage textMessage = (TextMessage) message;
            //取消息内容
            long itemId = Long.parseLong(textMessage.getText());
            System.out.println("消息接受");
            //数据库查询, 等待事务提交
            Thread.sleep(1000);
            SearchItem item = searchItemMapper.getItemById(itemId);
            if (null != item && item.getId() != "0") {
                //创建文档
                SolrInputDocument document = new SolrInputDocument();
                //向文档中添加域
                document.addField("id", item.getId());
                document.addField("item_title", item.getTitle());
                document.addField("item_sell_point", item.getSell_point());
                document.addField("item_price", item.getPrice());
                document.addField("item_image", item.getImage());
                document.addField("item_desc", item.getItem_desc());
                document.addField("item_category_name", item.getCategory_name());
                //文档写入索引
                solrClient.add(document);
                solrClient.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
