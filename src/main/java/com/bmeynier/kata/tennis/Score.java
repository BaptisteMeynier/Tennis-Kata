package com.bmeynier.kata.tennis;

import java.util.Arrays;

public enum Score {
    ZERO("0"), FIFTEEN("15"), THIRTEEN("30"), FOURTEEN("40"), WIN("Win game");

    private String value;

    Score(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public Score next() {
        int next = this.ordinal() + 1;
        int total = Score.values().length - 1;
        int nextScoreRank = Math.min(next, total);
        return Arrays.stream(Score.values())
                .filter(score -> score.ordinal() == nextScoreRank)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
}
