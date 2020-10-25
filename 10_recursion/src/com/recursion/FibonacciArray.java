package com.recursion;


/**
 * 斐波那契数列
 *
 * @author huimeng.li
 */
public class FibonacciArray {

    private int capacity = 10;
    private int[] data = new int[capacity];
    private int size;

    public static int add(int index) {
        if (index == 0) {
            return 1;
        }

        if (index == 1) {
            return 1;
        }

        return add(index - 1) + add(index - 2);
    }

    public static void main(String[] args) {
        int add0 = add(0);
        int add1 = add(1);
        int add2 = add(2);
        int add3 = add(3);
        int add4 = add(4);
        int add5 = add(5);
        int add6 = add(6);
    }

}
