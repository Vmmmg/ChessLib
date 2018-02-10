package chess.models.pieces;

import chess.models.Position;
import chess.models.enums.MoveResult;
import chess.models.enums.Player;
import chess.models.pieces.King;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KingTest {

    @Test
    public void isLegalMove() {
        King king = new King(Player.Black, new Position("E1"));
        assertEquals(king.isLegalMove(new Position("E1")), MoveResult.SamePosition);

        assertEquals(king.isLegalMove(new Position("D1")), MoveResult.LegalMove);
        assertEquals(king.isLegalMove(new Position("F1")), MoveResult.LegalMove);
        assertEquals(king.isLegalMove(new Position("D2")), MoveResult.LegalMove);
        assertEquals(king.isLegalMove(new Position("E2")), MoveResult.LegalMove);
        assertEquals(king.isLegalMove(new Position("F2")), MoveResult.LegalMove);

        assertEquals(king.isLegalMove(new Position("A1")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("B1")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("C1")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("G1")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("H1")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("A2")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("B2")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("C2")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("G2")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("H2")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("A3")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("B3")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("C3")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("D3")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("E3")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("F3")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("G3")), MoveResult.IllegalMove);
        assertEquals(king.isLegalMove(new Position("H3")), MoveResult.IllegalMove);
    }
}