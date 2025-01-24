package Game;

import System.Bot;
import System.EffectsController;
import System.Player;
import System.PlayerManager;
import System.Rules;
import System.SmartPlayer;
import System.Table;
import Uno.Card;
import Uno.Deck;
import Uno.GamePile;

public class GamePlay {
    private PlayerManager playerManager;
    private Rules rules;
    private Table table;

    public GamePlay() { 
        playerManager = new PlayerManager();
        rules = new Rules(new Table(new Deck(), new GamePile()), playerManager);
        table = new Table(new Deck(), new GamePile());
    }

    public void init() {
        table.prepareTable();

        
        playerManager.addPlayer(new SmartPlayer("Player 1"));

        
        playerManager.addPlayer(new Bot("Bot 1"));
        playerManager.addPlayer(new Bot("Bot 2"));

        
        distributeCards();
    }

    private void distributeCards() {
        for (Player player : playerManager.getPlayers()) {
            for (int i = 0; i < 7; i++) {
                Card drawnCard = table.drawCard();
                if (drawnCard != null) {
                    player.addCard(drawnCard);
                } else {
                    throw new IllegalStateException("Not enough cards in the deck to distribute.");
                }
            }
        }
    }
    
    private void displayGameStart() {
        System.out.println("\n");
        System.out.println("-----------------------------------------");
        System.out.println("|                                       |");
        System.out.println("|          G A M E   S T A R T !        |");
        System.out.println("|                                       |");
        System.out.println("-----------------------------------------");
        System.out.println("\n");
    }
    
    private void displayCurrentPlayer(Player currentPlayer) {
        System.out.println("\n");
        System.out.println("-----------------------------------------");
        System.out.println("|                                       |");
        System.out.println("|         Current Player: " + currentPlayer.getName() + "         |");
        System.out.println("|                                       |");
        System.out.println("-----------------------------------------");
        System.out.println("\n");
    }



    public void start() {
    	
    	displayGameStart();
    	
        while (true) {
            Player currentPlayer = playerManager.getCurrentPlayer();
            Card topCard = table.getLastPlayedCard();

            displayCurrentPlayer(currentPlayer);
            table.displayTableState();

            if (currentPlayer instanceof SmartPlayer) {
                currentPlayer.displayHand();
            }

            Card chosenCard = currentPlayer.chooseCard(topCard);
            if (chosenCard != null) {
                if (rules.isValidPlay(chosenCard, topCard)) {
                    table.playCard(currentPlayer, chosenCard);
                    chosenCard.applyEffect(rules);
                    System.out.println(currentPlayer.getName() + " played: " + chosenCard.toString());
                } else {
                    System.out.println("Invalid play! Try again.");
                }
            } else {
                Card drawnCard = table.drawCard();
                currentPlayer.addCard(drawnCard);
                System.out.println(currentPlayer.getName() + " drew a card: " + drawnCard.toString());
            }

            if (currentPlayer.getCardCount() == 0) {
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            playerManager.rotateToNextPlayer();
        }
    }

    public void finish() {
        System.out.println("\n");
        System.out.println("-----------------------------------------------------");
        System.out.println("|                                                   |");
        System.out.println("|                 G A M E   O V E R                 |");
        System.out.println("|                                                   |");
        System.out.println("-----------------------------------------------------");
        System.out.println("\n");
    }

   

}
