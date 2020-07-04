package com.bmeynier.kata.tennis;

import com.bmeynier.kata.tennis.game.Game;
import com.bmeynier.kata.tennis.game.DeuceScore;
import com.bmeynier.kata.tennis.game.StandardScore;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void should_say_fifteen_when_player_wins_point_and_one_player_has_zero() {
        //GIVEN
        Game game = new Game();
        Player playerOne = new Player("Novak");
        Player playerTwo = new Player("Nadal");
        playerOne.winPoint();
        //WHEN
        String score = game.announceScore(playerOne, playerTwo);
        //THEN
        assertThat(score).contains(StandardScore.FIFTEEN.value());
    }

    @Test
    void should_say_player_one_win_when_player_one_wins_four_points_and_player_two_has_not_forty() {
        //GIVEN
        Game game = new Game();
        Player playerOne = new Player("Novak");
        Player playerTwo = new Player("Nadal");
        playerOne.winPoints(4);
        //WHEN
        String score = game.announceScore(playerOne, playerTwo);
        //THEN
        assertThat(score).contains(StandardScore.WIN.value()).contains(playerOne.getName());
    }

    @Test
    void should_say_deuce_when_player_one_and_two_have_forty() {
        //GIVEN
        Game game = new Game();
        Player playerOne = new Player("Novak");
        Player playerTwo = new Player("Nadal");
        playerOne.winPoints(3);
        playerTwo.winPoints(3);
        //WHEN
        String score = game.announceScore(playerOne, playerTwo);
        //THEN
        assertThat(score).contains(DeuceScore.DEUCE.value());
    }

    @Test
    void should_say_advantage_player_one_when_players_were_deuce_and_player_wins_one_point() {
        //GIVEN
        Game game = new Game();
        Player playerOne = new Player("Novak");
        Player playerTwo = new Player("Nadal");
        playerOne.winPoints(4);
        playerTwo.winPoints(3);
        //WHEN
        String score = game.announceScore(playerOne, playerTwo);
        //THEN
        assertThat(score).contains(DeuceScore.ADVANTAGE.value()).contains(playerOne.getName());
    }

    @Test
    void should_say_deuce_when_player_one_has_advantage_and_player_two_wins_one_point() {
        //GIVEN
        Game game = new Game();
        Player playerOne = new Player("Novak");
        Player playerTwo = new Player("Nadal");
        playerOne.winPoints(6);
        playerTwo.winPoints(6);
        //WHEN
        String score = game.announceScore(playerOne, playerTwo);
        //THEN
        assertThat(score).contains(DeuceScore.DEUCE.value());
    }

    @Test
    void should_say_win_for_player_one_when_player_one_wins_two_points_after_deuce() {
        //GIVEN
        Game game = new Game();
        Player playerOne = new Player("Novak");
        Player playerTwo = new Player("Nadal");
        playerOne.winPoints(3);
        playerTwo.winPoints(3);
        //WHEN
        playerOne.winPoints(2);
        String score = game.announceScore(playerOne, playerTwo);
        //THEN
        assertThat(score).contains(DeuceScore.WIN.value()).contains(playerOne.getName());
    }

}