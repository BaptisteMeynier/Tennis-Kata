package com.bmeynier.kata.tennis.game;

import static com.bmeynier.kata.tennis.TennisConstant.WIN_GAME;

public enum DeuceScore {
    DEUCE("Deuce"), ADVANTAGE("Advantage"), WIN(WIN_GAME);
    private String value;

    DeuceScore(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
