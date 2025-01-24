package Uno;
import System.Rules ;

public class WildCard extends Card {
    private CardColor declaredColor;

    public WildCard() {
        super();
        this.declaredColor = null;
    }

    public void setDeclaredColor(CardColor color) {
        this.declaredColor = color;
    }

    public CardColor getDeclaredColor() {
        return declaredColor;
    }

    @Override
    public boolean canPlayOn(Card topCard) {
        return true;
    }

    @Override
    public String toString() {
        return declaredColor == null ? "WILD" : "WILD (" + declaredColor + ")";
    }
    
    
    
    public void applyEffect(Rules rules) {
        String newColor = rules.chooseNewColor();
        CardColor color = CardColor.valueOf(newColor.toUpperCase()); 
        setDeclaredColor(color); 
        rules.setLastSavedColor(newColor); 
        System.out.println("The color has been changed to: " + newColor);
    }
    
    
} 
