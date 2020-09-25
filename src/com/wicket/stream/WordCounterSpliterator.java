package com.wicket.stream;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname WordCounterSpliterator
 * @description TODO
 * @date 2020/9/21 11:56
 */
public class WordCounterSpliterator implements Spliterator<Character> {

    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String string){
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if(currentSize < 10){  //返回null表示要解析的string已经足够小，可以顺序处理
            return null;
        }
        for(int splitPos = currentSize/2 + currentChar;splitPos < string.length(); splitPos++){
            if(Character.isWhitespace(string.charAt(splitPos))){
                Spliterator<Character> spliterator =new WordCounterSpliterator(string.substring(currentChar,splitPos));
                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
