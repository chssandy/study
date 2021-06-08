package com.wicket.thread.producerConsumer;

import java.text.NumberFormat;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Product
 * @description TODO
 * @date 2021/5/7 10:45
 */
public class Product {
    private int productID;
    private double  price;

    public Product(int productNumber) {
        productID = productNumber;
        price = Math.random() *  100 + 5;
    }

   public String toString(){
        String amount = NumberFormat.getCurrencyInstance().format(price);
        return "Product ID: " + productID + "\t price: " + amount ;
   }
}
