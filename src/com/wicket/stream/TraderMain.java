package com.wicket.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname TraderMain
 * @description TODO
 * @date 2020/9/15 14:26
 */
public class TraderMain {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,710),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)
        );

        List<Transaction> tr2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getYear))
                .collect(Collectors.toList());
        System.out.println(tr2011);

        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cities);

        Set<String> citiess = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());
        System.out.println(citiess);

        // 查找所有来自于剑桥的交易员，并按姓名排序
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(traders);

        // 查找所有交易员的姓名字符串，按字母顺序排序
        String traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1,n2) -> n1 + n2);
        System.out.println(traderStr);

        // 查找所有交易员的姓名字符串，按字母顺序排序
        String traderStrJoin = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println(traderStrJoin);

        //有没有交易员在米兰工作的
        boolean milanBased = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);

        //打印生活在剑桥的交易员的所有交易额
        transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //所有交易中，最高的交易额是多少
        Optional<Integer> highestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(highestValue);

        //映射到数值流
        int sum = transactions.stream()
                .mapToInt(transaction -> transaction.getValue())
                .sum();
        System.out.println(sum);

        //转换回对象流
        IntStream intStream = transactions.stream()
                .mapToInt(Transaction::getValue);
        Stream<Integer> stream = intStream.boxed();

        //默认值OptionalInt
        OptionalInt maxValues = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max();
        int max = maxValues.orElse(1);
        System.out.println(max);


        IntStream evenNumbers = IntStream.range(1,100)
                .filter(n -> n % 2 ==0);
        System.out.println(evenNumbers.count());

        IntStream evenNumbersClosed = IntStream.rangeClosed(1,100)
                .filter(n -> n % 2 ==0);
        System.out.println(evenNumbersClosed.count());
    }
}
