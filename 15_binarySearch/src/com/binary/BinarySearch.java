package com.binary;

/**
 * 二分查找
 *
 * @author huimeng.li
 */
public class BinarySearch {

    /**
     * 二分查找
     *
     * @param array
     * @param a
     * @return
     */
    public static int search(int[] array, int a) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (array[mid] == a) {
                return array[mid];
            } else if (array[mid] > a) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归二分查找
     *
     * @param array
     * @param a
     * @return
     */
    public static int recursionSearch(int[] array, int a, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start) >> 1);
        if (array[mid] == a) {
            return array[mid];
        } else if (array[mid] > a) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return recursionSearch(array, a, start, end);
    }

    /**
     * 模糊二分查找（大于指定值的第一个数）
     *
     * @param array
     * @param a
     * @return
     */
    public static int blurrySearch(int[] array, int a) {
        int start = 0;
        int end = array.length - 1;
        if (array[0] > a) {
            return array[0];
        }

        if (array[end] < a) {
            return -1;
        }

        while (start <= end) {
            int mid = start + ((end - start) >> 1);

            if (array[mid] == a) {
                return array[mid];
            } else if (array[mid] > a) {
                if (array[mid - 1] < a) {
                    return array[mid];
                } else {
                    end = mid - 1;
                }
            } else {
                if (array[mid + 1] > a) {
                    return array[mid + 1];
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 递归模糊二分查找
     * @param array
     * @param a
     * @return
     */
    public static int recursionBlurrySearch(int[] array, int a) {
        if (array[0] > a) {
            return array[0];
        }
        if (array[array.length-1] < a) {
            return -1;
        }
        return recursionBlurrySearch(array, a, 0, array.length);
    }

    private static int recursionBlurrySearch(int[] array, int a, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = start + ((end - start) >> 1) / 2;
        if (array[mid] == a) {
            return array[mid];
        }

        if (array[mid] < a) {
            if (array[mid + 1] > a) {
                return array[mid + 1];
            }
            start = mid + 1;
        }

        if (array[mid] > a) {
            if (array[mid - 1] < a) {
                return array[mid];
            }
            end = mid - 1;
        }
        return recursionBlurrySearch(array, a, start, end);
    }

    public static void main(String[] args) {
        int[] ins = new int[]{1, 3, 5, 7, 9};
        for (int i = 0; i < 11; i++) {
            int search = recursionSearch(ins, i, 0, ins.length-1);
            System.out.println("查出结果是：" + search);
        }
    }
}
