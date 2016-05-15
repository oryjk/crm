package com.utils.bean;

/**
 * Created by carlwang on 5/15/16.
 */
public class Pagination {
    public static final int DEFAULT_CAPACITY = 5;
    public static final int DEFAULT_SPAN_SIZE = 2;

    private long capacity;
    private long currentIndex;// start from 0;
    private long totalAmount;
    private String sortFiledName;
    private boolean asc;

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

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }
}
