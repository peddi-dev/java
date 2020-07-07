package org.peddi.javase.collections.core.sortedset;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import static java.lang.System.out;

public class SortedSetDemo {


    public SortedSet<String> sortedSet;

    public SortedSetDemo(){
        sortedSet = new TreeSet<>(
                Set.of("Apple", "Banana", "Orange", "Pine Apple", "Grapes","Pappaya","Mango","Kiwi","Moosambi", "WaterMellon" )
        );
    }

    public void rangeOperationsDemo(){
        out.println("rangeOperationsDemo");
        out.printf("%nSortedSet:%n%s%n", sortedSet);

        // half-open range : excludes high endpoint
        SortedSet rangeView1 = sortedSet.subSet("Banana", "Orange");
        out.printf("%nhalf-open range:%n%s%n", rangeView1);

        // closed range : includes both low and high endpoints
        // high end point is included using null character "\0"
        SortedSet rangeView2 = sortedSet.subSet("Banana", "Orange"+"\0");
        out.printf("%nclosed-range:%n%s%n", rangeView2);

        // full-open range : excludes both low and high endpoints
        // low end point is excluded using null character "\0"
        SortedSet rangeView3 = sortedSet.subSet("Banana"+"\0", "Orange");
        out.printf("%nfull-open-range:%n%s%n", rangeView3);


        //Head and Tail sets , these two disjoint sets of backing set
        SortedSet headset = sortedSet.headSet("Moosambi");
        out.printf("%n%nHeadSet:%n%s%n", headset);

        SortedSet tailset = sortedSet.tailSet("Moosambi");
        out.printf("%nTailSet:%n%s%n", tailset);

    }

    public void endPointOperations(){

        out.println("endPointOperations");
        out.printf("%nSortedSet:%n%s%n", sortedSet);

        //first element
        out.printf("%nFirst Element: %s%n", sortedSet.first());

        //last element
        out.printf("%nLast Element: %s%n", sortedSet.last());

        //predecessor of "Mango"
        String elem = "Mango";
        out.printf("%nPredecessor of %s: %s%n", elem, sortedSet.headSet("Mango").last());

    }

    public void comparatorDemo(){
        out.println("\n*****setOperationsDemo");
        // Comparator provided to TreeSet constructor if any, otherwise null
        out.printf("%nComparator: %s", sortedSet.comparator());
    }


    public static void main(String[] args){
        SortedSetDemo app = new SortedSetDemo();
        //app.rangeOperationsDemo();
        app.endPointOperations();
        app.comparatorDemo();
    }
}
