package Uno;
import System.Rules ;

public class ReverseCard extends ColoredCard {
    public ReverseCard(CardColor color) {
        super(color);
    }

    @Override
    public String toString() {
        return getColor().toString() + " REVERSE";
    }
    
    @Override
    public void applyEffect(Rules rules) {
        rules.reverseGame();
    }
}
