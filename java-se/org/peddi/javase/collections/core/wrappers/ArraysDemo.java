package org.peddi.javase.collections.core.wrappers;
import java.util.Arrays;
import java.util.List;

import static  java.lang.System.out;
public class ArraysDemo {

    String[] array = new String[20];

    public ArraysDemo(){
        String fruits = "Apple,Banana,Orange,Pine Apple,Grapes,Pappaya,Mango,Kiwi";
        int i=0;
        for(String s: fruits.split(",")){
            array[i++] = s;
        }
    }

    public void arrayAsListDemo(){
        out.println("*****ArrayAsListDemo");

        List list = Arrays.asList(array);
        out.printf("%n List from Array: %n%s%n", list);
        array[8] = "Moosambi";
        out.printf("%n List after changing array: %n%s%n", list);
        out.printf("%nList Size = array size : %d%n", list.size());
        try {
            list.add("WaterMellon");
        } catch (UnsupportedOperationException e) {
            System.err.println("List created from Arrays.asList() is unmodifiable");
            e.printStackTrace();
        }

    }


    public static void main(String[] args){
        ArraysDemo app = new ArraysDemo();
        app.arrayAsListDemo();
    }
}
