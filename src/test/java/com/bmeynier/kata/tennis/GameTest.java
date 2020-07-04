package com.bmeynier.kata.tennis;

import com.bmeynier.kata.tennis.score.PointResult;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static com.bmeynier.kata.tennis.score.PointResult.PLAYER_ONE_WIN;
import static com.bmeynier.kata.tennis.score.PointResult.PLAYER_TWO_WIN;

class GameTest {

    @Test
    void should_be_deuce_when_got_fourteen_fourteen() {
        //GIVEN
        Player djokovic = new Player("Novak");
        Player nadal = new Player("Raphael");
        List<PointResult> playerOnePoints = Collections.nCopies(4, PLAYER_ONE_WIN);
        List<PointResult> playerTwoPoints = Collections.nCopies(4, PLAYER_TWO_WIN);
        //WHEN
        String score = Game
                .withPlayerOne(djokovic)
                .withPlayerTwo(nadal)
                .playPoints(playerOnePoints)
                .playPoints(playerTwoPoints)
                .getScore();
        //THEN
        //assertThat(score).isEqualTo()
    }
}