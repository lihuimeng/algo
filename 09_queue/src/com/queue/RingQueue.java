package com.queue;

/**
 * 环形队列
 *
 * @author huimeng.li
 */
public class RingQueue<E> {

    private int capacity;

    private Object[] data;

    private int head;

    private int size;

    public RingQueue(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public void push(E e) {
        if (size == capacity) {
            throw new IndexOutOfBoundsException("队列已满");
        }
        data[calculateTail()] = e;
        size++;
    }

    public E pop() {
        Object datum = data[head];
        data[head] = null;
        calculateHead();
        size--;
        return (E) datum;
    }

    private int calculateTail() {
        int head = this.head;
        int size = this.size;
        return (head + size) % capacity;
    }

    private void calculateHead() {
        if (head == capacity - 1) {
            head = 0;
        } else {
             ++head;
        }
    }

    public static void main(String[] args) {
        RingQueue<String> ringQueue = new RingQueue<>(15);
        for (int i = 0; i < 5; i++) {
            ringQueue.push(i + 1 + "");
        }

        for (int i = 0; i < 100; i++) {
            ringQueue.push(i + 1 + "");
            ringQueue.pop();
        }
    }


}
