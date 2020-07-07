package org.peddi.javase.collections.core.list;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;

public class PlayingCardsDealDemo {

    int numberOfHands;
    int numberOfCardsPerHand;

    String[] suites = new String[] {
             "spades", "diamonds", "hearts", "clubs"
             };
    String[] ranks = new String[] {
            "ace", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "jack", "queen", "king"
        };

    List<String> deck;

    public PlayingCardsDealDemo(int numberOfHands, int numberOfCardsPerHand){
        this.numberOfHands = numberOfHands;
        this.numberOfCardsPerHand = numberOfCardsPerHand;
        deck();
    }

    public List<String> deck() {

        if (deck != null){
            return deck;
        }
        deck = new ArrayList<>();
        int i = 0;
        for(String suite: suites){

            for(String rank: ranks){
               deck.add(rank + " - " + suite) ;
            }
        }

        return deck;
    }

    public List<String> getDealHand(){
        List<String> dealHandView =  deck.subList(deck.size() - numberOfCardsPerHand, deck.size());
        List<String> dealHand = new ArrayList<>(dealHandView);
        dealHandView.clear();
        return dealHand;
    }
    public void dealHandDemo(){
        out.println("Playing Cards Deal Hand Demo");
        if ( numberOfHands * numberOfCardsPerHand > deck.size()){
            out.println("Not enough cardsS");
        }

        //shuffle
        Collections.shuffle(deck(), new Random());

        for( int i = 1; i <= numberOfHands; i++){
            List<String> dealHand = getDealHand();
            out.printf("%nDeal Hand %d %n%s", i, dealHand);
        }

    }



    public static void main(String[] args){
        PlayingCardsDealDemo app = new PlayingCardsDealDemo(5, 9);
        app.dealHandDemo();
    }
}
