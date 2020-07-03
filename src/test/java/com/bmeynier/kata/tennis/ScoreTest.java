package com.bmeynier.kata.tennis;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ScoreTest {

    @Test
    void should_get_fifteen_when_win_point_with_zero_score(){
        //GIVEN
        Score score = Score.ZERO;
        //WHEN
        Score next = score.next();
        //THEN
        assertThat(next).isEqualTo(Score.FIFTEEN);
    }

    @Test
    void should_not_change_score_when_win_point_with_already_win_score(){
        //GIVEN
        Score score = Score.WIN;
        //WHEN
        Score next = score.next();
        //THEN
        assertThat(next).isEqualTo(Score.WIN);
    }

}