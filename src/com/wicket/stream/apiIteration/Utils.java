package com.wicket.stream.apiIteration;

import java.util.List;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Utils
 * @description TODO
 * @date 2020/9/24 9:54
 */
public class Utils {
    public static void paint(List<Resizable> l){
        l.forEach( r -> {
            r.setAbsoluteSize(42,42);
//            r.draw();
            r.setRelativeSize(12,12);
        });
    }
}
