package com.wicket.stream.process;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname HeaderTextProcessing
 * @description TODO
 * @date 2020/9/23 15:58
 */
public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return "From Raoul ,Mario and Alan:" + input;
    }
}
