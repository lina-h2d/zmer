package Uno;

public abstract class ColoredCard extends Card {
	

    private final CardColor color;

    public ColoredCard(CardColor color) {
        super();
        this.color = color;
    }
     

    public CardColor getColor() {
        return color;
    }

    @Override
    public boolean canPlayOn(Card topCard) {
        if (!(topCard instanceof ColoredCard)) {
            return true;
        }
        ColoredCard other = (ColoredCard) topCard;
        return this.color == other.getColor();
    }
}