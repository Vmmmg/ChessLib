package chess.piece;

import chess.Position;
import chess.enums.MoveResult;
import chess.enums.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class KnightTest {

    @Test
    public void isLegalMove() {
        Knight knight = new Knight(Player.Black, new Position("B1"));
        assertEquals(knight.isLegalMove(new Position("B1")), MoveResult.SamePosition);

        assertEquals(knight.isLegalMove(new Position("A3")), MoveResult.LegalMove);
        assertEquals(knight.isLegalMove(new Position("C3")), MoveResult.LegalMove);
        assertEquals(knight.isLegalMove(new Position("D2")), MoveResult.LegalMove);

        assertEquals(knight.isLegalMove(new Position("A1")), MoveResult.IllegalMove);
        assertEquals(knight.isLegalMove(new Position("A2")), MoveResult.IllegalMove);
        assertEquals(knight.isLegalMove(new Position("A4")), MoveResult.IllegalMove);
        assertEquals(knight.isLegalMove(new Position("B2")), MoveResult.IllegalMove);
        assertEquals(knight.isLegalMove(new Position("B3")), MoveResult.IllegalMove);
        assertEquals(knight.isLegalMove(new Position("B4")), MoveResult.IllegalMove);
        assertEquals(knight.isLegalMove(new Position("C1")), MoveResult.IllegalMove);
        assertEquals(knight.isLegalMove(new Position("C2")), MoveResult.IllegalMove);
        assertEquals(knight.isLegalMove(new Position("C4")), MoveResult.IllegalMove);
        assertEquals(knight.isLegalMove(new Position("D1")), MoveResult.IllegalMove);
        assertEquals(knight.isLegalMove(new Position("D3")), MoveResult.IllegalMove);
        assertEquals(knight.isLegalMove(new Position("D4")), MoveResult.IllegalMove);
    }
}