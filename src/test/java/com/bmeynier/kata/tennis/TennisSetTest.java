package com.bmeynier.kata.tennis;

import com.bmeynier.kata.tennis.set.TennisSet;
import org.junit.jupiter.api.Test;

import static com.bmeynier.kata.tennis.TennisConstant.WIN_SET_STATEMENT;
import static org.assertj.core.api.Assertions.assertThat;

public class TennisSetTest {
    @Test
    void should_say_one_game_when_player_wins_game_and_one_player_has_zero() {
        //GIVEN
        TennisSet tennisSet = new TennisSet();
        Player playerOne = new Player("Novak");
        Player playerTwo = new Player("Nadal");
        //WHEN
        playerOne.winGame();
        //THEN
        assertThat(tennisSet.announceScore(playerOne, playerTwo)).contains("0");
    }

    @Test
    void should_say_win_game_for_player_one_when_player_one_has_five_games_and_player_two_lower_than_four() {
        //GIVEN
        TennisSet tennisSet = new TennisSet();
        Player playerOne = new Player("Novak");
        Player playerTwo = new Player("Nadal");
        playerOne.winGames(6);
        playerTwo.winGames(4);
        //WHEN
        String score = tennisSet.announceScore(playerOne, playerTwo);
        //THEN
        assertThat(score).contains(WIN_SET_STATEMENT).contains(playerOne.getName());
    }

    @Test
    void should_annonce_score_for_players_when_player_one_and_two_has_same_number_of_games() {
        //GIVEN
        TennisSet tennisSet = new TennisSet();
        Player playerOne = new Player("Novak");
        Player playerTwo = new Player("Nadal");
        playerOne.winGames(6);
        playerTwo.winGames(6);
        //WHEN
        String score = tennisSet.announceScore(playerOne, playerTwo);
        //THEN
        assertThat(score).isEqualTo(playerOne.getNbGame() + "/" + playerOne.getNbGame());
    }

    @Test
    void should_annonce_score_for_players_when_player_one_has_six_player_two_five_games() {
        //GIVEN
        TennisSet tennisSet = new TennisSet();
        Player playerOne = new Player("Novak");
        Player playerTwo = new Player("Nadal");
        playerOne.winGames(6);
        playerTwo.winGames(5);
        //WHEN
        String score = tennisSet.announceScore(playerOne, playerTwo);
        //THEN
        assertThat(score).isEqualTo(playerOne.getNbGame() + "/" + playerTwo.getNbGame());
    }

    @Test
    void should_announce_win_game_for_player_one_when_player_one_has_seven_games_and_player_two_five() {
        //GIVEN
        TennisSet tennisSet = new TennisSet();
        Player playerOne = new Player("Novak");
        Player playerTwo = new Player("Nadal");
        playerOne.winGames(7);
        playerTwo.winGames(5);
        //WHEN
        String score = tennisSet.announceScore(playerOne, playerTwo);
        //THEN
        assertThat(score).contains(WIN_SET_STATEMENT).contains(playerOne.getName());
    }

    @Test
    void should_announce_win_game_for_player_one_when_player_one_has_seven_games_and_player_two_six() {
        //GIVEN
        TennisSet tennisSet = new TennisSet();
        Player playerOne = new Player("Novak");
        Player playerTwo = new Player("Nadal");
        playerOne.winGames(7);
        playerTwo.winGames(6);
        //WHEN
        String score = tennisSet.announceScore(playerOne, playerTwo);
        //THEN
        assertThat(score).contains(WIN_SET_STATEMENT).contains(playerOne.getName());
    }
}
