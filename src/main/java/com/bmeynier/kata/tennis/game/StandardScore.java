package com.bmeynier.kata.tennis.game;

import java.util.Arrays;

import static com.bmeynier.kata.tennis.TennisConstant.WIN_GAME;

public enum StandardScore {
    ZERO("0"), FIFTEEN("15"), THIRTY("30"), FORTY("40"), WIN(WIN_GAME);

    private String value;

    StandardScore(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public boolean isWin() {
        return this.equals(WIN);
    }

    public static StandardScore getScore(int ordinal) {
        return Arrays.stream(StandardScore.values())
                .filter(score -> score.ordinal() == ordinal)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

}
