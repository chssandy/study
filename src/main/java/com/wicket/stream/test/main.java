package com.wicket.stream.test;

import org.junit.Assert;
import org.junit.Test;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname main
 * @description TODO
 * @date 2020/9/23 16:32
 */
public class main {
    @Test
    public void testMoveRightBy() throws Exception{
        Point p1 = new Point(5,5);
        Point p2 = p1.moveRightBy(10);

        Assert.assertEquals(15,p2.getX());
        Assert.assertEquals(5,p2.getY());

    }


}
