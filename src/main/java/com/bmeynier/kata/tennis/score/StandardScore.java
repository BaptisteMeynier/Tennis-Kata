package com.bmeynier.kata.tennis.score;

import java.util.Arrays;

public enum StandardScore {
    ZERO("0"), FIFTEEN("15"), THIRTY("30"), FORTY("40"), WIN("Win game");

    private String value;

    StandardScore(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static StandardScore getScore(int ordinal) {
        return Arrays.stream(StandardScore.values())
                .filter(score -> score.ordinal() == ordinal)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

}
