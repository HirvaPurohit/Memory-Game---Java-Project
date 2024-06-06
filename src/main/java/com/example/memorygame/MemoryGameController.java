package com.example.memorygame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class MemoryGameController implements Initializable {

    @FXML
    private FlowPane imagesFlowPane;

    @FXML
    private ImageView imageView;

    @FXML
    private Label guesslabel;

    @FXML
    private Label correctGuesslabel;
    private MemoryCard firstCard,secondCard;

    private ArrayList<MemoryCard> cardsInGame;

    private int numOfGuess = 0;
    private int numOfMatches = 0;

    @FXML
    void playAgain() {
        numOfGuess = 0;
        numOfMatches = 0;

        firstCard = null;
        secondCard = null;

        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        cardsInGame = new ArrayList<>();

        for(int i=0; i<imagesFlowPane.getChildren().size()/2; i++){
            Card cardDelt = deck.dealTopCard();
            cardsInGame.add(new MemoryCard(cardDelt.getSuit(),cardDelt.getFaceName()));
            cardsInGame.add(new MemoryCard(cardDelt.getSuit(),cardDelt.getFaceName()));
        }

        Collections.shuffle(cardsInGame);
        flipAllCards();

    }

    /**
     * THis will add a number to each ImageView and set the image to be the back of a Card
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Card card = new Card("Hearts","Queen");
//        DeckOfCards deck = new DeckOfCards();
//        deck.shuffle();

        playAgain();


        for(int i=0; i<imagesFlowPane.getChildren().size(); i++){

            // cast the Node to be type of ImageView
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            imageView.setImage(new Image(Card.class.getResourceAsStream("images/back_of_card.png")));
            imageView.setUserData(i);

            // register a click listner
            imageView.setOnMouseClicked(mouseEvent -> {
                flipCard((Integer) imageView.getUserData());



            });
        }

    }

    private void flipCard(int indexOfCard) {

        if(firstCard==null && secondCard==null)
                flipAllCards();
        ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(indexOfCard);

        if(firstCard == null){

            firstCard = cardsInGame.get(indexOfCard);
            imageView.setImage(firstCard.getImage());

        } else if (secondCard == null) {
            numOfGuess++;
            secondCard = cardsInGame.get(indexOfCard);
            imageView.setImage(secondCard.getImage());
            checkForMatch();
            updateLabels();

        }

    }

    private void updateLabels() {
        guesslabel.setText(Integer.toString(numOfGuess));
        correctGuesslabel.setText(Integer.toString(numOfMatches));

    }

    /**
     * This will show the back of all cards that are not matched
     */

    private void flipAllCards() {
        for(int i=0; i<cardsInGame.size(); i++){

            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            MemoryCard card = cardsInGame.get(i);

            if(card.isMatched()){
                imageView.setImage(card.getImage());
            }
            else{
                imageView.setImage(card.getBackOfCard());
            }
        }
    }

    private void checkForMatch() {


        if(firstCard.isSameCard(secondCard)){
            numOfMatches++;
            firstCard.setMatched(true);
            secondCard.setMatched(true);
        }
        firstCard = null;
        secondCard = null;

    }
}
