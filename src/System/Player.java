package System;

import Uno.Card;
import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private String name;
    private List<Card> hand; 

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>(); 
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getCardCount() {
        return hand.size();
    }

    public String getName() {
        return name;
    }

    public abstract Card chooseCard(Card topCard);

    public boolean canPlay(Card topCard) {
        for (Card card : hand) {
            if (card.canPlayOn(topCard)) {
                return true;
            }
        }
        return false;
    }

    public void addCard(Card card) {
        if (card != null) {
            hand.add(card); 
        }
    }

    public void removeCard(Card card) {
        hand.remove(card); 
    }

    public void displayHand() {
        System.out.println(name + "'s Hand:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println((i + 1) + ": " + hand.get(i).toString());
        }
    }
}


