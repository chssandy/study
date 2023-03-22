package com.wicket.designPattern.builder;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname HightBuilding
 * @description TODO
 * @date 2022/6/26 19:41
 */
public class HightBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("高楼打地基100m");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼砌墙10000m");
    }

    @Override
    public void roofed() {
        System.out.println("高楼封顶");
    }
}
