package com.link;

/**
 * 单链表节点
 *
 * @author huimeng.li
 */
public class SinglyNode {
    private SinglyNode next;
    private int data;

    public SinglyNode(SinglyNode next, int data) {
        this.next = next;
        this.data = data;
    }

    public SinglyNode getNext() {
        return next;
    }

    public void setNext(SinglyNode next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}