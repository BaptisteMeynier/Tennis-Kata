package com.bmeynier.kata.tennis;

import com.bmeynier.kata.tennis.game.Game;
import com.bmeynier.kata.tennis.game.PointResult;
import com.bmeynier.kata.tennis.set.TennisSet;
import com.bmeynier.kata.tennis.tiebreak.TieBreak;

import java.util.List;
import java.util.Objects;

import static com.bmeynier.kata.tennis.TennisConstant.*;

public class Match {

    private Player playerOne;
    private Player playerTwo;
    private boolean setEnd = false;

    private Match(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    private void playPoint(PointResult pointResult) {
        if (!setEnd) {
            String score =
                    (PointResult.PLAYER_ONE_WIN.equals(pointResult)) ?
                            this.playPoint(this.playerOne) :
                            this.playPoint(this.playerTwo);
            if (score.contains(WIN_GAME)) {
                this.playerOne.initializePoint();
                this.playerTwo.initializePoint();
            }
            this.setEnd = this.isEnd();
        }
    }

    private String playPoint(Player player) {
        player.winPoint();
        String gameScore = this.displayGameScore();
        if (this.isGameEnd(player, gameScore)) {
            player.winGame();
        }
        if (this.isTieBreakEnd(player, gameScore) || this.isSetEnd(player, gameScore)) {
            player.winSet();
        }
        return gameScore;
    }

    private boolean isEnd() {
        return this.displaySetScore().contains(WIN_SET_STATEMENT) || this.displayGameScore().contains(WIN_TIE_BREAK_STATEMENT);
    }

    private boolean isTieBreak(Player playerOne, Player playerTwo) {
        boolean isSixSix = playerOne.getNbGame() == playerTwo.getNbGame() && playerOne.getNbGame() == TIE_BREAK_GAME_TRIGGER;
        boolean isSevenSix = Player.getPlayerWithHighestGames(playerOne, playerTwo).getNbGame() == MAXIMUN_GAMES_NUMBER_BY_SET &&
                Player.getPlayerWithLowestGames(playerOne,playerTwo).getNbGame() == STANDARD_GAMES_NUMBER_BY_SET;
        return isSixSix || isSevenSix;
    }

    private boolean isTieBreakEnd(Player player, String score) {
        return score.contains(player.getName()) && score.contains(WIN_TIE_BREAK_STATEMENT);
    }

    private boolean isSetEnd(Player player, String score) {
        return score.contains(player.getName()) && score.contains(WIN_SET_STATEMENT);
    }

    private boolean isGameEnd(Player player, String score) {
        return score.contains(player.getName()) && score.contains(WIN_GAME);
    }

    public Match playPoints(List<PointResult> pointResults) {
        pointResults.forEach(this::playPoint);
        return this;
    }

    public String displayGameScore() {
        return this.isTieBreak(playerOne, playerTwo) ?
                new TieBreak().announceScore(playerOne, playerTwo) :
                new Game().announceScore(playerOne, playerTwo);
    }

    public String displaySetScore() {
        return new TennisSet().announceScore(playerOne, playerTwo);
    }

    public String displayScore() {
        String winner = this.isEnd() ? "Winner " + Player.getWinner(playerOne, playerTwo).getName() : "";
        return String.format("%s %s %s", this.displaySetScore(), this.displayGameScore(), winner);
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
