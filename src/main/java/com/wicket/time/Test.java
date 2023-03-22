package com.wicket.time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Test
 * @description TODO
 * @date 2022/07/08 11:16
 */
public class Test {


    public static void main(String[] args) {

        Date lastRequestTime = new Date(122, 6, 2, 0, 0, 0);
        Date whileEnd;


        do{
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(lastRequestTime);
            // 把日期往后增加一天,整数  往后推,负数往前移动
            calendar.add(calendar.DATE, 1);
            // 这个时间就是日期往后推一天的结果
            lastRequestTime=calendar.getTime();
            System.out.println("=="+ lastRequestTime);

            calendar.add(calendar.DATE, 1);
            // 这个时间就是日期往后推一天的结果
            whileEnd=calendar.getTime();

        }while (whileEnd.before(new Date()));


    }
}
