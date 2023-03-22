package com.wicket.designPattern.builder;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname CommonHouse
 * @description TODO
 * @date 2022/6/26 19:39
 */
public class CommonHouse extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基5m");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子砌墙110m");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子封顶");
    }
}
