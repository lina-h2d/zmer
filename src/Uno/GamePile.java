package Uno;

import java.util.ArrayList; 


public class GamePile {
    private ArrayList<Card> pile;

    public GamePile() {
        pile = new ArrayList<>();
    }

    
    public void initialize(Card card) {
        pile.add(card);
    }

    public void addCard(Card card) {
        pile.add(card);
    }

    
    public Card getTopCard() {
        return pile.isEmpty() ? null : pile.get(pile.size() - 1);
    }

    
    public ArrayList<Card> takeCardsForNewDeck() {
        ArrayList<Card> newDeckCards = new ArrayList<>();

        if (!pile.isEmpty()) {
            for (int i = 0; i < pile.size() - 1; i++) {
                newDeckCards.add(pile.get(i));
            }
            Card lastCard = getTopCard();
            pile.clear();
            pile.add(lastCard);
        }
        return newDeckCards;
    }
}
