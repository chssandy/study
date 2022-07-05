package com.wicket.algorithm.string;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname BoyerMoore
 * @description BM算法:
 * 参考：https://blog.csdn.net/lucky__peng/article/details/123748020
 *
 * @date 2022/07/05 15:48
 */
public class BoyerMoore {

    // 全局变量
    private static final int SIZE = 256;
    /**
     * @param b：模式串
     * @param m：模式串的长度
     * @param bc：散列表
     */
    private void generateBC(char[] b, int m, int[] bc){
        for (int i = 0; i < SIZE; ++i) {
            bc[i] = -1;   // 初始化 bc
        }
        for (int i = 0; i < m; ++i) {
            // 计算 b[i]的 ASCII 值
            int ascii = (int)b[i];
            // 将下标i存储到散列表中下标为b[i]散列值的位置
            bc[ascii] = i;
        }
    }
    /**
     * @param a：主串
     * @param n：主串a的长度
     * @param b：模式串
     * @param m：模式串的长度
     * @return
     */
//    public int bm(char[] a, int n, char[] b, int m){
//        // 记录模式串中每个字符最后出现的位置
//        int[] bc = new int[SIZE];
//        // 构建坏字符哈希表
//        generateBC(b, m, bc);
//        // i表示主串与模式串对齐的第一个字符
//        int i = 0;
//        while(i <= n - m){
//            int j;
//            for (j = m - 1; j >= 0; --j) {
//                if(a[i + j] != b[j]){
//                    // 坏字符对应模式串中的下标是j
//                    break;
//                }
//            }
//            if(j < 0){
//                // 匹配成功，返回主串与模式串第一个匹配的字符的位置
//                return i;
//            }
//            // 这里等同于将模式串往后滑动 j-bc[(int)a[i+j]]位
//            i = i + (j - bc[(int)a[i + j]]);
//        }
//        return -1;  // 没找到
//    }
    /**
     * @param b：模式串
     * @param m：模式串的长度
     * @param suffix
     * @param prefix
     */
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix){
        // 初始化
        for (int i = 0; i < m; ++i) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        // b[0,i]
        for (int i = 0; i < m - 1; i++) {
            int j = i;
            int k = 0;   // 公共后缀子串长度
            while(j >= 0 && b[j] == b[m - 1 - k]){
                // 与b[0,m-1]求公共后缀子串
                --j;
                ++k;
                // j+1表示公共后缀子串在b[0,i]中的起始下标
                suffix[k] = j + 1;
            }
            if(j == -1){
                // 如果公共后缀子串也是模式串的前缀子串
                prefix[k] = true;
            }
        }
    }

    // a,b 表示主串和模式串；n，m 表示主串和模式串的长度。
    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE]; // 记录模式串中每个字符最后出现的位置
        generateBC(b, m, bc); // 构建坏字符哈希表
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);
        int i = 0; // j 表示主串与模式串匹配的第一个字符
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
                if (a[i+j] != b[j]) break; // 坏字符对应模式串中的下标是 j
            }
            if (j < 0) {
                return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
            }
            int x = j - bc[(int)a[i+j]];
            int y = 0;
            if (j < m-1) { // 如果有好后缀的话
                y = moveByGS(j, m, suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }
    // j 表示坏字符对应的模式串中的字符下标 ; m 表示模式串长度
    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j; // 好后缀长度
        if (suffix[k] != -1) return j - suffix[k] +1;
        for (int r = j+2; r <= m-1; ++r) {
            if (prefix[m-r] == true) {
                return r;
            }
        }
        return m;
    }
}
