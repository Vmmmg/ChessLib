package chess.Piece;

import chess.Position;
import chess.enums.MoveResult;
import chess.enums.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class BishopTest {

    @Test
    public void isLegalMove() {
        Bishop bishop = new Bishop(Player.Black, new Position("F1"));
        assertEquals(bishop.isLegalMove(new Position("F1")), MoveResult.SamePosition);
        assertEquals(bishop.isLegalMove(new Position("E2")), MoveResult.LegalMove);
        assertEquals(bishop.isLegalMove(new Position("D3")), MoveResult.LegalMove);
        assertEquals(bishop.isLegalMove(new Position("C4")), MoveResult.LegalMove);
        assertEquals(bishop.isLegalMove(new Position("B5")), MoveResult.LegalMove);
        assertEquals(bishop.isLegalMove(new Position("A6")), MoveResult.LegalMove);
        assertEquals(bishop.isLegalMove(new Position("G2")), MoveResult.LegalMove);
        assertEquals(bishop.isLegalMove(new Position("H3")), MoveResult.LegalMove);
        assertEquals(bishop.isLegalMove(new Position("F2")), MoveResult.IllegalMove);
        assertEquals(bishop.isLegalMove(new Position("F3")), MoveResult.IllegalMove);
        assertEquals(bishop.isLegalMove(new Position("F4")), MoveResult.IllegalMove);
        assertEquals(bishop.isLegalMove(new Position("F5")), MoveResult.IllegalMove);
        assertEquals(bishop.isLegalMove(new Position("F6")), MoveResult.IllegalMove);
        assertEquals(bishop.isLegalMove(new Position("F7")), MoveResult.IllegalMove);
        assertEquals(bishop.isLegalMove(new Position("F8")), MoveResult.IllegalMove);
        assertEquals(bishop.isLegalMove(new Position("A1")), MoveResult.IllegalMove);
        assertEquals(bishop.isLegalMove(new Position("B1")), MoveResult.IllegalMove);
        assertEquals(bishop.isLegalMove(new Position("C1")), MoveResult.IllegalMove);
        assertEquals(bishop.isLegalMove(new Position("D1")), MoveResult.IllegalMove);
        assertEquals(bishop.isLegalMove(new Position("E1")), MoveResult.IllegalMove);
        assertEquals(bishop.isLegalMove(new Position("G1")), MoveResult.IllegalMove);
        assertEquals(bishop.isLegalMove(new Position("H1")), MoveResult.IllegalMove);
    }
}