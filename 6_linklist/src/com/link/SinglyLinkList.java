package com.link;

/**
 * 单链表
 *
 * @author huimeng.li
 */
public class SinglyLinkList {

    private SinglyNode head;

    public boolean add(int a) {
        head = new SinglyNode(head, a);
        return true;
    }

    public boolean remove(int a) {

        SinglyNode temp = this.head;
        if (temp == null) {
            return false;
        }

        SinglyNode next = temp.getNext();
        if (next == null) {
            if (temp.getData() == a) {
                this.head = null;
                return true;
            }
            return false;
        }

        while (null != next) {
            if (temp.getData() == a) {
                head = temp.getNext();
                temp = head;
                continue;
            }

            int data = next.getData();
            SinglyNode next2 = next.getNext();
            if (data == a) {
                temp.setNext(next2);
                next = temp.getNext();
                continue;
            } else {
                temp = next;
            }
            next = temp.getNext();
        }
        return true;
    }

    public boolean set(int oldData, int newData) {
        if (null == head) {
            return false;
        }

        SinglyNode next = head.getNext();
        while (null != next) {
            if (next.getData() == oldData) {
                next.setData(newData);
            }
            next = next.getNext();
        }
        return true;
    }

    /**
     * 链表翻转
     */
    public void reverse() {
        if (this.head == null || this.head.getNext() == null) {
            return;
        }

        SinglyNode next = head.getNext();
        SinglyNode temp = head;
        head.setNext(null);
        while (next != null) {
            SinglyNode next1 = next.getNext();
            next.setNext(temp);
            if (next1 == null) {
                head = next;
            }
            temp = next;
            next = next1;
        }
    }

    public SinglyNode head() {
        return head;
    }

    /**
     * 中间节点
     *
     * @return
     */
    public SinglyNode middleNode() {
        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            return head;
        }

        if (null == head.getNext().getNext()) {
            return head;
        }
        SinglyNode lowNode = head;
        SinglyNode fastNode = head.getNext().getNext();

        while (null != fastNode) {
            lowNode = lowNode.getNext();
            SinglyNode temp = fastNode.getNext();
            if (null == temp) {
                break;
            }
            fastNode = temp.getNext();
        }
        return lowNode;

    }

    ;

    public static void main(String[] args) {
        SinglyLinkList singlyLinkList1 = new SinglyLinkList();
        singlyLinkList1.add(9);
        singlyLinkList1.add(7);
        singlyLinkList1.add(5);
        singlyLinkList1.add(3);
        singlyLinkList1.add(1);

        SinglyLinkList singlyLinkList2 = new SinglyLinkList();
        singlyLinkList2.add(10);
        singlyLinkList2.add(8);
        singlyLinkList2.add(6);
        singlyLinkList2.add(4);
        singlyLinkList2.add(2);

        SinglyLinkList merge = merge(singlyLinkList1, singlyLinkList2);

    }

    /**
     * 有序链表合并
     * @param linkList1
     * @param linkList2
     * @return
     */
    public static SinglyLinkList merge(SinglyLinkList linkList1, SinglyLinkList linkList2) {
        SinglyNode temp1 = linkList1.head();
        SinglyNode temp2 = linkList2.head();
        SinglyLinkList singlyLinkList = new SinglyLinkList();
        while (temp1 != null || temp2 != null) {
            if (temp1 == null) {
                singlyLinkList.add(temp2.getData());
                temp2 = temp2.getNext();
                continue;
            }
            if (temp2 == null) {
                singlyLinkList.add(temp1.getData());
                temp1 = temp1.getNext();
                continue;
            }

            if (temp1.getData() < temp2.getData()) {
                singlyLinkList.add(temp1.getData());
                temp1 = temp1.getNext();
            } else {
                singlyLinkList.add(temp2.getData());
                temp2 = temp2.getNext();
            }
        }
        singlyLinkList.reverse();
        return singlyLinkList;
    }

}
