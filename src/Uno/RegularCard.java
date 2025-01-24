package Uno;

import System.Rules;

public class RegularCard extends ColoredCard {
    private final int number;

    public RegularCard(CardColor color, int number) {
        super(color);
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException("Number must be between 0 and 9");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean canPlayOn(Card topCard) {
        if (topCard instanceof RegularCard) {
            RegularCard other = (RegularCard) topCard;
            return super.canPlayOn(topCard) || this.number == other.getNumber();
        }
        return super.canPlayOn(topCard);
    }

    @Override
    public String toString() {
        return getColor().toString() + " " + number;
    }
    
    
    @Override
    public void applyEffect(Rules rules) {
        rules.reverseGame();
    } 
}
