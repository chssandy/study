package com.wicket.stream.optional;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname Insurance
 * @description TODO
 * @date 2020/9/24 14:25
 */
public class Insurance {
    private String name;     //保险公司必须有名称，所以不需要 Optional
    public String getName(){
        return name;
    }
}
