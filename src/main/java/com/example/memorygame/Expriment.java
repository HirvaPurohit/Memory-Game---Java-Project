package com.example.memorygame;

public class Expriment {
     public static void main(String[] args) {
        Card kingOfspades = new Card("Spades","King");
        Card kingOfHearts = new Card("Hearts","ace");
        System.out.println(kingOfspades);

//        Know the difference between equals and == method
//        == >> Compare objects are same or not
//        .equals() >> compare content of the variable that is same or not

//        String suit = new String("hearts");
//        String otherSuit = new String("hearts");
//        System.out.println(suit == otherSuit);
//        System.out.println(suit.equals(otherSuit));

        System.out.printf("%s value %d %n",kingOfspades,kingOfspades.getValue());
        System.out.printf("%s value %d %n",kingOfHearts,kingOfHearts.getValue());

        DeckOfCards deck = new DeckOfCards();
        System.out.println(deck);
        deck.shuffle();

        System.out.println(deck);

        System.out.println("~~~~~~   ~~~~~");

        for (int i=0; i<5; i++){
            System.out.println(deck.dealTopCard());
        }

         System.out.println("~~~~~~   ~~~~~");
         System.out.println(deck.getNumberofCards());

    }
}
