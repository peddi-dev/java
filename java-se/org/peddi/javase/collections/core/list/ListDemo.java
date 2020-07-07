package org.peddi.javase.collections.core.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import static java.lang.System.out;
public class ListDemo {
    List<String> list ;

    public ListDemo(){
        list = new ArrayList<>(
                List.of("Apple", "Banana", "Orange", "Pine Apple", "Grape")
        );
    }


    public <E> void swap(List<E> list, int i, int j){
        E tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
    public  void shuffle(List<?> list, Random rand){
        for ( int i=list.size(); i > 1; i--) {
            swap(list, i - 1, rand.nextInt(i));
        }
    }

    public void shuffleDemo(){
        out.println("Data Shuffle");
        List<String> data = new ArrayList<>(list);
        out.printf("%nData: %s", data);
        shuffle(data, new Random());
        out.printf("%nShuffled Data: %s", data);
    }

    public void listIteratorDemo(){
        out.println("listIteratorDemo");
        ListIterator<String> li = list.listIterator(list.size());
        while(li.hasPrevious()){
            out.printf("%s ", li.previous());
        }

    }



    public static void main(String[] args){
        ListDemo app = new ListDemo();
       // app.shuffleDemo();
        app.listIteratorDemo();
    }
}
