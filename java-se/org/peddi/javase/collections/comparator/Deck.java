package org.peddi.javase.collections.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public interface Deck {
	
    List<Card> getCards();
   
    int size();
    void addCard(Card card);
    void addCards(List<Card> cards);
    void shuffle();
    void sort();
    void sort(Comparator<Card> c);
    String deckToString();
    
    Deck deckFactory();
    void addDeck(Deck deck);

    Map<Integer, Deck> deal(int players, int numberOfCards)
        throws IllegalArgumentException;

}
