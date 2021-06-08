package com.wicket.thread.mutil;

import java.io.IOException;

public class T03_ThisEscape {

    private int num = 8;
    public T03_ThisEscape(){

        new Thread(()-> System.out.println(this.num == 8)).start();
    }

    public static void main(String[] args) throws IOException {
        for (long i =0; i<Long.MAX_VALUE;i++) {
            new T03_ThisEscape();
        }
        System.in.read();
    }
}
