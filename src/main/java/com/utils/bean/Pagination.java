package com.utils.bean;

/**
 * Created by carlwang on 5/15/16.
 */

public class Pagination {

    //一页的容量
    private long capacity = 4;
    //当前的页面，从0开始
    private long currentIndex;

    //总的页数
    private long totalAmount;
    //按照哪个属性进行排序
    private String sortFiledName;
    private boolean asc = true;

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(long currentIndex) {
        this.currentIndex = currentIndex;
    }

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
        return currentIndex * capacity;
    }

    public long getTo() {
        return (currentIndex + 1) * capacity;
    }


    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }
}
