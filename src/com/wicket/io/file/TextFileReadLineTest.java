package com.wicket.io.file;

import java.io.*;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname TextFileReadLineTest
 * @description TODO
 * @date 2021/5/8 9:44
 */
public class TextFileReadLineTest {
    public static void main(String[] args) {
        String fileName = "F:/io/numberData.txt";
        try{
            File myFile = new File(fileName);
            BufferedReader in = new BufferedReader(new FileReader(myFile)); //创建文本输入对象
            String line = in.readLine();    //读入一行数据
            while(line != null){            //如果没有读到文件结尾
                System.out.println(line);
                line = in.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
