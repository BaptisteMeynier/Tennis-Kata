package com.bmeynier.kata.tennis;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    void should_get_greater_score_when_player_win_point() {
        //GIVEN
        Player player = new Player("Player");
        int initialNbPoint = player.getNbPoint();
        //WHEN
        player = player.winPoint();
        //THEN
        assertThat(player.getNbPoint()).isGreaterThan(initialNbPoint);
    }

    @Test
    void should_get_three_additional_point_when_player_win_three_points() {
        //GIVEN
        Player player = new Player("Player");
        int initialNbPoint = player.getNbPoint();
        //WHEN
        player = player.winPoints(3);
        //THEN
        assertThat(player.getNbPoint() - initialNbPoint).isEqualTo(3);
    }

    @Test
    void should_add_game_when_player_win_game_with_a_game_number_lower_than_five() {
        //GIVEN
        Player player = new Player("Novak");
        //WHEN
        player = player.winGame();
        //THEN
        assertThat(player.getNbGame()).isEqualTo(1);
    }

    @Test
    void should_get_three_additional_game_when_player_win_three_games() {
        //GIVEN
        Player player = new Player("Player");
        int initialNbGame = player.getNbGame();
        //WHEN
        player = player.winGames(3);
        //THEN
        assertThat(player.getNbGame() - initialNbGame).isEqualTo(3);
    }

    @Test
    void should_get_player_one_with_player_one_has_less_point_than_player_two() {
        //GIVEN
        Player playerOne = new Player("PlayerOne");
        Player playerTwo = new Player("PlayerTwo").winGame();
        //WHEN
        Player playerWithLowestGames = Player.getPlayerWithLowestGames(playerOne, playerTwo);
        //THEN
        assertThat(playerWithLowestGames.getName()).isEqualTo(playerOne.getName());
    }

    @Test
    void should_get_player_two_with_player_one_has_less_point_than_player_two() {
        //GIVEN
        Player playerOne = new Player("PlayerOne");
        Player playerTwo = new Player("PlayerTwo").winPoints(5);
        //WHEN
        Player playerWithHighestGames = Player.getPlayerWithHighestGames(playerOne, playerTwo);
        //THEN
        assertThat(playerWithHighestGames.getName()).isEqualTo(playerTwo.getName());
    }

    @Test
    void should_get_player_two_when_get_highest_nb_of_point_with_player_one_has_less_point_than_player_two() {
        //GIVEN
        Player playerOne = new Player("PlayerOne");
        Player playerTwo = new Player("PlayerTwo").winPoints(3);
        //WHEN
        Player playerWithHighestPoint = Player.getPlayerWithHighestPoint(playerOne, playerTwo);
        //THEN
        assertThat(playerWithHighestPoint.getName()).isEqualTo(playerTwo.getName());
    }
}
