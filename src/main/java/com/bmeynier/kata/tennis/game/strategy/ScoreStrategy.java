package com.bmeynier.kata.tennis.game.strategy;

import com.bmeynier.kata.tennis.Player;

public interface ScoreStrategy {
    String announceScore(Player playerOne, Player playerTwo);
}
