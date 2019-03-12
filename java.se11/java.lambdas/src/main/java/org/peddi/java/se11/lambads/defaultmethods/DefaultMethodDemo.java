package org.peddi.java.se11.lambads.defaultmethods;

import org.peddi.java.se11.lambads.Person;


import java.util.Collections;
import static java.util.Comparator.comparing;
import java.util.List;

public class DefaultMethodDemo {

    /**
     * using the default method List.sort() in the List interface
     * using the method reference syntax for invoking the Comparator.comparing() default method
     */

    public void sortPersonsUsingListSortDefaultMethodAndMethodReference(List<Person> personList){

        personList.sort(comparing(Person::getName).reversed());
        System.out.println("******* Default List.sort() and Method reference for default method Comparator.comparing()");
        System.out.println(personList);
    }

    /**
     * java.util.Comparator.comparing() is the default method added to the Comparator interface
     * @param personList
     */

    public void sortPersonsUsingDefaultMethod(List<Person> personList){

        Collections.sort(personList, comparing(p -> p.getName()));

        System.out.println("******* Default List.sort() and Lamda expression for default method Comparator.comparing()");

        System.out.println(personList);
    }
}
