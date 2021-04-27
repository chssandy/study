package com.wicket.map;

import java.util.Comparator;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname NumberComparator
 * @description TODO
 * @date 2021/4/27 17:28
 */
public class NumberComparator implements Comparator<Items> {

    public int compare(Items items1,Items items2) {
        if (items1.getNumber() < items2.getNumber())
            return -1;
        if (items1.getNumber() > items2.getNumber())
            return 1;
        return 0;
    }
}
