package com.stack;

/**
 * 数组实现的栈
 *
 * @author huimeng.li
 */
public class ArrayStack<E> {

    private int capacity = 10;
    private Object[] data = new Object[capacity];
    private int size = 0;

    public boolean push(E e) {
        expansion();
        data[size] = e;
        size++;
        return true;
    }

    public E pop() {
        return (E) data[--size];
    }

    private void expansion() {
        if (size < capacity) {
            return;
        }
        if (capacity == 0) {
            capacity = 10;
        } else {
            capacity = capacity * 2;
        }
        Object[] newData = new Object[capacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }


    public static void main(String[] args) {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.push("4");

        String pop = arrayStack.pop();
        String pop2 = arrayStack.pop();
        String pop3 = arrayStack.pop();
        String pop4 = arrayStack.pop();

    }

}
