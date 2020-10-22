package com.array;

/**
 * 动态数组
 *
 * @author huimeng.li
 */
public class DynamicArray<T> extends AbstractArray<T>{

    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        for (int i = 0; i < 10000; i++) {
            dynamicArray.add(i);
        }

        Integer integer = dynamicArray.get(999);
        dynamicArray.addAt(199988, 999);
        Integer integer2 = dynamicArray.get(999);
        Integer integer1 = dynamicArray.get(dynamicArray.size() - 1);

    }
}
