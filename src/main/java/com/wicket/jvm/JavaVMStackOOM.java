package com.wicket.jvm;

/**
*VM Args᧶-Xss2M᧤扨㢅⊨ₜⰷ幍函⮶K᧥
*@author zzm
*/
public class JavaVMStackOOM{
    private void dontStop(){
        while(true){
        }
    }
    public void stackLeakByThread(){
        while(true){
            Thread thread=new Thread(new Runnable(){
                @Override
                public void run(){
                    dontStop();
                }
            });
            thread.start();
        }
    }
    public static void main(String[] args) throws Throwable{
        JavaVMStackOOM oom=new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}