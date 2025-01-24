package System;

import Uno.Card;
import Uno.WildCard;
import Uno.SkipCard;
import Uno.ReverseCard;
import Uno.DrawTwoCard;


public class Bot extends Player {
    public Bot(String name) {
        super(name);  
    }

    @Override
    public Card chooseCard(Card topCard) {
        if (!canPlay(topCard)) {
            return null;
        }


        for (Card card : getHand()) {
            if ((card instanceof WildCard || card instanceof SkipCard || card instanceof ReverseCard || card instanceof DrawTwoCard) &&
                    card.canPlayOn(topCard)) {
                return card;
            }
        }

       
        for (Card card : getHand()) {
            if (card.canPlayOn(topCard)) {
                return card;
            }
        }
        return null;
    }
}

		