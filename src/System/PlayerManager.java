package System;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private List<Player> players;
    private int currentPlayerIndex;
    private boolean isDirectionRight;

    public PlayerManager() {
        players = new ArrayList<>();
        currentPlayerIndex = 0;
        isDirectionRight = true;
    }

    public boolean addPlayer(Player player) {
        return players.add(player);
    }

    public boolean removePlayer(Player player) {
        return players.remove(player);
    }

    public int getPlayerCount() {
        return players.size();
    }

    public String getRotationDirection() {
        return isDirectionRight ? "RIGHT" : "LEFT";
    }

    public void reverseDirection() {
        isDirectionRight = !isDirectionRight;
    }

    public void rotateToNextPlayer() {
        if (isDirectionRight) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        } else {
            currentPlayerIndex = (currentPlayerIndex - 1 + players.size()) % players.size();
        }
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public Player getNextPlayer() {
        int nextIndex = isDirectionRight
                ? (currentPlayerIndex + 1) % players.size()
                : (currentPlayerIndex - 1 + players.size()) % players.size();
        return players.get(nextIndex);
    }

    public Player findWinner() {
        for (Player player : players) {
            if (player.getCardCount() == 0) {
                return player;
            } 
        }
        return null;
    }
    
    public List<Player> getPlayers() {
        return players;
    }
    
    
}
