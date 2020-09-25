package com.wicket.stream.process;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname SpellCheckerProcessing
 * @description TODO
 * @date 2020/9/23 16:01
 */
public class SpellCheckerProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return input.replaceAll("labda","lambda");
    }
}
