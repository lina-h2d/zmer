package System;

import java.util.List;
import Uno.Deck;
import Uno.GamePile;
import Uno.Card;

public class Table {
    private Deck deck;
    private GamePile gamePile;

    public Table(Deck deck, GamePile gamePile) {
        this.deck = deck;
        this.gamePile = gamePile;
    }

    public void prepareTable() {
        List<Card> gamePileCards = gamePile.takeCardsForNewDeck();
        deck.addCards(gamePileCards);
        deck.shuffle();
        gamePile.initialize(deck.drawCard());
    }

    public Card getLastPlayedCard() {
        return gamePile.getTopCard();
    }

    public boolean playCard(Player player, Card card) {
        if (card.canPlayOn(gamePile.getTopCard())) {
            gamePile.addCard(card);
            player.removeCard(card);
            return true;
        }
        return false;
    }

    public Card drawCard() {
        if (deck.isEmpty()) {
            List<Card> gamePileCards = gamePile.takeCardsForNewDeck();
            if (gamePileCards.isEmpty()) {
                throw new IllegalStateException("No cards left to draw.");
            }
            deck.addCards(gamePileCards);
            deck.shuffle();
        }
        return deck.drawCard();
    }

    public int getDeckSize() {
        return deck.size();
    }

    public void displayTableState() {
        Card topCard = gamePile.getTopCard();
        if (topCard == null) {
            System.out.println("No cards have been played yet.");
        } else {
            System.out.println("-------------Top Card: " + topCard +"-------------");
            System.out.println("\n");
        }
        System.out.println("Cards Left in Deck: " + deck.size());
    }
}

