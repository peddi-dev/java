package org.peddi.javase.collections.core.set;

import java.util.*;
import java.util.stream.Collectors;

import static  java.lang.System.out;
public class SetDemo {
    private Set<String> s1;
    private Set<String> s2;

    public SetDemo(){

        s1 = new TreeSet<>(
                Set.of("Apple", "Banana", "Orange", "Pine Apple", "Grape" )
        );

        s2 = new TreeSet<>(
                Set.of("WaterMellon", "Pappaya", "Mango", "Pine Apple", "Grape" )
        );
    }

    /**
     * remove duplicates from a list
     */
    public void removeDuplicates(){
        out.println("***removeDuplicates()");

        Collection<String> col = List.of("spades", "spades","hearts", "hearts", "diamonds", "clubs");
        out.printf("%nElements with Duplicates: %n%s", col);

        Set set =  col.stream().collect(Collectors.toSet());
        out.printf("%n%nElements after removing duplicates: %n%s", set);

    }

    public void setOperationsDemo(){

        out.println("\n*****setOperationsDemo");
        out.printf("%nSet1:%n%s", s1);
        out.printf("%nSet2:%n%s", s2);

        // Union s1 or s2
        Set<String> union = new TreeSet<>(s1);
        union.addAll(s2);
        out.printf("%n%nUnion:%n%s", union);

        // Intersection s1 and s2
        Set<String> intersection = new TreeSet<>(s1);
        intersection.retainAll(s2);
        out.printf("%n%nIntersection:%n%s", intersection);

        // difference s1 - s2
        Set<String> difference = new TreeSet<>(s1);
        difference.removeAll(s2);
        out.printf("%n%nDifference(s1-s2):%n%s", difference);

        // symmetric difference: elements in either s1 or s2 but not in both
        // symmetric difference = union - intersection
        Set<String> symmetricDiff = new LinkedHashSet<>(union);
        symmetricDiff.removeAll(intersection);
        out.printf("%n%nSymmetric Difference:%n%s", symmetricDiff);

    }



    public static void main(String[] args){
        SetDemo app = new SetDemo();
       // app.removeDuplicates();
        app.setOperationsDemo();
    }
}
