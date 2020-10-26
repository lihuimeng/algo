package com.recursion;


/**
 * 阶乘
 *
 * @author huimeng.li
 */
public class Factorial {

    public static int multiply(int num) {
        if (num == 1) {
            return 1;
        }

        return multiply(num - 1) * num;
    }
}
