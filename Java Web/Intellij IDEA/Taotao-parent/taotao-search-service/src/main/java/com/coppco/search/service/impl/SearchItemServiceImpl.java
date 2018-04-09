package com.coppco.search.service.impl;

import com.coppco.common.pojo.SearchItem;
import com.coppco.common.pojo.TaotaoResult;
import com.coppco.search.mapper.SearchItemMapper;
import com.coppco.search.service.SearchItemService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchItemServiceImpl implements SearchItemService {

    @Autowired
    private SearchItemMapper searchItemMapper;

    @Autowired
    private SolrClient solrClient;

    @Override
    public TaotaoResult importItemToIndex() {

        try {
            //查询数据
            List<SearchItem> searchItemList = searchItemMapper.getItemList();
            //添加到索引库
            for (SearchItem item:searchItemList) {
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
            }
            //提交
            solrClient.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, "数据导入失败");
        }
        return TaotaoResult.ok();
    }
}
