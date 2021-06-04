package com.wicket.algorithm;

public class Sushu {

    //暴力算法
    public static int bf(int n){
        int count = 0;
        for(int i=2;i<n; i++){
            count += isPrimePro(i) ? 1 : 0;
        }
        return count;
    }

    /**
     * 判断一个数是否为素数
     * @param x
     * @return
     */
    private static boolean isPrime(int x) {
        for(int i=2;i<x; i++){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 判断一个数是否为素数
     * @param x
     * @return
     */
    private static boolean isPrimePro(int x) {
        for(int i=2; i * i <= x; i++){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 埃筛法
     * 素数  非素数（合数，如12= 2*6）
     * @param n
     */
    public static int eratosthenes(int n){
        boolean[] isPrime = new boolean[n];  //false 代表素数
        int count = 0;
        for(int i = 2; i<n; i++){
            if(!isPrime[i]){
                count++;
                for(int j = 2*i; j<n ; j+=i){  //j是合数的标记位
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }

    /**
     * 埃筛法--优化版
     * 素数  非素数（合数，如12= 2*6）
     * @param n
     */
    public static int eratosthenesPro(int n){
        boolean[] isPrime = new boolean[n];  //false 代表素数
        int count = 0;
        for(int i = 2; i<n; i++){     //遍历，所有是当前数字的整数倍的位置的数字，必然不是素数，更改为true（不是素数）；最终位置为false的表示素数的个数。
            if(!isPrime[i]){
                count++;
                for(int j = 2*i; j<n ; j+=i){  //j是合数的标记位
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bf(100));
        System.out.println(eratosthenes(100));
        System.out.println(eratosthenesPro(100));
    }
}
