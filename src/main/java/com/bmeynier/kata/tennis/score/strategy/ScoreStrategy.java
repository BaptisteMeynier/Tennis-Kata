package com.bmeynier.kata.tennis.score.strategy;

import com.bmeynier.kata.tennis.Player;

public interface ScoreStrategy {
    String sayScore(Player playerOne, Player playerTwo);
}
