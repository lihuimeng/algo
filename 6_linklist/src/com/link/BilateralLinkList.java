package com.link;

/**
 * 双向链表
 *
 * @author huimeng.li
 */
public class BilateralLinkList {
    private BilateralNode first;

    private BilateralNode last;

    public void addFirst(int data) {
        if (first == null) {
            first = new BilateralNode(null, null, data);
            last = first;
            return;
        }

        BilateralNode bilateralNode = new BilateralNode(first, null, data);
        first.setPrev(bilateralNode);
        first = bilateralNode;
    }

    public void addLast(int data) {
        if (first == null) {
            first = new BilateralNode(null, null, data);
            last = first;
            return;
        }
        if (last == null) {
            last = new BilateralNode(null, first, data);
            return;
        }
        BilateralNode bilateralNode = new BilateralNode(null, last, data);
        last.setNext(bilateralNode);
        last = bilateralNode;
    }

    public void remove(int data) {
        if (null == first) {
            return;
        }
        BilateralNode next = first.getNext();
        if (null == next) {
            if (first.getData() == data) {
                first = null;
                last = null;
            }
            return;
        }

        while (next != null) {
            BilateralNode next1 = next.getNext();
            if (next.getData() == data) {
                BilateralNode prev = next.getPrev();
                prev.setNext(next1);
                if (next1 == null) {
                    last = prev;
                } else {
                    next1.setPrev(prev);
                }

            }
            next = next1;
        }
    }

    /**
     * 链表反转
     */
    public void reverse() {
        if (first == null) {
            return;
        }

        if (first.getNext() == null) {
            return;
        }

        BilateralNode next = first.getNext();
        first.setNext(null);
        first.setPrev(next);
        last = first;
        while (next != null) {
            BilateralNode temp = next.getNext();
            next.setNext(next.getPrev());
            if (null == temp) {
                first = next;
            }
            next.setPrev(temp);
            next = temp;
        }

    }

    public BilateralNode getFirst() {
        return first;
    }

    public void setFirst(BilateralNode first) {
        this.first = first;
    }

    public BilateralNode getLast() {
        return last;
    }

    public void setLast(BilateralNode last) {
        this.last = last;
    }

    public static void main(String[] args) {
        BilateralLinkList bilateralLinkList = new BilateralLinkList();
        bilateralLinkList.addFirst(4);
        bilateralLinkList.addFirst(3);
        bilateralLinkList.addFirst(2);
        bilateralLinkList.addFirst(1);
        bilateralLinkList.reverse();
    }
}
