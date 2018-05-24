package com.coppco.item.listener;

import com.coppco.item.pojo.Item;
import com.coppco.pojo.TbItem;
import com.coppco.pojo.TbItemDesc;
import com.coppco.service.ItemService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * 添加item之后使用Freemarker生成静态化页面
 */
public class ItemAddListener implements MessageListener {

    @Autowired
    private ItemService itemService;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Value("${HTML_AUTO_PATH}")
    private String HTML_AUTO_PATH;

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

            //查询item
            TbItem tbItem = itemService.getItemById(itemId);

            Item item = new Item(tbItem);
            TbItemDesc tbItemDesc = itemService.getItemDescById(itemId);

            //使用freemarker生成静态页面
            Configuration configuration = freeMarkerConfigurer.getConfiguration();
            Template template = configuration.getTemplate("item.ftl");

            //数据
            Map map = new HashMap();
            map.put("item", item);
            map.put("itemDesc", tbItemDesc);

            //指定输出路径
            Writer out = new FileWriter(new File(HTML_AUTO_PATH + itemId + ".html"));

            template.process(map, out);

            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
