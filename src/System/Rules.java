package System;
import java.util.Scanner;
import Uno.Card ; 

public class Rules {
    private Table table;
    private PlayerManager playerManager;
    private String lastSavedColor;

    public Rules(Table table, PlayerManager playerManager) {
        this.table = table;
        this.playerManager = playerManager;
    }
    
    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public void saveColor(String color) {
        if (color.equals("Red") || color.equals("Blue") || color.equals("Green") || color.equals("Yellow")) {
            lastSavedColor = color;
        }
    }

    public String getLastSavedColor() {
        return lastSavedColor;
    }

    public void setLastSavedColor(String color) {
        this.lastSavedColor = color;
    }

    public void drawTwoCards() {
        Player nextPlayer = playerManager.getNextPlayer();
        nextPlayer.addCard(table.drawCard());
        nextPlayer.addCard(table.drawCard());
        playerManager.rotateToNextPlayer();
    }

    public void reverseGame() {
        playerManager.reverseDirection();
    }

    public void applyWildCard(String color) {
        saveColor(color);
        playerManager.rotateToNextPlayer();
    }

    private Scanner scanner = new Scanner(System.in);

    public String chooseNewColor() {
        String[] validColors = {"Red", "Blue", "Green", "Yellow"};
        System.out.println("Choose a new color: (Red, Blue, Green, Yellow)");
        while (true) {
            String choice = scanner.nextLine().trim();
            for (String color : validColors) {
                if (color.equalsIgnoreCase(choice)) {
                    return color;
                }
            }
            System.out.println("Invalid choice. Please choose one of: Red, Blue, Green, Yellow.");
        }
    }

    public boolean isValidPlay(Card card, Card topCard) {
        return card.canPlayOn(topCard);
    }
}


