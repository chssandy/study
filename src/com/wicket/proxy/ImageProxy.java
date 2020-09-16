package com.wicket.proxy;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname ImageProxy
 * @description TODO
 * @date 2020/8/26 11:04
 */
public class ImageProxy implements Image {

    //组合一个image实例，作为被代理的对象
    private Image image;

    public ImageProxy(Image image){
        this.image = image;
    }

    /**
     * 重写Image接口的show()方法
     * 该方法用于控制对被代理对象的访问
     * 并根据需要负责创建和删除被代理对象
     */
    @Override
    public void show() {
        //只有当真正需要调用image的show方法时才创建被代理对象
        if(image == null){
            image = new BigImage();
        }
        image.show();
    }
}
