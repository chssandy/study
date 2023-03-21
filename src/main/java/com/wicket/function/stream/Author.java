package com.wicket.function.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Author
 * @description TODO
 * @date 2023/3/20 21:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode  //用于后期的去重使用
public class Author implements Comparable<Author>{

    private Long id;
    private String name;
    private Integer age;
    private String intro;
    private List<Book> books;


    @Override
    public int compareTo(Author o) {
        return o.age-this.age;
    }
}
