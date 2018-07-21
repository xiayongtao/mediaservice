package com.happok.xiyan.mediaservice.common;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.happok.xiyan.mediaservice.config.PageConfig;

public class Paging {
    private String page_num;
    private String page_size;
    private String order_by;

    private PageConfig pageConfig;

    private Page page = null;

    public Paging(String page_num, String page_size, String order_by, PageConfig pageConfig) {
        this.page_num = (page_num != null) ? page_num : pageConfig.getPage_num();
        this.page_size = (page_size != null) ? page_size : pageConfig.getPage_size();
        this.order_by = (order_by != null) ? order_by : pageConfig.getOrder_by();
        this.pageConfig = pageConfig;
    }

    public boolean isNumber() {
        if (!StringUtils.isNumber(this.page_num) || !StringUtils.isNumber(this.page_size)) {
            return false;
        }
        return true;
    }

    public Integer getPageNum() {
        if (!StringUtils.isNumber(this.page_num)) {
            return Integer.parseInt(pageConfig.getPage_num());
        }

        return Integer.parseInt(this.page_num);
    }

    public Integer getPageSize() {
        if (!StringUtils.isNumber(this.page_size)) {
            return Integer.parseInt(pageConfig.getPage_size());
        }

        return Integer.parseInt(this.page_size);
    }

    public String getOrder_by() {
        return this.order_by;
    }

    public void startPage() {
        page = PageHelper.startPage(getPageNum(), getPageSize(), this.order_by);
    }

    public long getTotal() {
        return page.getTotal();
    }

    public int getPages() {
        return page.getPages();
    }
}
