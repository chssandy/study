package com.wicket.stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Main
 * @description TODO
 * @date 2020/9/7 16:33
 */
public class Main {

    public static void process(Runnable r){
        r.run();
    }


    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork",false,800, Type.MEAT),
                new Dish("beef",false,700, Type.MEAT),
                new Dish("chicken",false,400, Type.MEAT),
                new Dish("french fries",false,530, Type.OTHER),
                new Dish("rice",true,350, Type.OTHER),
                new Dish("season friute",false,120, Type.OTHER),
                new Dish("pizza",true,550, Type.OTHER),
                new Dish("prawns",false,300, Type.FISH),
                new Dish("salmon",false,450, Type.FISH)
        );
        System.out.println(menu.stream()
                .reduce((acc,item) ->{
                    if(item.getCalories() < 400){
                        acc = item;
                    }
                    return acc;
                }).toString());

//        List<Integer> threeHighCaloricDishNames =  menu.stream()
////                .filter(dish -> dish.getCalories() > 300)
//                .map(Dish::getName)
//                .map(String::length)
////                .sorted(comparing(t -> Dish.getCalories(t)))
////                .distinct()
////                .limit(3)
//                .collect(Collectors.toList());
//        System.out.println(threeHighCaloricDishNames);
//
////        List<String> title = Arrays.asList("Java8","In","Action");
////        Stream<String> s = title.stream();
////        s.forEach(System.out::println);
////        s.forEach(System.out::println);
//        List<String> worlds = Arrays.asList("Hello","World");
//        System.out.println(worlds.stream()
//                .map(word -> word.split(""))
//                .distinct()
//                .collect(Collectors.toList()));
//
//        String[] arrayOfWorlds = {"Goodbye","World"};
//        Stream<String> streamOfWords = Arrays.stream(arrayOfWorlds);
//        System.out.println(worlds.stream()
//                .map(word -> word.split(""))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .collect(Collectors.toList()));



    }

    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }
}
