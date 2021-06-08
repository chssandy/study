package com.wicket.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname CreateStreamType
 * @description TODO
 * @date 2020/9/16 15:47
 */
public class CreateStreamType {
    public static void main(String[] args) {
        //由值创建流
        Stream<String> stream = Stream.of("Java 8","Lambdas","In","Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
        //得到一个空流
        Stream<String> emptyStream = Stream.empty();

        //由数组创建流
        int[] numbers = {2,3,5,7,11,13};
        int sum = Arrays.stream(numbers).sum();

        //由文件生成流
        long uniqueWords = 0;
        try(Stream<String> lines =
                Files.lines(Paths.get("E://闲侠3.4.7修改点.txt"), Charset.defaultCharset())){
//            lines.forEach(System.out::println);
//            uniqueWords = lines.flatMap(line ->Arrays.stream(line.split("")))
//                    .distinct()
//                    .count();
        }catch (IOException e){

        }
        System.out.println(uniqueWords);

        //由函数生成流：创建无限流
        //1.迭代
        Stream.iterate(0,n->n+2)
                .limit(10)
                .forEach(System.out::println);

        Stream.iterate(new int[]{0,1},t->new int[]{t[1],t[0]+t[1]})
                .limit(20)
                .forEach(t-> System.out.println("("+t[0]+","+t[1]+")"));
        //2.生成
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
