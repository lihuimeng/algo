package com.queue;

/**
 * 链表队列
 *
 * @author huimeng.li
 */
public class LinkedQueue<E> {

    private Node<E> head;

    private Node<E> tail;

    public void push(E e) {
        Node<E> eNode = new Node<>(null, e);
        if (head == null) {
            head = eNode;
            tail = head;
            return;
        }
        tail.setNext(eNode);
        tail = eNode;
    }

    public E pop() {
        if (null == head) {
            return null;
        }
        E data = head.getData();
        head = head.getNext();
        return data;
    }

    ;

    private static class Node<E> {
        private Node<E> next;

        private E data;

        public Node(Node<E> next, E data) {
            this.next = next;
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public E getData() {
            return data;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public void setData(E data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedQueue<String> linkedQueue = new LinkedQueue<>();
        for (int i = 0; i < 101; i++) {
            linkedQueue.push(i + "");
        }

        for (int i = 0; i < 101; i++) {
            System.out.println("彈出：------" + linkedQueue.pop());
        }

    }

}
