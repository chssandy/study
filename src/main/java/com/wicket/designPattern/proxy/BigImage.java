package com.wicket.designPattern.proxy;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname BigImage
 * @description TODO
 * @date 2020/8/26 11:02
 */
public class BigImage implements Image {

    public BigImage(){
        try{
            Thread.sleep(3000);
            System.out.println("图片装载成功...");
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void show() {
        System.out.println("绘制实际的大图片");
    }
}
