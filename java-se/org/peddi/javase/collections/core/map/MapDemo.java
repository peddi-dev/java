package org.peddi.javase.collections.core.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.out;
public class MapDemo {
    String[] words = new String[] {"apple", "banana",
            "orange", "apple", "pappaya", "mango", "banana", "orange"};

    public void wordFrequencyDemo(){
        out.println("****wordFrequencyDemo");

        Map<String, Integer> hm = new HashMap<>();
        wordCount(hm);
        out.printf("%nHashMap:%n%s", hm);

        Map<String, Integer> tm = new TreeMap<>();
        wordCount(tm);
        out.printf("%nHashTree:%n%s", tm);

        Map<String, Integer> lhm = new LinkedHashMap<>();
        wordCount(lhm);
        out.printf("%nLinkedHashMap:%n%s", lhm);

    }

    private void wordCount(Map<String, Integer> m){
        for(String word: words){
            Integer v = m.get(word);
            m.put(word, (v ==  null)? 1 : v + 1);
        }
    }

    public static void main(String[] args){
        MapDemo app = new MapDemo();
        app.wordFrequencyDemo();
    }
}
