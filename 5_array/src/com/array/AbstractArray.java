package com.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huimeng.li
 */
public abstract class AbstractArray<T> {
    protected static final int DEFAULT_CAPACITY = 10;

    protected Object[] data = {};

    protected int size = 0;

    protected int capacity;

    public AbstractArray(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("初始化集合参数错误");
        }
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public AbstractArray() {
    }

    public boolean add(T t) {
        expansion(size);
        data[size++] = t;
        return true;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        rangCheck(index);
        return (T) data[index];
    }

    private void rangCheck(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException("数组越界异常，index:" + index + ",size:" + size());
        }
    }

    public boolean addAt(T t, int index) {
        expansion(index + 1);

        Object datum = data[index];
        if (null != datum) {
            add((T) datum);
        }
        data[index] = t;
        return true;
    }

    public boolean expansion(int size) {

        if (size == 0) {
            size = 2;
        }

        if (size < this.capacity) {
            return false;
        }

        if (size > this.capacity) {
            this.capacity = size + 1;
        }

        if (size == this.capacity) {
            this.capacity = capacity * 2;
        }
        Object[] objects = new Object[capacity];
        System.arraycopy(data, 0, objects, 0, data.length);
        data = objects;
        return true;
    }


}
