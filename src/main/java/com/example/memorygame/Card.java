package com.example.memorygame;

import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

public class Card {

    private String suit;

    private String faceName;

    public Card(String suit, String faceName) {
        suit = suit.toLowerCase();
        setSuit(suit);
        setFaceName(faceName);
    }

    public String getSuit() {
        return suit;
    }

//		valid suits are "hearts" , "diamonds","clubs","spades"

    public static List<String> getValidSuits(){
        return Arrays.asList("hearts","diamonds","clubs","spades");
    }

    public void setSuit(String suit) {
        if(getValidSuits().contains(suit)){
            this.suit = suit;
        }
        else{
            throw new IllegalArgumentException(suit + "is invalid , must be one of " +getValidSuits());
        }

    }

    public String getFaceName() {
        return faceName;
    }

    // Valid face name are "2" , "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"

    public static List<String> getValidFaceNames(){

        return  Arrays.asList("2" , "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace");
    }


    public void setFaceName(String faceName) {
        faceName = faceName.toLowerCase();
        if(getValidFaceNames().contains(faceName))
             this.faceName = faceName;
        else
            throw new IllegalArgumentException(faceName + " is invalid , must be one of "+getValidFaceNames());
    }

    public String toString(){
        return faceName + " of " + suit;
    }

    public String getColor(){
        if(suit.equals("hearts") || suit.equals("diamonds")){
            return "red";
        }
        else
            return "black";
    }

    /**
     * This method will return the value of card
     * [ "2" , "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace" ]
     *    0     1    2    3    4    5    6    7    8     9       10       11      12
     *    +2
     */

    public int getValue(){
        return getValidFaceNames().indexOf(faceName) + 2;
    }

    /**
     * This method will return an Image that Represents the Card
     */
    public Image getImage(){
        String pathName = "images/"+faceName+"_of_"+suit+".png";
        return new javafx.scene.image.Image(Card.class.getResourceAsStream(pathName));
    }

    public Image getBackOfCard(){
        return new javafx.scene.image.Image(Card.class.getResourceAsStream("images/back_of_card.png"));

    }
}
