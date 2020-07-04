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
}
