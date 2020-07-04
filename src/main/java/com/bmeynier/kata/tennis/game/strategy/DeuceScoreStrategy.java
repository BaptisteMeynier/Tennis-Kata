package com.bmeynier.kata.tennis.game.strategy;

import com.bmeynier.kata.tennis.Player;
import com.bmeynier.kata.tennis.game.DeuceScore;

import java.util.Optional;

public class DeuceScoreStrategy implements ScoreStrategy {

    public String announceScore(Player playerOne, Player playerTwo) {
        Optional<String> score = Optional.empty();
        if (this.isDeuce(playerOne, playerTwo)) {
            score = Optional.of(DeuceScore.DEUCE.value());
        }
        if (this.isAdvantage(playerOne, playerTwo)) {
            Player playerWithHighestPoint = this.getPlayerWithHighestPoint(playerOne, playerTwo);
            score = Optional.of(String.format("%s %s", DeuceScore.ADVANTAGE.value(), playerWithHighestPoint.getName()));
        }
        if (this.isWin(playerOne, playerTwo)) {
            Player playerWithHighestPoint = this.getPlayerWithHighestPoint(playerOne, playerTwo);
            score = Optional.of(String.format("%s %s", playerWithHighestPoint.getName(), DeuceScore.WIN.value()));
        }
        return score.orElseThrow(IllegalStateException::new);
    }

    private boolean isDeuce(Player playerOne, Player playerTwo) {
        return playerOne.getNbPoint() == playerTwo.getNbPoint();
    }

    private boolean isAdvantage(Player playerOne, Player playerTwo) {
        return Math.abs(playerOne.getNbPoint() - playerTwo.getNbPoint()) == 1;
    }

    private boolean isWin(Player playerOne, Player playerTwo) {
        return Math.abs(playerOne.getNbPoint() - playerTwo.getNbPoint()) == 2;
    }

    private Player getPlayerWithHighestPoint(Player playerOne, Player playerTwo) {
        return playerOne.getNbPoint() > playerTwo.getNbPoint() ? playerOne : playerTwo;
    }
}
