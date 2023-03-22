package com.wicket.designPattern.builder;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname HouseBuilder
 * @description 抽象的建造者
 * @date 2022/6/26 19:36
 */
public abstract class HouseBuilder {

    protected House house = new House();

    //将建造的流程写好，抽象的方法
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    //建造房子,将产品返回
    public House buildHouse(){

        return house;
    }
}
