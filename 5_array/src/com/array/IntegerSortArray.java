package com.array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author huimeng.li
 */
public class IntegerSortArray<Integer> extends AbstractArray<Integer> {

    @Override
    public boolean add(Integer integer) {
        int integer1 = (int) integer;


        if (integer1 == 0) {
            super.add(integer);
            return true;
        }

        if (integer1 == 1) {
            int integer2 = (int) this.get(0);
            if (integer2 > integer1) {
                super.addAt(integer, 0);
            } else {
                super.add(integer);
            }
            return true;
        }

        int head = 0;

        return;
    }
}
