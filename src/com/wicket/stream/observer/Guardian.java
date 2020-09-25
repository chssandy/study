package com.wicket.stream.observer;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Guardian
 * @description TODO
 * @date 2020/9/23 12:31
 */
public class Guardian implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")){
            System.out.println("Breaking news in London! " + tweet);
        }
    }
}
