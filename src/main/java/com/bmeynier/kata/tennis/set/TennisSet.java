package com.bmeynier.kata.tennis.set;

import com.bmeynier.kata.tennis.Player;

import static com.bmeynier.kata.tennis.TennisConstant.WIN_SET_STATEMENT;

public class TennisSet {

    public static final int WINNING_STEP = 4;
    public static final int STANDARD_GAMES_NUMBER_BY_SET = 6;
    public static final int MAXIMUN_GAMES_NUMBER_BY_SET = 7;

    public String announceScore(Player playerOne, Player playerTwo) {
        Player playerWithLowestGames = this.getPlayerWithLowestGames(playerOne, playerTwo);
        Player playerWithHighestGames = this.getPlayerWithHighestGames(playerOne, playerTwo);
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

    private Player getPlayerWithLowestGames(Player playerOne, Player playerTwo) {
        return playerOne.getNbGame() < playerTwo.getNbGame() ? playerOne : playerTwo;
    }

    private Player getPlayerWithHighestGames(Player playerOne, Player playerTwo) {
        return playerOne.getNbGame() > playerTwo.getNbGame() ? playerOne : playerTwo;
    }

}
