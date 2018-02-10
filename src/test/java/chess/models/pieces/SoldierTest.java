package chess.models.pieces; 

import chess.models.Position;
import chess.models.enums.MoveResult;
import chess.models.enums.Player;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;

public class SoldierTest {

    /**
    *
    * Method: isLegalMove(Position pos)
    *
    */
    @Test
    public void isLegalMove() {
        Soldier blackSoldier1 = new Soldier(Player.Black, new Position("B4"));
        assertEquals(blackSoldier1.isLegalMove(new Position("B4")), MoveResult.SamePosition);
        assertEquals(blackSoldier1.isLegalMove(new Position("B5")), MoveResult.LegalMove);
        assertEquals(blackSoldier1.isLegalMove(new Position("B6")), MoveResult.IllegalMove);
        assertEquals(blackSoldier1.isLegalMove(new Position("C5")), MoveResult.IllegalMove);
        assertEquals(blackSoldier1.isLegalMove(new Position("C4")), MoveResult.IllegalMove);

        Soldier blackSoldier2 = new Soldier(Player.Black, new Position("B5"));
        assertEquals(blackSoldier2.isLegalMove(new Position("B5")), MoveResult.SamePosition);
        assertEquals(blackSoldier2.isLegalMove(new Position("B6")), MoveResult.LegalMove);
        assertEquals(blackSoldier2.isLegalMove(new Position("C5")), MoveResult.LegalMove);
        assertEquals(blackSoldier2.isLegalMove(new Position("B4")), MoveResult.IllegalMove);
        assertEquals(blackSoldier2.isLegalMove(new Position("B7")), MoveResult.IllegalMove);
        assertEquals(blackSoldier2.isLegalMove(new Position("D5")), MoveResult.IllegalMove);
        assertEquals(blackSoldier2.isLegalMove(new Position("C6")), MoveResult.IllegalMove);

        Soldier whiteSoldier1 = new Soldier(Player.White, new Position("B5"));
        assertEquals(whiteSoldier1.isLegalMove(new Position("B5")), MoveResult.SamePosition);
        assertEquals(whiteSoldier1.isLegalMove(new Position("B4")), MoveResult.LegalMove);
        assertEquals(whiteSoldier1.isLegalMove(new Position("B3")), MoveResult.IllegalMove);
        assertEquals(whiteSoldier1.isLegalMove(new Position("C5")), MoveResult.IllegalMove);
        assertEquals(whiteSoldier1.isLegalMove(new Position("C4")), MoveResult.IllegalMove);

        Soldier whiteSoldier2 = new Soldier(Player.White, new Position("B4"));
        assertEquals(whiteSoldier2.isLegalMove(new Position("B4")), MoveResult.SamePosition);
        assertEquals(whiteSoldier2.isLegalMove(new Position("B3")), MoveResult.LegalMove);
        assertEquals(whiteSoldier2.isLegalMove(new Position("C4")), MoveResult.LegalMove);
        assertEquals(whiteSoldier2.isLegalMove(new Position("B5")), MoveResult.IllegalMove);
        assertEquals(whiteSoldier2.isLegalMove(new Position("B2")), MoveResult.IllegalMove);
        assertEquals(whiteSoldier2.isLegalMove(new Position("D4")), MoveResult.IllegalMove);
        assertEquals(whiteSoldier2.isLegalMove(new Position("C3")), MoveResult.IllegalMove);
    }

    /**
    *
    * Method: isForward(Position pos)
    *
    */
    @Test
    public void isForward() {
        Soldier blackSoldier = new Soldier(Player.Black, new Position("B2"));
        assertEquals(blackSoldier.isForward(new Position("B3")), true);
        assertEquals(blackSoldier.isForward(new Position("B1")), false);

        Soldier whiteSoldier = new Soldier(Player.White, new Position("B7"));
        assertEquals(whiteSoldier.isForward(new Position("B6")), true);
        assertEquals(whiteSoldier.isForward(new Position("B8")), false);

    }

    /**
    *
    * Method: isCrossTheRiver()
    *
    */
    @Test
    public void isCrossTheRiver() {
        Soldier blackSoldier1 = new Soldier(Player.Black, new Position("B4"));
        assertEquals(blackSoldier1.isCrossTheRiver(), false);
        Soldier blackSoldier2 = new Soldier(Player.Black, new Position("B5"));
        assertEquals(blackSoldier2.isCrossTheRiver(), true);
        Soldier whiteSoldier1 = new Soldier(Player.White, new Position("B5"));
        assertEquals(whiteSoldier1.isCrossTheRiver(), false);
        Soldier whiteSoldier2 = new Soldier(Player.White, new Position("B4"));
        assertEquals(whiteSoldier2.isCrossTheRiver(), true);
    }


} 
