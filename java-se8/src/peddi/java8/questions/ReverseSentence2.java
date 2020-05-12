package peddi.java8.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseSentence2 {


    public String reverseSentence(String input){

        StringBuilder output = new StringBuilder();

        List<StringBuilder> wl = new ArrayList<>();

        char[] ca = input.toCharArray();

        int size = ca.length;

        StringBuilder word = new StringBuilder();

        for( int i = 0; i < size; i++){

            if( ca[i] == ' '){
                wl.add(word);
                word  = new StringBuilder();
            }

            word.append(ca[i]);
        }
        wl.add(word);

        output.append(wl.get(wl.size()-1));
        for(int j=wl.size()-2; j>=0; j--){
            output.append(wl.get(j)).append(' ');
        }

        return output.toString();
    }

    public static void main(String[] args){
        System.out.println(ReverseSentence2.class);
        String input = "Welcome to Marlabs Bangalore";

        ReverseSentence app = new ReverseSentence();
        String output = app.reverseSentence(input);
        System.out.println(input);
        System.out.println(output);


    }


}
