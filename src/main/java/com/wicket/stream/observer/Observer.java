package com.wicket.stream.observer;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Observer
 * @description 观察者模式，定义一个观察者接口。它将不同观察者聚合到一起，一旦接收到一条新的新闻，该方法就会被调用
 *
 * @date 2020/9/23 12:01
 */
public interface Observer {
    void notify(String tweet);
}
