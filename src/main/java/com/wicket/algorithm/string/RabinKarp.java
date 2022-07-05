package com.wicket.algorithm.string;

import java.nio.charset.StandardCharsets;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname RabinKarp
 * @description RK算法:
 * RK算法的核心思想就是将主串或模式串拆分后子串换成一个哈希值
 * @date 2022/07/05 15:47
 */
public class RabinKarp {

    /***
     * hashcode算法
     * @param patter
     * @param text
     * @return
     */
    public static int hashCode(String patter,String text,int position) {
        int result = -1;
        int length = patter.length();
        int max = text.length() - length;
        if (position < 0 || max < 0||max-position<0) {
            return result;
        }
        int patterHash = patter.hashCode();
        byte[] pat = patter.getBytes(StandardCharsets.UTF_8);
        for (int i = position; i <= max; i++) {
            String sub = text.substring(i, length + i);
            int subHash = sub.hashCode();
            int count = 0;
            if (patterHash == subHash) {
                byte[] org = sub.getBytes(StandardCharsets.UTF_8);
                for (int j = 0; j < pat.length; j++) {
                    if (pat[j] == org[j]) {
                        ++count;
                    }
                }
            }
            if (count == length) {
                result = i;
                break;
            }
        }
        return result;
    }

}
