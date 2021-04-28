package com.wicket.map;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname HashMapInvoiceApp
 * @description TODO
 * @date 2021/4/28 11:05
 */
public class HashMapInvoiceApp {
    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.addOrder("1122",new Product("Java",15,89.66));
        invoice.addOrder("1133",new Product("JSPS",12,78.99));
        invoice.addOrder("1124",new Product("Java",20,89.69));
        System.out.println("Product info: " + invoice.search("1133"));

        System.out.println("Get order info: " + invoice.getOrderInfo("Java"));

        System.out.println("Invoice info: " + invoice.getInvoiceTotal());
    }
}
