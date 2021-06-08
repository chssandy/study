package com.wicket.thread;

public class ThreadSleepApp {
    public static void main(String[] args) {
        Thread messageSix = new MessageSix();
        Thread messageFive = new MessageFive();

        messageSix.start();
        messageFive.start();
    }

    private static class MessageFive extends Thread{
        public void run(){
            for(int i=0;i<5;i++) {
                System.out.print("java");
                System.out.print("se");
            }
        }
    }

    private static class MessageSix extends Thread{
        public void run(){
            try {
                Thread.sleep(500);
                for(int i=0;i<5;i++){
                    System.out.print("\n Programming ");
                    System.out.print(" Language");
                }
            } catch (InterruptedException e) {
//                e.printStackTrace();
                System.out.println(e);
            }
        }
    }
}
