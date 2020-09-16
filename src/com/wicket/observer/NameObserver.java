package com.wicket.observer;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname NameObserver
 * @description TODO
 * @date 2020/8/26 16:59
 */
public class NameObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if( arg instanceof String ){
            String name = (String) arg;
            JFrame f = new JFrame("观察者");
            JLabel l = new JLabel("名称改变为：" + name);
            f.add(l);
            f.pack();
            f.setVisible(true);
            System.out.println("名称观察者：" + o + "物品名称已经改变为：" + name);
        }
    }
}
