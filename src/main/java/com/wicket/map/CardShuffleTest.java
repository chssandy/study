package com.wicket.map;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname CardShuffleTest
 * @description 随机排序（洗牌）
 * @date 2021/4/27 17:53
 */
public class CardShuffleTest {
    public static void main(String[] args) {
        String[] cardArray = new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        List<String> cardList = Arrays.asList(cardArray);
        Collections.shuffle(cardList);
        System.out.println("cardList = " + cardList);
        Collections.shuffle(cardList,new Random(10));
        System.out.println("cardList = " + cardList);

    }
}
