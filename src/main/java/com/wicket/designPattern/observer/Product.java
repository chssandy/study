package com.wicket.designPattern.observer;

import java.util.Observable;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Product
 * @description TODO
 * @date 2020/8/26 16:54
 */
public class Product extends Observable {

    //定义两个成员变量
    private String name;
    private double price;

    public Product(){}

    public Product(String name,double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    //当程序调用name的setter方法来修改Product的name成员变量时，程序自然触发该对象上注册的所有观察者
    public void setName(String name){
        this.name = name;
        this.setChanged();
        notifyObservers(name);
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
        this.setChanged();
        notifyObservers(price);
    }
}
