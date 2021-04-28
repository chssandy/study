package com.wicket.map;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashMap;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Invoice
 * @description TODO
 * @date 2021/4/28 9:53
 */
public class Invoice {
    private HashMap<String, Product> orderMap;  //声明HashMap集合
    private Collection<com.wicket.map.Product> orderList;  //声明collection集合
    NumberFormat currency = NumberFormat.getCurrencyInstance();  //声明货币输出格式

    public Invoice(){
        orderMap = new HashMap<String,Product>();
    }

    public void addOrder(String code, Product product){
        orderMap.put(code,product);
    }

    public String search(String code){    //按照key查询产品订购信息
        String message = null;
        Product product = orderMap.get(code);
        double total = product.getQuantity() * product.getPrice();
        message = "Product: " + product.getName()
                +"\n Quantity: " + product.getQuantity()
                +"\n Price: " + currency.format(product.getPrice())
                +"\n Total: " + total;
        return message;
    }

    public String getOrderInfo(String name){   //查询指定产品订购信息
        orderList = orderMap.values();
        int totalQuantity = 0;
        double totalAmount = 0.0;
        String message;
        for(Product order : orderList){
            if(name.equals(order.getName())){
                totalQuantity += order.getQuantity();
            }
            totalAmount += order.getPrice();
        }
        totalAmount += totalQuantity;
        message ="Product name: " + name
                +"\n Total quantity: " + totalQuantity
                +"\n Total amount: " + totalAmount;
        return message;
    }

    public String getInvoiceTotal(){
        orderList = orderMap.values();
        double total = 0.0;
        for(Product order : orderList){
            total += order.getPrice() * order.getQuantity();
        }
        return "Grand Total : " + currency.format(total);
    }
}
