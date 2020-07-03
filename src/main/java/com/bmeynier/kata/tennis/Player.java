package com.bmeynier.kata.tennis;

public class Player {

    private Score score = Score.ZERO;

    public Player winPoint() {
        this.score = score.next();
        return this;
    }

    public Score getScore() {
        return score;
    }
}
