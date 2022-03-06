/*
 * Copyright(C)2022, Group 2 SE1511 FPTU-HN
 * Project: Online Learning System
 * Pagination Bean
 * Record of change:
 * DATE         Version     AUTHOR     Description
 * 2022-03-05   1.0         Danh Tinh    First Implement
 */
package bean;

/**
 *
 * @author tinht
 */
public class PaginationBean {
    private int pageIndex = 1;
    private int pageSize = 12;
    private int prev;
    private int next;
    private int count;
    private int size;
    
    public PaginationBean() {
    }
    
    public PaginationBean(int pageIndex, int pageSize, int size) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.size = size;
        updateCount();
        this.next = Math.min(this.pageIndex + 1, this.count);
        this.prev = Math.max(1, this.pageIndex - 1);
    }
    
    public void updateCount() {
        int count = (int) Math.ceil((double) this.size / pageSize);
        this.count = count > 0 ? count : 1;
    }

    public void setSize(int size) {
        this.size = size;
        updateCount();
    }
    
    public int getSize() {
        return this.size;
    }


    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex <= 0 ? 1 : pageIndex <= count ? pageIndex : count;
        this.next = Math.min(this.pageIndex + 1, count);
        this.prev = Math.max(1, this.pageIndex - 1);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        updateCount();
    }

    public int getPrev() {
        return prev;
    }

    public int getNext() {
        return next;
    }

    public int getCount() {
        return count;
    }
}
