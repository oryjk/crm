package com.utils.bean;

/**
 * Created by carlwang on 5/15/16.
 */

public class Pagination {

    //一页的容量
    private int pageSize = 4;
    //当前的页面，从1开始,默认为1
    private int currentPage = 1;

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    //总的页数
    private long totalAmount;
    //按照哪个属性进行排序
    private String sortFiledName;
    private boolean asc = true;

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSortFiledName() {
        return sortFiledName;
    }

    public void setSortFiledName(String sortFiledName) {
        this.sortFiledName = sortFiledName;
    }


    public long getFrom() {
        return (currentPage-1) * pageSize;
    }

    public long getTo() {
        return currentPage * pageSize -1;
    }


    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }
}
