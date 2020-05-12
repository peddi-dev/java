package peddi.java8.questions;

import java.util.HashMap;
import java.util.Map;

public class FindCharWithMaxOccurences {

   public String charWithMaxOccurences( String input){

       Map<Character, Integer> frequency = new HashMap<>();

       char maxChar = ' ';
       int maxCount = 0;

       char[] ca = input.toCharArray();
       Integer count = 0;
       for(int i = 0 ; i < ca.length; i++){
           count = frequency.get(ca[i]);
           if ( count == null){
               count = 1;
               frequency.put(ca[i], count);

           }else{
               frequency.put(ca[i], ++count);
           }

           if ( maxCount < count){
               maxChar = ca[i];
               maxCount = count;
           }

       }

       return maxChar + " " + maxCount;
   }

   public static void main ( String[] args){
       String input = "abacada";
       FindCharWithMaxOccurences app = new FindCharWithMaxOccurences();
       String output = app.charWithMaxOccurences(input);
       System.out.println(output);
   }

}
