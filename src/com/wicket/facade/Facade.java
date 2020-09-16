package com.wicket.facade;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Facade
 * @description TODO
 * @date 2020/8/26 15:20
 */
public class Facade {

    Payment pay;
    Cook cook;
    Waiter waiter;

    public Facade(){
        this.pay = new PaymentImpl();
        this.cook = new CookImpl();
        this.waiter = new WaiterImpl();
    }

    public void serveFood(){
        String food = pay.pay();
        food = cook.cook(food);
        waiter.server(food);
    }
}
