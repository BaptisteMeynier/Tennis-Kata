package com.bmeynier.kata.tennis.tiebreak;

import com.bmeynier.kata.tennis.Player;
import org.junit.jupiter.api.Test;

import static com.bmeynier.kata.tennis.TennisConstant.WIN_TIE_BREAK_STATEMENT;
import static org.assertj.core.api.Assertions.assertThat;

public class TieBreakTest {
    @Test
    void should_announce_one_zero_when_player_one_wins_point_and_both_player_begin_by_zero() {
        //GIVEN
        TieBreak tieBreak = new TieBreak();
        Player playerOne = new Player("Novak");
        Player playerTwo = new Player("Nadal");
        //WHEN
        playerOne.winPoint();
        //THEN
        assertThat(tieBreak.announceScore(playerOne, playerTwo)).isEqualTo("1 0");
    }

    @Test
    void should_announce_win_when_player_one_wins_seven_points_and_player_two_has_less_than_five_points() {
        //GIVEN
        TieBreak tieBreak = new TieBreak();
        Player playerOne = new Player("Novak");
        Player playerTwo = new Player("Nadal");
        //WHEN
        playerOne.winPoints(7);
        //THEN
        assertThat(tieBreak.announceScore(playerOne, playerTwo)).contains(WIN_TIE_BREAK_STATEMENT).contains(playerOne.getName());
    }

    @Test
    void should_announce_score_when_player_one_get_seven_points_and_player_two_has_six_points() {
        //GIVEN
        TieBreak tieBreak = new TieBreak();
        Player playerOne = new Player("Novak");
        Player playerTwo = new Player("Nadal");
        //WHEN
        playerOne.winPoints(6);
        playerTwo.winPoints(6);
        playerOne.winPoint();
        //THEN
        assertThat(tieBreak.announceScore(playerOne, playerTwo)).isEqualTo("7 6");
    }

    @Test
    void should_announce_player_one_win_when_player_one_has_height_points_and_player_two_has_six_points() {
        //GIVEN
        TieBreak tieBreak = new TieBreak();
        Player playerOne = new Player("Novak");
        Player playerTwo = new Player("Nadal");
        //WHEN
        playerOne.winPoints(6);
        playerTwo.winPoints(6);
        playerOne.winPoints(2);
        //THEN
        assertThat(tieBreak.announceScore(playerOne, playerTwo)).contains(WIN_TIE_BREAK_STATEMENT).contains(playerOne.getName());
    }
}
