package com.bmeynier.kata.tennis;

import com.bmeynier.kata.tennis.score.PointResult;

import java.util.List;
import java.util.Objects;

public class Game {

    private Game() {
    }

    public static PlayerTwoStep withPlayerOne(Player player) {
        return new Builder(player);
    }

    interface PlayerTwoStep {
        GameStep withPlayerTwo(Player player);
    }

    interface GameStep {
        GameStep playPoints(List<PointResult> pointResults);
        String getScore();
    }

    static class Builder implements PlayerTwoStep, GameStep {

        private Player playerOne;
        private Player playerTwo;

        public Builder(Player player) {
            this.playerOne = Objects.requireNonNull(player);
        }

        @Override
        public GameStep withPlayerTwo(Player player) {
            this.playerTwo = Objects.requireNonNull(player);
            return this;
        }

        @Override
        public GameStep playPoints(List<PointResult> pointResults) {
            pointResults.forEach(this::playPoint);
            return this;
        }

        @Override
        public String getScore() {
            return new Umpire().announceScore(playerOne, playerTwo);
        }

        private void playPoint(PointResult pointResult){
            if(PointResult.PLAYER_ONE_WIN.equals(pointResult)){
                this.playerOne.winPoint();
            }else{
                this.playerTwo.winPoint();
            }
        }
    }
}
