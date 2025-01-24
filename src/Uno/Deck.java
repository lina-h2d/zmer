package Uno;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private final static Random sourceRandom = new Random();
    public final static int LENGTH = 108;
    private ArrayList<Card> cardList = new ArrayList<>();

    public Deck() {
        for (Card.CardColor color : Card.CardColor.values()) {
            for (int i = 0; i <= 9; i++) {
                cardList.add(new RegularCard(color, i));
                if (i != 0) {
                    cardList.add(new RegularCard(color, i));
                }
            }
        }

        for (Card.CardColor color : Card.CardColor.values()) {
            for (int i = 0; i < 2; i++) {
                cardList.add(new SkipCard(color));
                cardList.add(new ReverseCard(color));
                cardList.add(new DrawTwoCard(color));
            }
        }

        for (int i = 0; i < 4; i++) {
            cardList.add(new WildCard());
        }
    }

    public void shuffle() {
        Collections.shuffle(cardList, sourceRandom);
    }

    public Card get(final int i) {
        if (i >= 0 && i < cardList.size()) {
            return cardList.get(i);
        }
        throw new IndexOutOfBoundsException("Invalid card index: " + i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card c : cardList) {
            sb.append(c.toString()).append(" ");
        }
        return sb.toString();
    }

    public boolean addCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null.");
        }
        if (cardList.size() >= LENGTH) {
            throw new IllegalStateException("Deck is full.");
        }
        return cardList.add(card);
    }

    public void addCards(List<Card> cards) { // Changed to accept List<Card>
        if (cards == null) {
            throw new IllegalArgumentException("Card list cannot be null.");
        }
        if (cardList.size() + cards.size() > LENGTH) {
            throw new IllegalStateException("Deck does not have enough space.");
        }
        cardList.addAll(cards);
    }

    public Card getCard(int index) {
        if (index >= 0 && index < cardList.size()) {
            return cardList.remove(index);
        }
        throw new IndexOutOfBoundsException("Invalid card index: " + index);
    }

    public Card drawCard() {
        if (cardList.isEmpty()) {
            throw new IllegalStateException("Deck is empty.");
        }
        return cardList.remove(0);
    }

    public boolean isEmpty() {
        return cardList.isEmpty();
    }

    public int size() {
        return cardList.size();
    }
}

// business model 
//post collabted
//archi 
//finish poo
//start sfsd
//archi 
//tatweer post 
