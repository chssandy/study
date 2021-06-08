package com.wicket.io.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname TextFileReadLineTest
 * @description TODO
 * @date 2021/5/8 9:44
 */
public class TextFileReadTest {
    public static void main(String[] args) {
        String fileName = "F:/io/numberData.txt";
        try{
            File myFile = new File(fileName);
            BufferedReader in = new BufferedReader(new FileReader(myFile)); //创建文本输入对象
            String line = "";    //初始化
            int ch = in.read();  //读入一个字符

            while(ch != -1){            //如果没有读到文件结尾
                line += (char) ch;      //产生一行字符串
                if(ch == '\n'){         //如果是下一行
                    System.out.println(line);
                    line = "";
                }else if(ch =='\t'){    //如果读入的是制表符
                    in.skip(11);     //跳过11个字符长度,一部分数据将不会被读取
                }
                ch = in.read();
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
