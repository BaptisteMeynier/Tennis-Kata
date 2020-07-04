package com.bmeynier.kata.tennis.game.strategy;

import com.bmeynier.kata.tennis.Player;
import com.bmeynier.kata.tennis.game.DeuceScore;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeuceScoreStrategyTest {
    @Test
    void should_be_deuce_when_players_win_same_number_of_point_and_reach_forty() {
        //GIVEN
        Player playerOne = new Player("Nadal").winPoints(3);
        Player playerTwo = new Player("Djokovic").winPoints(3);
        //WHEN
        playerOne.winPoint();
        playerTwo.winPoint();
        String score = new DeuceScoreStrategy().announceScore(playerOne, playerTwo);
        //THEN
        assertThat(score).isEqualTo(DeuceScore.DEUCE.value());
    }


    @Test
    void should_be_advantage_for_player_two_when_players_have_reach_forty_and_player_two_win_point() {
        //GIVEN
        Player playerOne = new Player("Nadal").winPoints(3);
        Player playerTwo = new Player("Djokovic").winPoints(3);
        playerOne.winPoint();
        playerTwo.winPoint();
        //WHEN
        playerTwo.winPoint();
        String score = new DeuceScoreStrategy().announceScore(playerOne, playerTwo);
        //THEN
        assertThat(score).contains(DeuceScore.ADVANTAGE.value()).contains(playerTwo.getName());
    }

    @Test
    void should_be_win_for_player_two_when_players_have_reach_forty_and_player_two_win_two_points() {
        //GIVEN
        Player playerOne = new Player("Nadal").winPoints(3);
        Player playerTwo = new Player("Djokovic").winPoints(3);
        playerOne.winPoint();
        playerTwo.winPoint();
        //WHEN
        playerTwo.winPoints(2);
        String score = new DeuceScoreStrategy().announceScore(playerOne, playerTwo);
        //THEN
        assertThat(score).contains(DeuceScore.WIN.value()).contains(playerTwo.getName());
    }
}