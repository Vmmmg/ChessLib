package chess.pieces;

import chess.models.Position;
import chess.models.enums.MoveResult;
import chess.models.enums.Player;
import chess.models.pieces.Queen;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueenTest {

    @Test
    public void isLegalMove() {
        Queen queen = new Queen(Player.Black, new Position("D1"));
        assertEquals(queen.isLegalMove(new Position("D1")), MoveResult.SamePosition);

        assertEquals(queen.isLegalMove(new Position("A1")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("B1")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("C1")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("E1")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("F1")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("G1")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("H1")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("D2")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("D3")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("D4")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("D5")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("D6")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("D7")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("D8")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("C2")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("B3")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("A4")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("E2")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("F3")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("G4")), MoveResult.LegalMove);
        assertEquals(queen.isLegalMove(new Position("H5")), MoveResult.LegalMove);

        assertEquals(queen.isLegalMove(new Position("A2")), MoveResult.IllegalMove);
        assertEquals(queen.isLegalMove(new Position("B2")), MoveResult.IllegalMove);
        assertEquals(queen.isLegalMove(new Position("G8")), MoveResult.IllegalMove);
        assertEquals(queen.isLegalMove(new Position("F2")), MoveResult.IllegalMove);
        assertEquals(queen.isLegalMove(new Position("F2")), MoveResult.IllegalMove);
        assertEquals(queen.isLegalMove(new Position("G2")), MoveResult.IllegalMove);
        assertEquals(queen.isLegalMove(new Position("H2")), MoveResult.IllegalMove);
        assertEquals(queen.isLegalMove(new Position("A3")), MoveResult.IllegalMove);
        assertEquals(queen.isLegalMove(new Position("C3")), MoveResult.IllegalMove);
        assertEquals(queen.isLegalMove(new Position("H3")), MoveResult.IllegalMove);
        assertEquals(queen.isLegalMove(new Position("E3")), MoveResult.IllegalMove);
    }
}