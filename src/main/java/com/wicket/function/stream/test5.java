package com.wicket.function.stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname test4
 * @description TODO
 * @date 2023/3/20 21:05
 */
public class test5 {

    public static void main(String[] args) {
        // 获取作者列表
        List<Author> authors = StreamDemo.getAuthors();
//        test01(authors);
//        test02();
//        test03();
//        test04(authors);
//        test05(authors);
//        test06(authors);
//        test07(authors);
//        test08(authors);
//        test09(authors);
//        test10(authors);
//        test11(authors);
//        test12(authors);
        test13(authors);
    }

    private static void test13(List<Author> authors) {
//        authors.parallelStream() //并行流
        // 求所有作者年龄和
        Integer sum = authors.stream()
                .map(author -> author.getAge())
                .reduce(0, (result, element) -> result + element);
        System.out.println(sum);
        // 求所有作者年龄中年龄最大的
        Integer max = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE,(result,element) -> result>element?result:element);
        System.out.println(max);
        // 求所有作者年龄中年龄最小的
        Integer min = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MAX_VALUE,(result,element) -> result<element?result:element);
        System.out.println(min);
        // 求所有作者年龄中年龄最小的
        Integer minn = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE,
                        (result, element) -> result - element,
                        (result, element) -> result>element?result:element);
        System.out.println(min);
    }

    private static void test12(List<Author> authors) {
        long count = authors.stream()
                .count();
        System.out.println(count);

        int maxAge = authors.stream()
                .map(author -> author.getAge())
                .max((o1, o2) -> o1-o2)
                .get();
        int maxAge1 = authors.stream()
                .map(author -> author.getAge())
                .max((o1, o2) -> o2-o1)
                .get();
        System.out.println(maxAge);
        System.out.println(maxAge1);
        int minAge = authors.stream()
                .map(author -> author.getAge())
                .min((o1, o2) -> o1-o2)
                .get();
        System.out.println(minAge);
    }

    private static void test11(List<Author> authors) {
        //打印所有书籍的分类，要求分类进行去重，不能出现这种格式：哲学,爱情
        authors.stream()
                .flatMap(author -> author.getBooks()!=null?author.getBooks().stream():null)
                .distinct()
                .flatMap(book -> book.getCategory()!=null?
                        Arrays.stream(book.getCategory().split(",")).distinct():
                        null)
                .distinct()
                .forEach(category -> System.out.println(category));

    }

    private static void test10(List<Author> authors) {
        //打印所有书籍的名字，要求对重复的元素进行去重
//        authors.stream()
//                .map(author -> author.getBooks())
//                .flatMap(books -> books!=null?books.stream():null)
//                .distinct()
//                .forEach(book-> System.out.println(book.getName()));
        authors.stream()
                .flatMap(author -> author.getBooks()!=null?author.getBooks().stream():null)
                .distinct()
                .forEach(book -> System.out.println(book.getName()));
    }

    private static void test09(List<Author> authors) {
        //对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素，然后打印除了年龄最大的其他所有作家姓名
        authors.stream()
                .distinct()
                .sorted()
                .skip(2)
                .forEach(author -> System.out.println(author));
    }

    private static void test08(List<Author> authors) {
        //对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素，然后打印其中年龄最大的两个作家姓名
        authors.stream()
                .distinct()
                .sorted()
                .limit(2)
                .forEach(author -> System.out.println(author));
    }

    private static void test07(List<Author> authors) {
        // 对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素
        authors.stream()
                .distinct()
                .sorted()
//                .sorted(new Comparator<Author>() {
//                    @Override
//                    public int compare(Author o1, Author o2) {
//                        return o2.getAge()-o1.getAge();
//                    }
//                })
                .forEach(author -> System.out.println(author));
    }

    private static void test06(List<Author> authors) {
        // 打印所有作家的姓名,并且要求其中不能有重复元素
        authors.stream()
                .distinct() //此处去重 author信息完全相同的部分
                .map(author -> author.getName())
                .distinct() //此处去重name相同的部分
                .forEach(name -> System.out.println(name));
    }

    private static void test05(List<Author> authors) {
        // 打印所有作家的姓名
        authors.stream()
                .map(author -> author.getName())
                .forEach(name -> System.out.println(name));
    }

    private static void test04(List<Author> authors) {
        // 打印所有姓名长度大于1的作家的姓名
        authors.stream()
                .filter(author -> author.getName().length()>1)
                .forEach(author -> System.out.println(author.getName()));
    }


    private static void test03() {
        Map<String,Integer> map = new HashMap<>();
        map.put("蜡笔小新",19);
        map.put("小黑",17);
        map.put("李向阳",16);

        Stream stream1 = Stream.of(map);
        stream1
                .forEach(entry -> System.out.println(entry));
        Stream<Map.Entry<String,Integer>> stream = map.entrySet().stream();
        stream
                .filter(entry -> entry.getValue() > 16)
                .forEach(entry -> System.out.println(entry.getKey()+"---"+entry.getValue()));
    }


    private static void test01(List<Author> authors) {
        //我们可以调用getAuthors方法获取到作家的集合，现在需要打印所有年了小于18的作家的名字，并且要注意去重
        authors.stream()
                .distinct()
                .filter(author -> author.getAge() < 18)
                .forEach(author -> System.out.println(author.getName()));
    }
    private static void test02() {
        Integer[] arr = {1,2,3,4,5};
        Stream<Integer> stream = Arrays.stream(arr);
        stream
                .filter(integer -> integer>2)
                .forEach(s -> System.out.println(s));
        ;
        Stream<Integer> stream1 = Stream.of(arr);
        stream1
                .filter(integer -> integer>2)
                .forEach(s -> System.out.println(s));
        ;
    }


}
