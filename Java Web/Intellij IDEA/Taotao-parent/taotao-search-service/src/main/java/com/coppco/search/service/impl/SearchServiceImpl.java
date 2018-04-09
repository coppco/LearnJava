package com.coppco.search.service.impl;

import com.coppco.common.pojo.SearchResult;
import com.coppco.search.dao.SearchDao;
import com.coppco.search.service.SearchService;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchDao searchDao;

    @Override
    public SearchResult search(String queryString, int page, int rows) throws Exception {
        SolrQuery query = new SolrQuery();
        //设置查询条件
        query.setQuery(queryString);
        //设置分页
        query.setStart(((page <= 0 ? 1: page) - 1) * rows );
        query.setRows(rows <= 1 ? 10 : rows);
        //设置默认搜索域
        query.set("df", "item_title");
        //设置高亮
        query.setHighlight(true);
        query.addHighlightField("item_title");
        query.setHighlightSimplePre("<font color=red>");
        query.setHighlightSimplePost("</font>");
        //查询
        SearchResult result = searchDao.search(query);
        //计算总页数
        result.setTotalPages((int) ((result.getRecordCount() + 1) / (rows <= 1 ? 10 : rows)));
        return result;
    }
}
