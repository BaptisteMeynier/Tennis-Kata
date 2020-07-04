package com.bmeynier.kata.tennis.game.strategy;

import com.bmeynier.kata.tennis.game.StandardScore;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class StandardScoreTest {

    @Test
    void should_get_fifteen_when_get_first_score(){
        //GIVEN
        int nbPoint = 1;
        //WHEN
        StandardScore next = StandardScore.getScore(nbPoint);
        //THEN
        assertThat(next).isEqualTo(StandardScore.FIFTEEN);
    }

    @Test
    void should_throw_illegalStateException_when_get_higher_point(){
        //GIVEN
        int nbPoint = 10;
        //WHEN
        assertThatThrownBy(() -> StandardScore.getScore(nbPoint)).isInstanceOf(IllegalStateException.class);
        //THEN
    }

}