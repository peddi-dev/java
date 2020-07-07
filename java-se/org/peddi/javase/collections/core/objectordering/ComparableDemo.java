package org.peddi.javase.collections.core.objectordering;

import java.util.*;

import static java.lang.System.out;

public class ComparableDemo {


    private List<Name> names ;
    Name[] na = new Name[] {
            new Name("John", "Smith"),
            new Name("Karl", "Ng"),
            new Name("Jeff", "Smith"),
            new Name("Tom", "Rich")
    };

    public ComparableDemo(){
      //  out.println(Arrays.toString(na));
        names = new ArrayList<>(Arrays.asList(na));
    }
    public List<Name> getNames() {
        return names;
    }
    public void sortNames(){
        out.println("******sortNames()");
        out.printf("%nNames:`%n%s%n", getNames());
        List<Name> sortedNames = new ArrayList<>(getNames());
        Collections.sort(sortedNames);
        out.printf("%nSorted Names:`%n%s%n", sortedNames);
    }



    public static void main(String[] args){
        ComparableDemo app = new ComparableDemo();
        app.sortNames();


    }
}
