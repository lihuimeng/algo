package com.link;

import java.util.LinkedList;

/**
 * 循环单链表
 *
 * @author huimeng.li
 */
public class LoopLinkList {

    private SinglyNode first;
    private SinglyNode last;
    private int size;

    public void add(int data) {
        first = new SinglyNode(first, data);
        if (null == first.getNext()) {
            last = first;
        } else {
            last.setNext(first);
        }
        size++;
    }

    public void remove(int data) {
        if (null == first) {
            return;
        }
        if (first.getNext().equals(last)) {
            if (first.getData() == data) {
                first = null;
                last = null;
            }
            return;
        }

        SinglyNode temp = first;
        SinglyNode next = temp.getNext();
        int count = 0;
        while (next != first) {
            if (data == first.getData()) {
                first = first.getNext();
                last.setNext(first);
                temp = first;
                count++;
                continue;
            }

            if (data == next.getData()) {
                if (next.equals(last)) {
                    last = temp;
                }
                SinglyNode next1 = next.getNext();
                temp.setNext(next1);
                next = next1;
                count++;
                continue;
            }
            temp = temp.getNext();
            next = temp.getNext();
        }
        size = size - count;
    }

    public SinglyNode getFirst() {
        return first;
    }

    public void setFirst(SinglyNode first) {
        this.first = first;
    }

    public SinglyNode getLast() {
        return last;
    }

    public void setLast(SinglyNode last) {
        this.last = last;
    }

    public static void main(String[] args) {
        LoopLinkList loopLinkList = new LoopLinkList();
        loopLinkList.add(1);
        loopLinkList.add(2);
        loopLinkList.add(3);
        loopLinkList.add(4);
        loopLinkList.add(5);

        loopLinkList.remove(1);

        boolean equals = loopLinkList.last.getNext().equals(loopLinkList.first);
    }


}
