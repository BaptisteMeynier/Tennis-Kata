package com.bmeynier.kata.tennis;

import com.bmeynier.kata.tennis.game.DeuceScore;
import com.bmeynier.kata.tennis.game.PointResult;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static com.bmeynier.kata.tennis.TennisConstant.WIN_SET_STATEMENT;
import static com.bmeynier.kata.tennis.game.PointResult.PLAYER_ONE_WIN;
import static com.bmeynier.kata.tennis.game.PointResult.PLAYER_TWO_WIN;
import static org.assertj.core.api.Assertions.assertThat;

class MatchIT {

    @Test
    void should_be_deuce_when_got_fourteen_fourteen() {
        //GIVEN
        Player djokovic = new Player("Novak");
        Player nadal = new Player("Raphael");
        List<PointResult> playerOnePoints = Collections.nCopies(3, PLAYER_ONE_WIN);
        List<PointResult> playerTwoPoints = Collections.nCopies(3, PLAYER_TWO_WIN);
        //WHEN
        String score = Match
                .withPlayerOne(djokovic)
                .withPlayerTwo(nadal)
                .begin()
                .playPoints(playerOnePoints)
                .playPoints(playerTwoPoints)
                .displayGameScore();

        //THEN
        assertThat(score).isEqualTo(DeuceScore.DEUCE.value());
    }

    @Test
    void should_display_when_got_fourteen_fourteen() {
        //GIVEN
        Player djokovic = new Player("Novak");
        Player nadal = new Player("Raphael");
        List<PointResult> playerOnePoints = Collections.nCopies(2, PLAYER_ONE_WIN);
        List<PointResult> playerTwoPoints = Collections.nCopies(2, PLAYER_TWO_WIN);
        //WHEN
        String score = Match
                .withPlayerOne(djokovic)
                .withPlayerTwo(nadal)
                .begin()
                .playPoints(playerOnePoints)
                .playPoints(playerTwoPoints)
                .displaySetScore();

        //THEN
        assertThat(score).isEqualTo("0/0");
    }

    @Test
    void should_initialize_game_point_when_player_win_game() {
        //GIVEN
        Player djokovic = new Player("Novak");
        Player nadal = new Player("Raphael");
        List<PointResult> playerOnePoints = Collections.nCopies(4, PLAYER_ONE_WIN);
        List<PointResult> playerTwoPoints = Collections.nCopies(0, PLAYER_TWO_WIN);
        //WHEN
        String score = Match
                .withPlayerOne(djokovic)
                .withPlayerTwo(nadal)
                .begin()
                .playPoints(playerOnePoints)
                .playPoints(playerTwoPoints)
                .displayGameScore();

        //THEN
        assertThat(score).isEqualTo("0 0");
    }

    @Test
    void should_add_game_when_player_one_win_four_point() {
        //GIVEN
        Player djokovic = new Player("Novak");
        Player nadal = new Player("Raphael");
        List<PointResult> playerOnePoints = Collections.nCopies(4, PLAYER_ONE_WIN);
        List<PointResult> playerTwoPoints = Collections.nCopies(0, PLAYER_TWO_WIN);
        //WHEN
        String score = Match
                .withPlayerOne(djokovic)
                .withPlayerTwo(nadal)
                .begin()
                .playPoints(playerOnePoints)
                .playPoints(playerTwoPoints)
                .displaySetScore();

        //THEN
        assertThat(score).isEqualTo("1/0");
    }

    @Test
    void should_have_one_zero_for_player_two() {
        //GIVEN
        Player djokovic = new Player("Novak");
        Player nadal = new Player("Raphael");
        List<PointResult> playerOnePoints = Collections.nCopies(3, PLAYER_ONE_WIN);
        List<PointResult> playerTwoPoints = Collections.nCopies(3, PLAYER_TWO_WIN);
        //WHEN

        Match match = Match
                .withPlayerOne(djokovic)
                .withPlayerTwo(nadal)
                .begin()
                .playPoints(playerOnePoints)//0/0 40 / 0
                .playPoints(playerTwoPoints)//0/0 40 / 40
                .playPoints(playerTwoPoints); // 0/1 0 15

        String gameScore = match.displayGameScore();
        String setScore = match.displaySetScore();

        //THEN
        assertThat(setScore).isEqualTo("0/1");
        assertThat(gameScore).isEqualTo("0 15");
    }

    @Test
    void should_win_the_set_zero_for_player_one() {
        //GIVEN
        Player djokovic = new Player("Novak");
        Player nadal = new Player("Raphael");
        List<PointResult> playerOnePoints = Collections.nCopies(40, PLAYER_ONE_WIN);
        List<PointResult> playerTwoPoints = Collections.nCopies(0, PLAYER_TWO_WIN);
        //WHEN

        Match match = Match
                .withPlayerOne(djokovic)
                .withPlayerTwo(nadal)
                .begin()
                .playPoints(playerOnePoints)
                .playPoints(playerTwoPoints);

        String setScore = match.displaySetScore();

        //THEN
        assertThat(setScore).contains(WIN_SET_STATEMENT);
    }
}