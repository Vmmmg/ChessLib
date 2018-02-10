package chess.models.pieces;

import chess.models.Position;
import chess.models.enums.MoveResult;
import chess.models.enums.Player;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AdvisorTest {

    /**
     * Method: isLegalMove(Position pos)
     */
    @Test
    public void isLegalMove() {
        Advisor blackAdvisor = new Advisor(Player.Black, new Position("D3"));
        assertEquals(blackAdvisor.isLegalMove(new Position("D3")), MoveResult.SamePosition);
        assertEquals(blackAdvisor.isLegalMove(new Position("C2")), MoveResult.LegalMove);
        assertEquals(blackAdvisor.isLegalMove(new Position("D2")), MoveResult.LegalMove);
        assertEquals(blackAdvisor.isLegalMove(new Position("E2")), MoveResult.LegalMove);
        assertEquals(blackAdvisor.isLegalMove(new Position("C3")), MoveResult.LegalMove);
        assertEquals(blackAdvisor.isLegalMove(new Position("E3")), MoveResult.LegalMove);
        assertEquals(blackAdvisor.isLegalMove(new Position("C1")), MoveResult.IllegalMove);
        assertEquals(blackAdvisor.isLegalMove(new Position("D1")), MoveResult.IllegalMove);
        assertEquals(blackAdvisor.isLegalMove(new Position("E1")), MoveResult.IllegalMove);
        assertEquals(blackAdvisor.isLegalMove(new Position("D4")), MoveResult.IllegalMove);

        Advisor whiteAdvisor = new Advisor(Player.White, new Position("D6"));
        assertEquals(whiteAdvisor.isLegalMove(new Position("D6")), MoveResult.SamePosition);
        assertEquals(whiteAdvisor.isLegalMove(new Position("C7")), MoveResult.LegalMove);
        assertEquals(whiteAdvisor.isLegalMove(new Position("D7")), MoveResult.LegalMove);
        assertEquals(whiteAdvisor.isLegalMove(new Position("E7")), MoveResult.LegalMove);
        assertEquals(whiteAdvisor.isLegalMove(new Position("C6")), MoveResult.LegalMove);
        assertEquals(whiteAdvisor.isLegalMove(new Position("E6")), MoveResult.LegalMove);
        assertEquals(whiteAdvisor.isLegalMove(new Position("C8")), MoveResult.IllegalMove);
        assertEquals(blackAdvisor.isLegalMove(new Position("D8")), MoveResult.IllegalMove);
        assertEquals(blackAdvisor.isLegalMove(new Position("E8")), MoveResult.IllegalMove);
        assertEquals(blackAdvisor.isLegalMove(new Position("D5")), MoveResult.IllegalMove);
    }

    /**
     * Method: getNinePalaces(Position pos)
     */
    @Test
    public void getNinePalaces1() {
        Advisor blackAdvisor = new Advisor(Player.Black, new Position("D1"));
        Set<Position> blackNinePalaces = blackAdvisor.getNinePalaces();
        Set<Position> ninePalaces = new HashSet<>();
        Position posC1 = new Position("C1");
        Position posD1 = new Position("D1");
        Position posE1 = new Position("E1");
        Position posC2 = new Position("C2");
        Position posD2 = new Position("D2");
        Position posE2 = new Position("E2");
        Position posC3 = new Position("C3");
        Position posD3 = new Position("D3");
        Position posE3 = new Position("E3");

        ninePalaces.add(posC1);
        ninePalaces.add(posD1);
        ninePalaces.add(posE1);
        ninePalaces.add(posC2);
        ninePalaces.add(posD2);
        ninePalaces.add(posE2);
        ninePalaces.add(posC3);
        ninePalaces.add(posD3);
        ninePalaces.add(posE3);

        boolean isFullEquals = this.isSetEquals(ninePalaces, blackNinePalaces);

        assertEquals(isFullEquals, true);
    }

    @Test
    public void getNinePalaces2() {
        Advisor whiteAdvisor = new Advisor(Player.White, new Position("D8"));
        Set<Position> whiteNinePalaces = whiteAdvisor.getNinePalaces();
        Set<Position> ninePalaces = new HashSet<>();
        Position posC6 = new Position("C6");
        Position posD6 = new Position("D6");
        Position posE6 = new Position("E6");
        Position posC7 = new Position("C7");
        Position posD7 = new Position("D7");
        Position posE7 = new Position("E7");
        Position posC8 = new Position("C8");
        Position posD8 = new Position("D8");
        Position posE8 = new Position("E8");

        ninePalaces.add(posC6);
        ninePalaces.add(posD6);
        ninePalaces.add(posE6);
        ninePalaces.add(posC7);
        ninePalaces.add(posD7);
        ninePalaces.add(posE7);
        ninePalaces.add(posC8);
        ninePalaces.add(posD8);
        ninePalaces.add(posE8);

        boolean isFullEquals = this.isSetEquals(ninePalaces, whiteNinePalaces);

        assertEquals(isFullEquals, true);
    }

    private boolean isSetEquals(Set<Position> expectedPosSet, Set<Position> actualPosSet) {
        boolean isEqual = false;
        boolean isFullEqual = true;

        for (Position expectedPos : expectedPosSet) {
            for (Position actualPos : actualPosSet) {
                if (actualPos.equals(expectedPos)) {
                    isEqual = true;
                    break;
                }
            }

            if (!isEqual) {
                isFullEqual = false;
                break;
            }
            isEqual = false;
        }

        return isFullEqual;
    }
} 
