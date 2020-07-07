package org.peddi.javase.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomDemo {

    public void randomDemo(){
        Random random = new Random();
        int bound = 100;
        Map<Integer, Integer> randomNumFrequency = new HashMap<>();

        for(Integer i=0; i<20; i++){
           Integer count = randomNumFrequency.get(i);
           randomNumFrequency.put(i, (count == null) ? 1 :  (count + 1));
        }
        System.out.println(randomNumFrequency);

    }

    public static void main(String[] args){
        RandomDemo app = new RandomDemo();
        app.randomDemo();
    }
}
