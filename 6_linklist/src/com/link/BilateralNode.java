package com.link;

/**
 * 双向链表节点
 *
 * @author huimeng.li
 */
public class BilateralNode {

    private BilateralNode next;

    private BilateralNode prev;

    private int data;

    public BilateralNode(BilateralNode next, BilateralNode prev, int data) {
        this.next = next;
        this.prev = prev;
        this.data = data;
    }

    public BilateralNode getNext() {
        return next;
    }

    public void setNext(BilateralNode next) {
        this.next = next;
    }

    public BilateralNode getPrev() {
        return prev;
    }

    public void setPrev(BilateralNode prev) {
        this.prev = prev;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
