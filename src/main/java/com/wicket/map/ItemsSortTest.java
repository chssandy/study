package com.wicket.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname ItemsSortTest
 * @description TODO
 * @date 2021/4/27 17:30
 */
public class ItemsSortTest {
    public static void main(String[] args) {
        List<Items> list = new ArrayList<Items>();
        Items myItem = new Items(100,"software");
        Items hisItem = new Items(10,"hardware");
        Items herItem = new Items(15,"middleware");

        list.add(myItem);
        list.add(hisItem);
        list.add(herItem);
        Collections.sort(list,new NumberComparator());

        int ind = Collections.binarySearch(list,myItem,new NumberComparator());
        System.out.println(list);
        System.out.println("index of hisItem:"+ ind);

        List<Integer> iList = new ArrayList<Integer>();
        iList.add(88);
        iList.add(888);
        iList.add(8);
        Collections.sort(iList);
        int index = Collections.binarySearch(iList,88);
        System.out.println(iList);
        System.out.println("index of 88:" + index);
    }
}
