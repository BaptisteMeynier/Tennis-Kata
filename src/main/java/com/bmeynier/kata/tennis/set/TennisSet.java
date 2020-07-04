package com.bmeynier.kata.tennis.set;

import com.bmeynier.kata.tennis.Player;

import static com.bmeynier.kata.tennis.TennisConstant.*;

public class TennisSet {

    public String announceScore(Player playerOne, Player playerTwo) {
        Player playerWithLowestGames = Player.getPlayerWithLowestGames(playerOne, playerTwo);
        Player playerWithHighestGames = Player.getPlayerWithHighestGames(playerOne, playerTwo);
        if (this.isWin(playerWithLowestGames, playerWithHighestGames)) {
            return announceWinner(playerWithHighestGames);
        }
        return annonceGames(playerOne, playerTwo);
    }

    private boolean isWin(Player playerWithLowestGames, Player playerWithHighestGames) {
        boolean isMaximumGamesConfiguration =
                playerWithLowestGames.getNbGame() > WINNING_STEP &&
                        playerWithHighestGames.getNbGame() == MAXIMUN_GAMES_NUMBER_BY_SET;
        boolean isStandardGameConfiguration =
                playerWithHighestGames.getNbGame() == STANDARD_GAMES_NUMBER_BY_SET &&
                        playerWithLowestGames.getNbGame() != STANDARD_GAMES_NUMBER_BY_SET &&
                        playerWithLowestGames.getNbGame() <= WINNING_STEP;
        return isMaximumGamesConfiguration || isStandardGameConfiguration;
    }

    private String annonceGames(Player playerOne, Player playerTwo) {
        return String.format("%d/%d", playerOne.getNbGame(), playerTwo.getNbGame());
    }

    private String announceWinner(Player playerWithHighestGames) {
        return String.format("%s %s", playerWithHighestGames.getName(), WIN_SET_STATEMENT);
    }

}
