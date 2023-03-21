package com.wicket.stream.apiIteration;

import java.util.Arrays;
import java.util.List;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Game
 * @description TODO
 * @date 2020/9/24 9:48
 */
public class Game {
    public static void main(String[] args) {
        List<Resizable> resizablesShapes =
                Arrays.asList(new Ellipse(), new Ellipse(),new Ellipse());
        Utils.paint(resizablesShapes);
    }
}
