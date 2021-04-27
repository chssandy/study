package com.wicket.map;

import java.util.TreeMap;

public class MyTreeMap {
    public static void main(String[] args) {
        TreeMap<String,String> emailMap = new TreeMap<String,String>();
        emailMap.put("zhao123@yahu.com","zhao xiao");
        emailMap.put("qian_li@hotmail.com","Li Qian");
        emailMap.put("chs_sandy@163.com","sandy");
        String firstKey = emailMap.firstKey();
        System.out.println(firstKey);
        String lowerKey = emailMap.lowerKey("zhao123@yahu.com");
        System.out.println(lowerKey);
        String value = emailMap.get("zhao xiao");
        System.out.println(value);
        System.out.println(emailMap);
        System.out.println(emailMap.higherEntry("zhao xiao"));
        System.out.println(emailMap.higherEntry("Li Qian"));
        System.out.println(emailMap.higherEntry("sandy"));
    }
}
