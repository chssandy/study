package com.wicket.stream.debug;

import com.wicket.stream.test.Point;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Debugging
 * @description TODO
 * @date 2020/9/24 9:21
 */
public class Debugging {
    public static void main(String[] args) {
//        List<Point> points = Arrays.asList(new Point(12,2), null);
//        points.stream()
//                .map(p -> p.getX())
//                .forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(2,3,4,5);
//        numbers.stream()
//                .map(x -> x+17)
//                .filter(x -> x % 2 == 0)
//                .limit(3)
//                .forEach(System.out::println);
        numbers.stream()
                .peek(x -> System.out.println("from stream:" + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map:" + x) )
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter:" +x))
                .limit(3)
                .peek(x -> System.out.println("after limit:" + x))
                .collect(Collectors.toList());
    }
}
