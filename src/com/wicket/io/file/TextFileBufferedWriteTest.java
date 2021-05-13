package com.wicket.io.file;

import com.sun.javafx.geom.BaseBounds;
import com.wicket.stream.apiIteration.F;

import java.io.*;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname TextFileBufferedWriteTest
 * @description TODO
 * @date 2021/5/8 9:25
 */
public class TextFileBufferedWriteTest {
    public static void main(String[] args) {
        short age = 89;
        int count = 100;
        float price = 89.56f;
        long population = 1300000000;
        double invest = 678900000;

        try{
            // 无缓冲的文本输出
            PrintWriter outPrintWriter = new PrintWriter(new File("F:/io/numberData.txt"));
            outPrintWriter.println("无缓冲的文本输出");
            outPrintWriter.println("suibian");
            outPrintWriter.println("test");
            outPrintWriter.close();


            //缓冲文本文件输出
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(
                                    new File("F:/io/numberData1.txt"),true)));   //文件结尾添加为真，追加
            out.println(age);
            out.println(count);
            out.println(price);
            out.println(population);
            out.println(invest);
            out.println(invest/population);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
