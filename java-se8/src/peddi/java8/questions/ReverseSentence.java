
package  peddi.java8.questions;

import java.util.*;

public class ReverseSentence {



    public String reverseSentence(String input){

        StringBuilder output = new StringBuilder();

        List<StringBuilder> wl = new ArrayList<>();

        char[] ca = input.toCharArray();

        int size = ca.length;

        StringBuilder word = new StringBuilder();

        for( int i = size -1; i >= 0; i--){

            if( ca[i] == ' '){
                //wl.add(reverseWord(word));
                output.append(reverseWord(word)).append(' ');
                word  = new StringBuilder();
            }

            word.append(ca[i]);
        }
        //wl.add(reverseWord(word));
        output.append(reverseWord(word));


//        for(int j=0; j<wl.size()-1; j++){
//            output.append(wl.get(j)).append(' ');
//        }
//
//        output.append(wl.get(wl.size()-1));

        return output.toString();
    }

    public StringBuilder reverseWord(StringBuilder word){
        StringBuilder output = new StringBuilder();
        for(int j = word.length() - 1; j >= 0; j--){
            output.append(word.charAt(j));
        }

        return  output;
    }

    public static void main(String[] args){
        System.out.println(ReverseSentence.class);
        String input = "Welcome to Marlabs Bangalore";

        ReverseSentence app = new ReverseSentence();
        String output = app.reverseSentence(input);
        System.out.println(input);
        System.out.println(output);
        Scanner in = new Scanner(System.in);

//        Set<String> s1 = new HashSet<>(){{ add("one");add("two");}};
//        List<String> l1 = new ArrayList<>(s1);
//        System.out.println(l1);



    }


}
