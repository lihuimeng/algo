package com.stack;

/**
 * 链表栈
 *
 * @author huimeng.li
 */
public class LinkedStack<E> {
    private Node<E> head;

    public boolean push(E e) {
        head = new Node<>(this.head, e);
        return true;
    }

    public E pop() {
        if (null == head) {
            return null;
        }
        E data = head.getData();
        head = head.next();
        return data;
    }


    private static class Node<E>{
        private Node<E> next;
        private E data;

        public Node(Node<E> next, E data) {
            this.next = next;
            this.data = data;
        }

        public Node<E> next() {
            return next;
        }

        public E getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        linkedStack.push("1");
        linkedStack.push("2");
        linkedStack.push("3");
        linkedStack.push("4");

        String pop1 = linkedStack.pop();
        String pop2 = linkedStack.pop();
        linkedStack.push("5");

        String po3 = linkedStack.pop();
        String pop4 = linkedStack.pop();

    }
}
