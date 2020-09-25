package com.wicket.stream.observer;


/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Subject
 * @description TODO
 * @date 2020/9/23 13:41
 */
interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}
