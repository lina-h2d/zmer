package Uno;
import System.Rules ;

public class SkipCard extends ColoredCard {
    public SkipCard(CardColor color) {
        super(color);
    }

    @Override
    public String toString() {
        return getColor().toString() + " SKIP";
    }
    
    @Override
    public void applyEffect(Rules rules) {
        rules.getPlayerManager().rotateToNextPlayer(); 
    }
}
