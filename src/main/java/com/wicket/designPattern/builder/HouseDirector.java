package com.wicket.designPattern.builder;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname HouseDirector
 * @description 指挥者，这里去指定动态流程
 * @date 2022/6/26 19:42
 */
public class HouseDirector {
    HouseBuilder houseBuilder = null;

    //构造器传入houseBuilder
    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //通过setter传入

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //如何处理建房子的流程，交给指挥者
    public House constructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}
