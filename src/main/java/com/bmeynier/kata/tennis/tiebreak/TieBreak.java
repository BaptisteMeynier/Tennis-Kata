package com.bmeynier.kata.tennis.tiebreak;

import com.bmeynier.kata.tennis.Player;

import static com.bmeynier.kata.tennis.TennisConstant.STANDARD_POINT_BY_TIE_BREAK;
import static com.bmeynier.kata.tennis.TennisConstant.WIN_TIE_BREAK_STATEMENT;

public class TieBreak {

    public String announceScore(Player playerOne, Player playerTwo) {
        Player playerWithHighestPoint = Player.getPlayerWithHighestPoint(playerOne, playerTwo);
        Player playerWithLowestPoint = Player.getPlayerWithLowestPoint(playerOne, playerTwo);
        if (this.isWin(playerWithHighestPoint, playerWithLowestPoint)) {
            return String.format("%s %s", playerWithHighestPoint.getName(), WIN_TIE_BREAK_STATEMENT);
        }
        return String.format("%d %d", playerOne.getNbPoint(), playerTwo.getNbPoint());
    }

    private boolean isWin(Player playerWithHighestPoint, Player playerWithLowestPoint) {
        int diffBetweenPayers = playerWithHighestPoint.getNbPoint() - playerWithLowestPoint.getNbPoint();
        boolean isStandard = playerWithHighestPoint.getNbPoint() == STANDARD_POINT_BY_TIE_BREAK && diffBetweenPayers > 1;
        boolean isMoreThanSeven = playerWithLowestPoint.getNbPoint() > 5 && diffBetweenPayers == 2;
        return  isStandard || isMoreThanSeven;
    }

}
