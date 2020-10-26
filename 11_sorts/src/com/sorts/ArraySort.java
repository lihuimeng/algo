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
                    Helper.swap(array, j, j + 1);
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
     *
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
            while (index > 0 && array[index - 1] > temp) {
                array[index] = array[index - 1];
                index--;
            }
            array[index] = temp;
        }
    }

    /**
     * 选择排序
     *
     * @param array
     * @param size
     */
    public static void selectSort(int[] array, int size) {
        if (size < 2) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {

            int index = i;
            for (int j = i + 1; j < size - 1; j++) {
                if (array[j] < array[i]) {
                    index = j;
                }
            }
            if (index != i) {
                Helper.swap(array, i, index);
            }
        }
    }


    /**
     * 归并排序
     *
     * @param array
     * @param size
     */
    public static int[] mergeSort(int[] array, int size) {
        if (size < 2) {
            return array;
        }
        return Helper.mergeSort(array, 0, size - 1);
    }

    /**
     * 快排
     *
     * @param array
     * @param size
     */
    public static void quickSort(int[] array, int size) {
        if (size < 2) {
            return;
        }
        Helper.quickSort(array, 0, size - 1);
    }


    public static void main(String[] args) {
        int[] ints = {3, 2, 1, 4, 5, 8, 7, 6};
        quickSort(ints, 8);
    }

    private static class Helper {
        private static void swap(int[] array, int index1, int index2) {
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }

        private static int[] merge(int[] array1, int[] array2) {
            int[] temp = new int[array1.length + array2.length];
            int index1 = 0;
            int index2 = 0;

            for (int i = 0; i < temp.length; i++) {
                if (index1 == array1.length) {
                    temp[i] = array2[index2++];
                    continue;
                }

                if (index2 == array2.length) {
                    temp[i] = array1[index1++];
                    continue;
                }

                if (array1[index1] > array2[index2]) {
                    temp[i] = array2[index2++];
                } else {
                    temp[i] = array1[index1++];
                }
            }
            return temp;
        }

        private static int[] mergeSort(int[] array, int start, int end) {
            if (start >= end) {
                return new int[]{array[end]};
            }

            int pivot = (start + end) / 2;
            int[] temp1 = mergeSort(array, start, pivot);
            int[] temp2 = mergeSort(array, pivot + 1, end);
            return merge(temp1, temp2);
        }

        public static void quickSort(int[] array, int start, int end) {
            if (start >= end) {
                return;
            }

            //找出分区节点
            int partition = partition(array, start, end);
            quickSort(array, start, partition - 1);
            quickSort(array, partition + 1, end);
        }

        private static int partition(int[] array, int start, int end) {
            int temp = array[end];
            int index = start;

            for (int i = start; i <= end; i++) {
                if (array[i] < temp) {
                    if (index != i) {
                        swap(array, index, i);
                    }
                    index++;
                }
            }
            if (index != end) {
                swap(array, index, end);
            }
            return index;
        }


    }

}
