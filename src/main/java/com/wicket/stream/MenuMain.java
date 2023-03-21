package com.wicket.stream;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Main
 * @description TODO
 * @date 2020/9/7 16:33
 */
public class MenuMain {

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

        Map<Type , List<Dish>> dishesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType);

        Map<CaloricLevel,List<Dish>> dishesByCaloricLevel = menu.stream()
                .collect(
                        Collectors.groupingBy(dish -> {
                            if(dish.getCalories() <= 400) return CaloricLevel.DIEF;
                            else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        })
                );
        System.out.println(dishesByCaloricLevel);

        Map<Type,Map<CaloricLevel,List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        Collectors.groupingBy(Dish::getType,
                            Collectors.groupingBy(dish -> {
                                if(dish.getCalories() <= 400) return CaloricLevel.DIEF;
                                else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                else return CaloricLevel.FAT;
                            })
                        )
                );
        System.out.println(dishesByTypeCaloricLevel);

        Map<Type,Long> typesCount = menu.stream().collect(
                Collectors.groupingBy(Dish::getType,Collectors.counting())
        );
        System.out.println(typesCount);

        Map<Type,Dish> mostCaloricByType =
                menu.stream().collect(
                        Collectors.groupingBy(Dish::getType,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get
                                ))
                );
        System.out.println(mostCaloricByType);

        //把菜单按照素食和非素食去分开
        Map<Boolean,List<Dish>> partitionedMenu =
                menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);
        List<Dish> vegetarianDishes = partitionedMenu.get(true);
        System.out.println(vegetarianDishes);
        List<Dish> vegetarianDishesTrue = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        List<Dish> vegetarianDishesFalse = menu.stream().filter(dish -> dish.isVegetarian()==false).collect(Collectors.toList());
        System.out.println(vegetarianDishesTrue);
        System.out.println(vegetarianDishesFalse);



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
