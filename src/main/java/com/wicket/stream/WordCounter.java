package com.wicket.stream;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @param
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname WordCounter
 * @description TODO
 * @date 2020/9/21 11:38
 */
public class WordCounter {
    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter,boolean lastSpace){
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public WordCounter accumulate(Character c){
        if(Character.isWhitespace(c)){
            return lastSpace ? this : new WordCounter(counter,true);
        }else{
            return  lastSpace ? new WordCounter(counter+1,false) : this;
        }
    }

    public WordCounter combine(WordCounter wordCounter){
        return  new WordCounter(counter + wordCounter.counter , wordCounter.lastSpace);
    }

    public int getCounter(){
        return  counter;
    }

    private static int countWords(Stream<Character> stream){
        WordCounter wordCounter = stream.reduce(new WordCounter(0,true),WordCounter::accumulate,WordCounter::combine);
        return wordCounter.getCounter();
    }

    public static void main(String[] args) {

        final String SENTENCE = "Nel    mezzo del cammin  di nostra  vita  mi  ritrovai in una  selva  osura   che la  daritta via era    smaarrita ";
//        Stream<Character> stream = IntStream.range(0,SENTENCE.length())
//                .mapToObj(SENTENCE::charAt);
////        System.out.println("Found " + WordCounter.countWords(stream) + " words");
//        System.out.println("Found " + WordCounter.countWords(stream.parallel()) + " words");

        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream1 = StreamSupport.stream(spliterator,true);
        System.out.println("Found " + WordCounter.countWords(stream1.parallel()) + " words");

    }
}
