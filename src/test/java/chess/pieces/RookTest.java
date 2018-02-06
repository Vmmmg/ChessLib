package chess.pieces;

import chess.models.Position;
import chess.models.enums.MoveResult;
import chess.models.enums.Player;
import chess.models.pieces.Rook;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RookTest {

    @Test
    public void isLegalMove() {
        Rook rook = new Rook(Player.Black, new Position("A1"));
        assertEquals(rook.isLegalMove(new Position("A1")), MoveResult.SamePosition);

        assertEquals(rook.isLegalMove(new Position("A2")), MoveResult.LegalMove);
        assertEquals(rook.isLegalMove(new Position("A3")), MoveResult.LegalMove);
        assertEquals(rook.isLegalMove(new Position("A4")), MoveResult.LegalMove);
        assertEquals(rook.isLegalMove(new Position("A5")), MoveResult.LegalMove);
        assertEquals(rook.isLegalMove(new Position("A6")), MoveResult.LegalMove);
        assertEquals(rook.isLegalMove(new Position("A7")), MoveResult.LegalMove);
        assertEquals(rook.isLegalMove(new Position("A8")), MoveResult.LegalMove);
        assertEquals(rook.isLegalMove(new Position("B1")), MoveResult.LegalMove);
        assertEquals(rook.isLegalMove(new Position("C1")), MoveResult.LegalMove);
        assertEquals(rook.isLegalMove(new Position("D1")), MoveResult.LegalMove);
        assertEquals(rook.isLegalMove(new Position("E1")), MoveResult.LegalMove);
        assertEquals(rook.isLegalMove(new Position("F1")), MoveResult.LegalMove);
        assertEquals(rook.isLegalMove(new Position("G1")), MoveResult.LegalMove);
        assertEquals(rook.isLegalMove(new Position("H1")), MoveResult.LegalMove);

        assertEquals(rook.isLegalMove(new Position("B2")), MoveResult.IllegalMove);
        assertEquals(rook.isLegalMove(new Position("C2")), MoveResult.IllegalMove);
        assertEquals(rook.isLegalMove(new Position("D2")), MoveResult.IllegalMove);
        assertEquals(rook.isLegalMove(new Position("B3")), MoveResult.IllegalMove);
        assertEquals(rook.isLegalMove(new Position("C3")), MoveResult.IllegalMove);
        assertEquals(rook.isLegalMove(new Position("D3")), MoveResult.IllegalMove);
    }
}