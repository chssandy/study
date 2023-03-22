package com.wicket.designPattern.builder;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Client
 * @description TODO
 * @date 2022/6/26 19:46
 */
public class Client {

    public static void main(String[] args) {
        // 盖普通房子
        CommonHouse commonHouse = new CommonHouse();
        //准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);

        //完成盖房子，返回产品（房子）
        houseDirector.constructHouse();
    }
}
