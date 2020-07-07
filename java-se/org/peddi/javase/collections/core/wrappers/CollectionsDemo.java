package org.peddi.javase.collections.core.wrappers;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

public class CollectionsDemo {

    public void nCopiesDemo(){
        out.println("nCopiesDemo");

        List list = Collections.nCopies(10, null);
        out.printf("%n Collections.nCopies(10, null) - 10 elements list with null values: %n%s%n", list);


    }
    public static void main(String[] args){
        CollectionsDemo app = new CollectionsDemo();
        app.nCopiesDemo();

    }
}
