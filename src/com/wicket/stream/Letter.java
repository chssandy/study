package com.wicket.stream;

import java.util.function.Function;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Letter
 * @description TODO
 * @date 2020/9/9 14:25
 */
public class Letter {

    public static String addHeader(String text) {
        return "From Raoul, Mario and Alan:" + text;
    }

    public static String addFooter(String text){
        return text + "Kind regards";
    }

    public static String checkSpelling(String text){
        return text.replaceAll("labda","lambda");
    }


    Function<String,String> addHeader = Letter::addHeader;
    Function<String,String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
            .andThen(Letter::addFooter);
}
