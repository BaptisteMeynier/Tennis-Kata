package com.bmeynier.kata.tennis.score.strategy;

import com.bmeynier.kata.tennis.Player;
import com.bmeynier.kata.tennis.score.StandardScore;

public class StandardScoreStrategy implements ScoreStrategy {
    public String sayScore(Player playerOne, Player playerTwo) {
        StandardScore playerOneScore = StandardScore.getScore(playerOne.getNbPoint());
        StandardScore playerTwoScore = StandardScore.getScore(playerTwo.getNbPoint());
        return String.format("%s %s", playerOneScore.value(), playerTwoScore.value());
    }
}
