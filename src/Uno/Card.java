package Uno;
import System.Rules ;

public abstract class Card {
	
	public enum CardColor {
	    RED, BLUE, GREEN, YELLOW;
	}
	private boolean isPlayed;
	
    public Card() {
        this.isPlayed = false;
    }

  
    public abstract boolean canPlayOn(Card topCard);
    
  
    public abstract String toString();

    public boolean isPlayed() {
        return isPlayed;
    }

    public void setPlayed(boolean played) {
        isPlayed = played;
    }
    
    public abstract void applyEffect(Rules rules);

}