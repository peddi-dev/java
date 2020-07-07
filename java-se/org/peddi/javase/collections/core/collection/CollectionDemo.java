package org.peddi.javase.collections.core.collection;

import org.peddi.javase.collections.streams.Person;
import org.peddi.javase.collections.streams.PersonList;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class CollectionDemo {

    private Collection<String> strColl;

    public void toArray() {

        out.println("***toArray()");
        //Immutable Collection
        strColl = List.of("data1", "data2", "data3");
        out.printf("return type List.of(): %s", strColl.getClass());
        // String[] strArray =  strColl.toArray(String[]::new);
        // previous commented line of code and following line of code are same
        String[] strArray = strColl.toArray(this::apply);
        out.println(Arrays.toString(strArray));

    }

    // implementation of functional interface IntFunction(T[] generator)
    private String[] apply(int n) {
        out.printf("%ndefault value of param n: %d%n", n);
        return new String[n];
    }

    public void removeAllNullValues() {
        out.println("\n***removeAllNullValues()");
        Collection col = new ArrayList(Arrays.asList("spades", "hearts", null, "diamonds", "clubs", null));
        out.println(col.getClass());
        out.printf("Size: %d, Elements:%s%n", col.size(), col);

        col.removeAll(Collections.singletonList(null));
        out.println("After null elements removed");
        out.printf("Size: %d, Elements:%s%n", col.size(), col);
    }

    public void colletionToString() {

        Collection<Person> persons = new PersonList().getMembers();

        List strPer = persons.stream()
                .map(Person::toString)
                .collect(Collectors.toList());

        out.println(strPer);
        Set<String> set = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(TreeSet::new));
    }


    public static void main(String[] args) {
        CollectionDemo app = new CollectionDemo();
        app.toArray();
        app.removeAllNullValues();
        app.colletionToString();
    }
}
