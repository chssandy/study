package com.wicket.algorithm;

/**
 * 线程获取多为数组最大值
 */
public class ThreadFindMaxApp {
    public static void main(String[] args) {
        final int ROW = 2000,COL = 4000;
        Long startTime = Long.valueOf(0), endTime = Long.valueOf(0);
        MaxThread[] eachMaxThread = new MaxThread[ROW];   //处理每行最大数的线程数组
        double[][] matrix = Matrix.generator(ROW,COL);    //产生随机二位数组
        double max = Double.MIN_VALUE;                   //最大值初始化
        for(int i=0;i<eachMaxThread.length;i++){         //创建线程数组
            eachMaxThread[i] = new MaxThread(matrix[i]);
            eachMaxThread[i].start();     //可执行状态
        }
        try{
            startTime = System.currentTimeMillis();   //得到开始运行时间
            System.out.println("start time: " + startTime);
            for(int i=0;i<eachMaxThread.length;i++){
                eachMaxThread[i].join();    //使每个线程执行完毕
                max = Math.max(max,eachMaxThread[i].getMax());   //得到最大数
            }
            endTime = System.currentTimeMillis();
            System.out.println("end time : " + endTime);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("Max of the matrix  is " + max);  //打印所有数组中的最大值
        System.out.println("Completion time : " + (endTime - startTime) + " ms.");

        startTime = System.currentTimeMillis();   //得到开始运行时间
        System.out.println("start time: " + startTime);
        for(int i=0;i<ROW;i++)
            for(int j=0;j<COL;j++)
                max = Math.max(max,matrix[i][j]);
        endTime = System.currentTimeMillis();
        System.out.println("end time : " + endTime);
        System.out.println("Max of the matrix  is " + max);  //打印所有数组中的最大值
        System.out.println("Completion time : " + (endTime - startTime) + " ms.");
    }

    static class MaxThread extends Thread{   //MaxThread类
        private double max = Double.MIN_VALUE;   //最大值初始化
        private double[] eachArray;   //每行数组

        public MaxThread(double[] eachArray){  //构造方法
            this.eachArray = eachArray;
        }
        public void run(){
            for(int i=0;i<eachArray.length;i++){
                max = Math.max(max,eachArray[i]);
            }
        }
        public double getMax(){
            return max;
        }
    }

    static class Matrix{  //产生随机二维数组
        public static double[][] generator(int row,int col){
            //静态方法返回随机产生的二维数组
            double[][] matrix = new double[row][col];
            for(int i=0;i<row;i++)
                for(int j=0;j<col;j++)
                    matrix[i][j] = Math.random() * 101;
            return matrix;
        }
    }
}
