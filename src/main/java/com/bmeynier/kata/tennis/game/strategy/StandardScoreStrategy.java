package com.bmeynier.kata.tennis.game.strategy;

import com.bmeynier.kata.tennis.Player;
import com.bmeynier.kata.tennis.game.StandardScore;

import java.util.Optional;

public class StandardScoreStrategy implements ScoreStrategy {
    public String announceScore(Player playerOne, Player playerTwo) {
        Optional<String> score;
        StandardScore playerOneScore = StandardScore.getScore(playerOne.getNbPoint());
        StandardScore playerTwoScore = StandardScore.getScore(playerTwo.getNbPoint());
        if (this.isWin(playerOneScore, playerTwoScore)) {
            score = Optional.of(this.announceWin(playerOne, playerTwo));
        } else {
            score = Optional.of(this.announceStandardScore(playerOneScore, playerTwoScore));
        }
        return score.orElseThrow(IllegalStateException::new);
    }

    private boolean isWin(StandardScore playerOneScore, StandardScore playerTwoScore) {
        return playerOneScore.isWin() || playerTwoScore.isWin();
    }

    private String announceWin(Player playerOne, Player playerTwo) {
        Player highestPlayer = this.getHighestPlayer(playerOne, playerTwo);
        StandardScore playerScore = StandardScore.getScore(highestPlayer.getNbPoint());
        return String.format("%s %s", highestPlayer.getName(), playerScore.value());
    }

    private String announceStandardScore(StandardScore playerOneScore, StandardScore playerTwoScore) {
        return String.format("%s %s", playerOneScore.value(), playerTwoScore.value());
    }

    private Player getHighestPlayer(Player playerOne, Player playerTwo) {
        return playerOne.getNbPoint() > playerTwo.getNbPoint() ? playerOne : playerTwo;
    }
}
