package System;

import Uno.Card;
import java.util.Scanner;

public class SmartPlayer extends Player {
    private Scanner scanner;

    public SmartPlayer(String name) {
        super(name); 
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Card chooseCard(Card topCard) {
        System.out.println("Your turn! Choose a card to play:");

        
        displayHand();
        System.out.println("0: Draw a card");

        
        int choice = -1;
        while (choice < 0 || choice > getCardCount()) {
            System.out.print("Enter the number of the card you want to play (or 0 to draw): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

       
        if (choice == 0) {
            System.out.println("You chose to draw a card.");
            return null; 
        } else {
            Card chosenCard = getHand().get(choice - 1);
            if (chosenCard.canPlayOn(topCard)) {
                System.out.println("You played: " + chosenCard.toString());
                return chosenCard;
            } else {
                System.out.println("Invalid play! The card does not match the top card.");
                return null; 
            }
        }
    }
}


