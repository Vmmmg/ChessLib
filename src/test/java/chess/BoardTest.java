package chess;

import chess.enums.GameResult;
import chess.enums.MoveResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void init() {
        board.print();

    }

    @Test
    public void isLegalMove() {
        Chess blackKing = board.getSpecificPositionChess(new Position("E1"));
        assertEquals(board.isLegalMove(blackKing, new Position("E6")), MoveResult.IllegalMove);
    }

    @Test
    public void chessMove() {

    }

    @Test
    public void judge() {
        assertEquals(board.judge(), GameResult.Gaming);
    }
}