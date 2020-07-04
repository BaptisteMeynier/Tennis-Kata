package com.bmeynier.kata.tennis.game;

import com.bmeynier.kata.tennis.Player;
import com.bmeynier.kata.tennis.game.strategy.DeuceScoreStrategy;
import com.bmeynier.kata.tennis.game.strategy.ScoreStrategy;
import com.bmeynier.kata.tennis.game.strategy.StandardScoreStrategy;

public class Game {

    private static final int DEUCE_STEP = 3;

    private ScoreStrategy scoreStrategy;

    public String announceScore(Player playerOne, Player playerTwo) {
        this.setStrategy(playerOne, playerTwo);
        return scoreStrategy.announceScore(playerOne, playerTwo);
    }

    private void setStrategy(Player playerOne, Player playerTwo) {
        this.scoreStrategy = (this.isDeuce(playerOne, playerTwo)) ?
                new DeuceScoreStrategy() :
                new StandardScoreStrategy();
    }

    private boolean isDeuce(Player playerOne, Player playerTwo) {
        return playerOne.getNbPoint() >= DEUCE_STEP && playerTwo.getNbPoint() >= DEUCE_STEP;
    }
}
