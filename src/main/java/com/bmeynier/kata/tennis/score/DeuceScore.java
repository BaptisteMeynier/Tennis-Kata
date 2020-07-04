package com.bmeynier.kata.tennis.score;

import com.bmeynier.kata.tennis.Player;

public enum DeuceScore {
    DEUCE("Deuce"), ADVANTAGE("Advantage"), WIN("Win game");
    private String value;

    DeuceScore(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
