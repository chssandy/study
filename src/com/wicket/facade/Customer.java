package com.wicket.facade;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Customer
 * @description TODO
 * @date 2020/8/26 15:18
 */
public class Customer {
    public void haveDinner(){
//        Payment pay = new PaymentImpl();
//        Cook cook = new CookImpl();
//        Waiter waiter = new WaiterImpl();
//
//        String food = pay.pay();
//        food = cook.cook(food);
//        waiter.server(food);
        Facade f = new Facade();
        f.serveFood();
    }
}
