package com.coppco.utils;

import java.util.List;

public class PageBean<T> {
    private static int defaultPageSize = 10;
    /**
     * 当前页
     */
    private int currentPage;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 总记录数
     */
    private int totalCount;
    /**
     * 每页显示数量
     */
    private int pageSize = PageBean.defaultPageSize;
    /**
     * 查询结果
     */
    private List<T> results;


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * 计算分页数量公式: (totalCount + pageSize - 1) / pageSize
     * @return
     */
    public int getTotalPage() {
        return (totalCount + pageSize - 1) / pageSize;
    }

    /*
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    */

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize <= 0) {
            this.pageSize = PageBean.defaultPageSize;
        } else {
            this.pageSize = pageSize;
        }
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
