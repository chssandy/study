package com.wicket.algorithm.string;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname BruteForce
 * @description BF算法：即暴力(Brute Force)算法，是普通的模式匹配算法，
 * BF算法的思想就是将目标串S的第一个字符与模式串T的第一个字符进行匹配，
 * 若相等，则继续比较S的第二个字符和 T的第二个字符；若不相等，则比较S的第二个字符和T的第一个字符，依次比较下去，
 * 直到得出最后的匹配结果。BF算法是一种蛮力算法
 * @date 2022/07/05 15:44
 */
public class BruteForce {

    /***
     * 暴力算法
     * @param pat
     * @param org
     * @return
     */
    public static int bruteForce(String pat,String org,int position) {
        byte[] patter = pat.getBytes();
        byte[] text = org.getBytes();
        int pl = patter.length;
        int tl = text.length;
        int result = -1;
        int max = tl - pl;
        if (position < 0 || pl > tl || max - position < 0) {
            return -1;
        }

        for (int i = position; i <= max; i++) {
            int count = 0;
            for (int j = 0; j < pl; j++) {
                if (patter[j] == text[i + j]) {
                    ++count;
                }
            }
            if (count == pl) {
                result = i;
                break;
            }
        }
        return result;
    }

}
