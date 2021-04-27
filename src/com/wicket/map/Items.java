package com.wicket.map;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Items
 * @description TODO
 * @date 2021/4/27 17:26
 */
public class Items {
    private int number;
    private String name;

    Items(int number,String name){
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Items{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
