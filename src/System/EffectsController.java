package System;

import Uno.Card;
import Uno.SkipCard;
import Uno.ReverseCard;
import Uno.DrawTwoCard;
import Uno.WildCard;

public class EffectsController {
    private Rules rules;

    public EffectsController(Rules rules) {
        this.rules = rules;
    } 

    public void applyEffect(Card card) {
        if (card instanceof SkipCard) {
            rules.getPlayerManager().rotateToNextPlayer();
        } else if (card instanceof ReverseCard) {
            rules.reverseGame();
        } else if (card instanceof DrawTwoCard) {
            rules.drawTwoCards();
        } else if (card instanceof WildCard) {
            String newColor = rules.chooseNewColor();
            rules.setLastSavedColor(newColor);
        }
    }
}