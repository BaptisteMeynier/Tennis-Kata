package com.bmeynier.kata.tennis;

import java.util.stream.IntStream;

public class Player {

    private int nbPoint = 0;
    private int nbGame = 0;
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

    public Player winGame() {
        this.initializePoint();
        nbGame++;
        return this;
    }

    public Player winGames(int nbOfWinningGames) {
        IntStream.range(0, nbOfWinningGames).forEach(cpt -> this.winGame());
        return this;
    }

    public void initializePoint() {
        nbPoint = 0;
    }

    public int getNbPoint() {
        return nbPoint;
    }

    public String getName() {
        return name;
    }

    public int getNbGame() {
        return nbGame;
    }

}
