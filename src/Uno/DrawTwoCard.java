package Uno;
import System.Rules;

public class DrawTwoCard extends ColoredCard {
    public DrawTwoCard(CardColor color) {
        super(color);
    }

    @Override
    public String toString() {
        return getColor().toString() + " +2";
    }
    
    @Override
    public void applyEffect(Rules rules) {
        rules.drawTwoCards();
    }
}