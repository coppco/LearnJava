package com.coppco.search.dao;

import com.coppco.common.pojo.SearchItem;
import com.coppco.common.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 查询索引商品
 */
@Repository
public class SearchDao {

    @Autowired
    private SolrClient solrClient;

    public SearchResult search(SolrQuery query) throws Exception {
        SearchResult result = new SearchResult();
        List<SearchItem> list = new ArrayList<>();

        //查询
        QueryResponse response = solrClient.query(query);
        //取查询结果
        SolrDocumentList results = response.getResults();
        //总记录数
        result.setRecordCount(results.getNumFound());

        for (SolrDocument document:results) {
            SearchItem item = new SearchItem();
            item.setCategory_name((String) document.get("item_category_name"));
            item.setId((String) document.get("id"));
            item.setImage((String) document.get("item_image"));
            item.setPrice((Long) document.get("item_price"));
            item.setSell_point((String) document.get("item_sell_point"));

            //取高亮显示
            Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
            List<String> strings = highlighting.get(document.get("id")).get("item_title");
            String title = "";
            if (null != strings && strings.size() > 0) {
                title = strings.get(0);
            } else  {
                title = (String) document.get("item_title");
            }
            item.setTitle(title);
            list.add(item);
        }
        result.setItemList(list);
        return result;
    }
}
