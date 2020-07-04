package com.bmeynier.kata.tennis;

import java.util.stream.IntStream;

public class Player {

    private int nbPoint = 0;
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public Player winPoint() {
        nbPoint++;
        return this;
    }

    public Player winPoints(int nbOfWinningPoints) {
        IntStream.range(0, nbOfWinningPoints).forEach(cpt -> this.winPoint());
        return this;
    }

    public int getNbPoint() {
        return nbPoint;
    }

    public String getName() {
        return name;
    }
}
