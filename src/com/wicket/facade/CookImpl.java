package com.wicket.facade;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname CookImpl
 * @description TODO
 * @date 2020/8/26 15:15
 */
public class CookImpl implements Cook {
    @Override
    public String cook(String food) {
        System.out.println("厨师正在烹调："+food);
        return food;
    }
}
