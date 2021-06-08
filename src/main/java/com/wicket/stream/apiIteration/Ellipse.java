package com.wicket.stream.apiIteration;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Ellipse
 * @description TODO
 * @date 2020/9/24 9:46
 */
public class Ellipse implements Resizable {
    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public void setHeight(int height) {

    }

    @Override
    public void setAbsoluteSize(int width, int height) {
        System.out.println("用户已经实现了此接口");
    }
}
