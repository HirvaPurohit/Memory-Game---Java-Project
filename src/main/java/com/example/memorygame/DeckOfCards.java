package com.example.memorygame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {

    private ArrayList<Card> deck;

    public DeckOfCards() {
        this.deck = new ArrayList<>();

        List<String> suits = Card.getValidSuits();
        List<String> faceNames = Card.getValidFaceNames();

        for(String suit : suits){
            for(String faceName : faceNames){

                deck.add(new Card(suit,faceName));
            }
        }
    }


    /**
     * This method will be shuffle the card objects
     */
    public void shuffle(){

        Collections.shuffle(deck);
    }

    /**
     * This method return the top card from the deck.
     * If deck is an empty , then it will return null.
     */

    public Card dealTopCard(){
        if(deck.size() > 0){

            return deck.remove(0);
        }
        else
            return null;
    }

    /**
     * This return the number of card left in the deck.
     */
    public int getNumberofCards(){

        return deck.size();

    }
}
