package chess.piece;

import chess.Position;
import chess.enums.MoveResult;
import chess.enums.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {

    @Test
    public void isForward() {
        Pawn pawn1 = new Pawn(Player.Black, new Position("B2"));
        assertEquals(pawn1.isForward(new Position("B3")), true);
        assertEquals(pawn1.isForward(new Position("B1")), false);

        Pawn pawn2 = new Pawn(Player.White, new Position("B7"));
        assertEquals(pawn2.isForward(new Position("B6")), true);
        assertEquals(pawn2.isForward(new Position("B8")), false);

        Pawn pawn3 = new Pawn(Player.Black, new Position("G2"));
        assertEquals(pawn3.isForward(new Position("G3")), true);
        assertEquals(pawn3.isForward(new Position("G1")), false);

        Pawn pawn4 = new Pawn(Player.White, new Position("G7"));
        assertEquals(pawn4.isForward(new Position("G6")), true);
        assertEquals(pawn4.isForward(new Position("G8")), false);
    }

    @Test
    public void isLegalMove() {
        Pawn pawn = new Pawn(Player.Black, new Position("B2"));
        assertEquals(pawn.isLegalMove(new Position("B2")), MoveResult.SamePosition);

        assertEquals(pawn.isLegalMove(new Position("B4")), MoveResult.LegalMove);
        assertEquals(pawn.isLegalMove(new Position("B3")), MoveResult.LegalMove);
        assertEquals(pawn.isLegalMove(new Position("A3")), MoveResult.PawnDiagonally);
        assertEquals(pawn.isLegalMove(new Position("C3")), MoveResult.PawnDiagonally);

        assertEquals(pawn.isLegalMove(new Position("B1")), MoveResult.IllegalMove);
        assertEquals(pawn.isLegalMove(new Position("B5")), MoveResult.IllegalMove);
        assertEquals(pawn.isLegalMove(new Position("B6")), MoveResult.IllegalMove);
        assertEquals(pawn.isLegalMove(new Position("B7")), MoveResult.IllegalMove);
        assertEquals(pawn.isLegalMove(new Position("B8")), MoveResult.IllegalMove);
        assertEquals(pawn.isLegalMove(new Position("A2")), MoveResult.IllegalMove);
        assertEquals(pawn.isLegalMove(new Position("C2")), MoveResult.IllegalMove);
        assertEquals(pawn.isLegalMove(new Position("D2")), MoveResult.IllegalMove);
        assertEquals(pawn.isLegalMove(new Position("E2")), MoveResult.IllegalMove);

        pawn.move(new Position("B4"));

        assertEquals(pawn.isLegalMove(new Position("B4")), MoveResult.SamePosition);

        assertEquals(pawn.isLegalMove(new Position("B5")), MoveResult.LegalMove);
        assertEquals(pawn.isLegalMove(new Position("A5")), MoveResult.PawnDiagonally);
        assertEquals(pawn.isLegalMove(new Position("C5")), MoveResult.PawnDiagonally);

        assertEquals(pawn.isLegalMove(new Position("B3")), MoveResult.IllegalMove);
        assertEquals(pawn.isLegalMove(new Position("B2")), MoveResult.IllegalMove);
        assertEquals(pawn.isLegalMove(new Position("B1")), MoveResult.IllegalMove);
        assertEquals(pawn.isLegalMove(new Position("B6")), MoveResult.IllegalMove);
        assertEquals(pawn.isLegalMove(new Position("B7")), MoveResult.IllegalMove);
        assertEquals(pawn.isLegalMove(new Position("B8")), MoveResult.IllegalMove);
    }
}