package com.queue;

/**
 * 基于数组的队列
 *
 * @author huimeng.li
 */
public class ArrayQueue<E> {

    private int capacity = 10;
    private int head = 0;
    private int tail = 0;
    Object[] data = new Object[capacity];

    public boolean push(E e) {
        expansion();
        data[tail++] = e;
        return true;
    }

    public E pop() {
        if (tail == head) {
            return null;
        }
        E datum = (E) data[head];
        data[head] = null;
        head++;
        return datum;
    }

    private void expansion() {
        if (capacity == 0) {
            capacity = 10;
        }

        if (tail == capacity - 1) {
            if (head == 0) {
                capacity = capacity * 2;
                Object[] newData = new Object[capacity];
                System.arraycopy(data, 0, newData, 0, data.length);
                data = newData;
                return;
            }

            int count = 0;
            for (int i = head; i < tail; i++) {
                data[count++] = data[i];
                data[i] = null;
            }
        }
    }

    public static void main(String[] args) {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 9; i++) {
            arrayQueue.push(i + "");
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("队列弹出：---" + arrayQueue.pop());
        }

        arrayQueue.push("100");
    }


}
