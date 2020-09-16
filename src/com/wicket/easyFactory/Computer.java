package com.wicket.easyFactory;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Computer
 * @description TODO
 * @date 2020/8/26 10:03
 */
public class Computer {
    private Output out;
    public Computer(Output out){
        this.out = out;
    }

    public void keyIn(String msg){
        out.getData(msg);
    }

    public void print(){
        out.out();
    }

    public static void main(String[] args) {
        OutputFactory of = new OutputFactory();
        Computer c = new Computer(of.getOutput());
        c.keyIn("测试");
        c.keyIn("aa");
        c.keyIn("bb");
        c.keyIn("cc");
        c.print();
    }
}
