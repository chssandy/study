package com.wicket.function.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Book
 * @description TODO
 * @date 2023/3/20 21:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode //用于后期的去重使用
public class Book {
    private Long id;
    private String name;   //书名
    private String category; //分类
    private Integer score;  //评分
    private String intro; //描述
}

