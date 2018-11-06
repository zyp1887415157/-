package com.lanou3g.common;


import java.util.List;

public class Pageable<T> {
    //总条数
    private int totalCount;

    //查询出每页的内容
    private List<T> items;

    public Pageable() {
    }

    public Pageable(int totalCount, List<T> items) {
        this.totalCount = totalCount;
        this.items = items;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
