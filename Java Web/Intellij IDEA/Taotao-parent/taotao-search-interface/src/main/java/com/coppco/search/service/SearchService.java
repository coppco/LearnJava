package com.coppco.search.service;

import com.coppco.common.pojo.SearchResult;

/**
 * 搜索服务
 */
public interface SearchService {
    public SearchResult search(String queryString, int page, int rows) throws Exception;
}
