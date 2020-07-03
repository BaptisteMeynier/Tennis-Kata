package com.bmeynier.kata.tennis;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    void should_get_score_when_player_win_point() {
        //GIVEN
        Player player = new Player();
        //WHEN
        player = player.winPoint();
        //THEN
        assertThat(player.getScore().value()).isEqualTo(Score.FIFTEEN.value());
    }

    @Test
    void should_change_score_when_player_win_point() {
        //GIVEN
        Player player = new Player();
        final Score initialScore = player.getScore();
        //WHEN
        player = player.winPoint();
        //THEN
        assertThat(player.getScore().value()).isNotEqualTo(initialScore);
    }

    @Test
    void should_win_game_when_player_win_four_points(){
        //GIVEN
        Player player = new Player();
        //WHEN
        player = player
                .winPoint()
                .winPoint()
                .winPoint()
                .winPoint();
        //THEN
        assertThat(player.getScore()).isEqualTo(Score.WIN);
    }
}
