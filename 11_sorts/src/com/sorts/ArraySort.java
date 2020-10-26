package com.sorts;

/**
 * 冒泡排序
 *
 * @author huimeng.li
 */
public class ArraySort {

    /**
     * 冒泡排序
     *
     * @param array
     * @param size
     */
    public static void bubbleSort(int[] array, int size) {
        if (size < 2) {
            return;
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (int j = 0; j < size - i - 1; j++) {
                count++;
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    //如果是第一个元素交换了，逆序已经被修正没有了，所以就不用了循环了
                    if (j != 0) {
                        flag = true;
                    }
                }
            }
            if (!flag) {
                break;
            }
        }
        System.out.println("循环次数：" + count);
    }

    /**
     * 插入排序
     * @param array
     * @param size
     */
    public static void insertSort(int[] array, int size) {
        if (size < 2) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            int temp = array[i];
            int index = i;
            while (index > 0 && array[index-1] > temp) {
                array[index] = array[index - 1];
                index--;
            }
            array[index] = temp;
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int[] ints = {3, 2, 1, 4, 5, 6, 7, 8};
        insertSort(ints, 8);
        System.out.println("123");
    }

}
