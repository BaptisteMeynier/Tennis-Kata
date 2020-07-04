package com.bmeynier.kata.tennis;

import com.bmeynier.kata.tennis.game.Game;
import com.bmeynier.kata.tennis.game.PointResult;
import com.bmeynier.kata.tennis.set.TennisSet;

import java.util.List;
import java.util.Objects;

import static com.bmeynier.kata.tennis.TennisConstant.WIN_GAME;
import static com.bmeynier.kata.tennis.TennisConstant.WIN_SET_STATEMENT;

public class Match {

    private Player playerOne;
    private Player playerTwo;
    private boolean isSetEnd = false;

    private Match(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    private void playPoint(PointResult pointResult) {
        if(!isSetEnd) {
            String score =
                    (PointResult.PLAYER_ONE_WIN.equals(pointResult)) ?
                            this.playPoint(this.playerOne) :
                            this.playPoint(this.playerTwo);
            if (score.contains(WIN_GAME)) {
                this.playerOne.initializePoint();
                this.playerTwo.initializePoint();
            }
            this.isSetEnd = this.displaySetScore().contains(WIN_SET_STATEMENT);
        }
    }

    private String playPoint(Player player) {
        player.winPoint();
        String gameScore = this.displayGameScore();
        if (this.isGameEnd(player, gameScore)) {
            player.winGame();
        }
        return gameScore;
    }

    private boolean isGameEnd(Player player, String score) {
        return score.contains(player.getName()) && score.contains(WIN_GAME);
    }

    public Match playPoints(List<PointResult> pointResults) {
        pointResults.forEach(this::playPoint);
        return this;
    }

    public String displayGameScore() {
        return new Game().announceScore(playerOne, playerTwo);
    }

    public String displaySetScore() {
        return new TennisSet().announceScore(playerOne, playerTwo);
    }


    public static PlayerTwoStep withPlayerOne(Player player) {
        return new Builder(player);
    }

    interface PlayerTwoStep {
        FinalStep withPlayerTwo(Player player);
    }

    interface FinalStep {
        Match begin();
    }

    static class Builder implements PlayerTwoStep, FinalStep {

        private Player playerOne;
        private Player playerTwo;

        public Builder(Player player) {
            this.playerOne = Objects.requireNonNull(player);
        }

        @Override
        public FinalStep withPlayerTwo(Player player) {
            this.playerTwo = Objects.requireNonNull(player);
            return this;
        }

        @Override
        public Match begin() {
            return new Match(this.playerOne, this.playerTwo);
        }
    }
}
