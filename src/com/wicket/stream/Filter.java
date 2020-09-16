package com.wicket.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Filter
 * @description TODO
 * @date 2020/9/14 15:59
 */
public class Filter {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);

        int sum = 0;
        for(int x : numbers){
            sum += x;
        }
        System.out.println(sum);

        int sum1 = numbers.stream()
                .reduce(0,(a,b)-> a+b);
        System.out.println(sum1);

        Optional<Integer> min =numbers.stream()
                .reduce(Integer::min);
        System.out.println(min.get());

        int sump = numbers.parallelStream().reduce(0,Integer::sum);
        System.out.println(sump);

        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .skip(1)
                .limit(1)
                .forEach(System.out::println);

        List<String> words = Arrays.asList("Java 8","Lambdas","In","Action");

        List<Integer> wordLengths = words.stream()
                .map(String ::length)
                .collect(Collectors.toList());
        System.out.println(wordLengths);

        List<String> wordsSplit =  words.stream()
                .map(word -> word.toLowerCase().split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
//                .forEach(System.out::println);
        System.out.println(wordsSplit);

        String world = words.stream()
                .map(word -> word.toLowerCase().split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .findFirst()
                .get();
        System.out.println(world);
    }
}
