package org.peddi.java.se11.lambdas;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataSearchLambdaDemo {

    public DataSearchLambdaDemo(){

        this.members.add(new Person("AUser1", LocalDate.of(1970, Month.APRIL, 10), Person.SEX.MALE, "user1@abc.com"));
        this.members.add(new Person("BUser2", LocalDate.of(1960, Month.JANUARY, 5), Person.SEX.MALE, "user2@abc.com"));
        this.members.add(new Person("CUser3", LocalDate.of(1980, Month.MAY, 10), Person.SEX.FEMALE, "user3@abc.com"));
        this.members.add(new Person("ZUser4", LocalDate.of(1975, Month.JUNE, 10), Person.SEX.MALE, "user4@abc.com"));
        this.members.add(new Person("XUser5", LocalDate.of(1990, Month.SEPTEMBER, 10), Person.SEX.FEMALE, "user5@abc.com"));
        this.members.add(new Person("YUser6", LocalDate.of(1990, Month.AUGUST, 10), Person.SEX.MALE, "user6@abc.com"));

    }

    public DataSearchLambdaDemo(List<Person> members) {

        this();

        if ( members != null) {
            this.members.addAll( members );
        }
  }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }



    public interface SearchCriteria {
        Boolean test(Person person);
    }

    public class Filter implements SearchCriteria {
        @Override
        public Boolean test(Person person) {
            Integer age = person.getAge();
            return person.gender == Person.SEX.MALE
                    && age >= 18
                    && age < 60;
        }
    }

    /**
     * Searching persons based on the Boolean test(Person person) method in the SearchCriteria interface
     * SearchCriteria has three implementations
     *  1) Local class
     *  2) Anonymous class
     *  3) Lambda Expression
     *
     * @param persons
     * @param filter
     *
     * @return
     */

    public  List<Person> processPersons(List<Person> persons, SearchCriteria filter){

        List<Person> result = new ArrayList<Person>();

        for(Person p: persons){

            if(filter.test(p)){
                result.add(p);
            }
        }

        return result;
    }

    /**
     * search persons with java.util.function.Predicate interface
     * @param persons
     * @param filter
     * @return
     */

    public <T>  List<T> processPersonsWithPredicate(List<T> persons, Predicate<T> filter){

        List<T> result = new ArrayList<T>();

        for(T p: persons){

            if(filter.test(p)){
                result.add(p);
            }
        }

        return result;
    }


    /**
     * search persons with java.util.function.Predicate, Function, Consumer interfaces
     * @param persons
     * @param tester
     * @return
     */

    public <T, R>  void processPersons(
            Iterable<T> persons,
            Predicate<T> tester,
            Function<T, R> mapper,
            Consumer<R> block){

        System.out.println("%%%%% searchPersonsWithPredicateFunctionConsumer");

        for(T p: persons) {

            if (tester.test(p)) {
                R data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public void processPersonsUsingAggregateOperationsWithLambdaExpressions(){

        System.out.print("*** processPersonsUsingAggregateOperationsWithLambdaExpressions ");

        List<String> result = this.getMembers()
                .stream()
                .filter(p -> p.getGender() == Person.SEX.MALE
                        && p.getAge() >= 18
                        && p.getAge() < 60)
                .map(p -> p.getEmailAdress())
                .collect(Collectors.toList());

        System.out.println(result);

    }


    /****************************************************************************
     *
     *  Getting filtered data using above processPersons APIs
     *
     *****************************************************************************/

    void searchPersonsWithLocalFilter() {

        System.out.println("***** DataSearchLambdaDemoTest");
        System.out.println("%%%%%%%%%%% Initial Data");
        System.out.println(this.getMembers());
        java.util.List<Person> result = this.processPersons(this.getMembers(),
                // Local Filter
                new Filter());
        System.out.println("%%%%%%%%%%%%% Filtered Data with local filter");
        System.out.println(result);
        ;
    }



    // @Test
    void searchPersonsWithAnonymousFilter() {

        System.out.println("***** DataSearchLambdaDemoTest");
        System.out.println("%%%%%%%%%%% Initial Data ");
        System.out.println(this.getMembers());
        java.util.List<Person> result = this.processPersons(this.getMembers(),
                // Anonymous Filter
                new DataSearchLambdaDemo.SearchCriteria(){
                    @Override
                    public Boolean test(Person person) {
                        Integer age = person.getAge();
                        return person.gender == Person.SEX.MALE
                                && age >= 18
                                && age < 60;
                    }

                });
        System.out.println("%%%%%%%%%%%%% Filtered Data with anonymous filter");
        System.out.println(result);

    }



    void searchPersonsWithLambdaExpressionFilter() {

        System.out.println("***** DataSearchLambdaDemoTest");
        System.out.println("%%%%%%%%%%% Initial Data");
        System.out.println(this.getMembers());
        java.util.List<Person> result = this.processPersons(this.getMembers(),
                // Lambda expression filter
                (Person  p) -> p.getGender() == Person.SEX.MALE
                        && p.getAge() >= 18
                        && p.getAge() < 60
        );
        System.out.println("%%%%%%%%%%%%% Filtered Data with Lambda expression filter");
        System.out.println(result);

    }



    void searchPersonsWithPredicate() {

        System.out.println("***** DataSearchLambdaDemoTest.searchPersonsWithPredicate()");
        System.out.println("%%%%%%%%%%% Initial Data");
        System.out.println(this.getMembers());
        java.util.List<Person> result = this.processPersonsWithPredicate(this.getMembers(),
                // Lambda expression filter
                (Person  p) -> p.getGender() == Person.SEX.MALE
                        && p.getAge() >= 18
                        && p.getAge() < 60
        );
        System.out.println("%%%%%%%%%%%%% Filtered Data with Predicate and Lambda expression filter");
        System.out.println(result);

    }


    void searchPersonsWithPredicateFunctionConsumer(){
        System.out.println("***** DataSearchLambdaDemoTest.searchPersonsWithPredicateFunctionConsumer()");

        this.processPersons(
                this.getMembers()
                ,p -> p.getGender() == Person.SEX.MALE
                        && p.getAge() >= 18
                        && p.getAge() < 60
                , p -> p.getEmailAdress()
                ,  email -> System.out.print( "\n" + email)
        );
    }



    /***
     *  Data members
     */

    private List<Person> members = new ArrayList<Person>();

}
