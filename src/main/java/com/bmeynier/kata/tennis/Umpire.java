package com.bmeynier.kata.tennis;

import com.bmeynier.kata.tennis.score.strategy.DeuceScoreStrategy;
import com.bmeynier.kata.tennis.score.strategy.ScoreStrategy;
import com.bmeynier.kata.tennis.score.strategy.StandardScoreStrategy;

public class Umpire {

    private static final int DEUCE_STEP = 3;

    private ScoreStrategy scoreStrategy;

    public String announceScore(Player playerOne, Player playerTwo) {
        this.setStrategy(playerOne, playerTwo);
        return scoreStrategy.sayScore(playerOne, playerTwo);
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
