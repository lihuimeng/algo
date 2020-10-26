package com.sorts;

/**
 * 冒泡排序
 *
 * @author huimeng.li
 */
public class ArraySort {

    /**
     * 冒泡排序
     * @param array
     * @param size
     */
    public static void bubbleSort(int[] array, int size) {
        if (size < 2) {
            return;
        }
        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j+1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int[] ints = {8, 6, 5, 4, 3, 2, 1, 5};
        bubbleSort(ints, 8);
        System.out.println("123");
    }

}
