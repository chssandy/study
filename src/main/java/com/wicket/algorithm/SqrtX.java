package com.wicket.algorithm;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname ArrayCenterIndex
 * @description 在不使用sqrt(x)函数的情况下，得到x的平方根的整数部分
 * @date 2021/6/8 11:57
 */
public class SqrtX {
    public static void main(String[] args) {
//        System.out.println(binarySearch(24));
        System.out.println(newtown(24));
    }

    //二分查找
    public static int binarySearch(int x){
        int index = -1,l = 0, r = x;
        while(l <= r){
            int mid = l + (r-l)/2 ;
            if( mid * mid <= x){
                index = mid;
                l = mid + 1;
            }else{
                r = mid -1;
            }
        }
        return index;
    }

    //牛顿迭代
    public static int newtown(int x){
       return (int) sqrt(x,x);
    }

    public static double sqrt(double i ,int x){
        double res = (i+x/i)/2;    //判断 i 和 x/i 的均值。如：x=12 ，i = 2，x/i = 6 ，则均值为4 ；4 应该比 2，或者6 更接近 根号12。
                                    // 如果4和2不等，则迭代计算 4 和 12/4 =3 的均值 3.5 ，则3.5更接近根号12，直至 求出均值==根号x的double值
        if(res == i){
            return i;
        }else{
           return  sqrt(res,x);
        }
    }
}
