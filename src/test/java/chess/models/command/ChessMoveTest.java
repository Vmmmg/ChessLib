package chess.models.command; 

import chess.models.Board;
import chess.models.ChessPiece;
import chess.models.Position;
import chess.models.enums.GameMode;
import chess.models.enums.MoveResult;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;

public class ChessMoveTest {
    private Board board;
    private ChessMove chessMoveReceiver;

    @Before
    public void setUp() {
        board = new Board(GameMode.Classic);
        chessMoveReceiver = new ChessMove();
    }

    /**
    *
    * Method: move(Board board, ChessPiece chess, Position destination)
    *
    */
    @Test
    public void move() throws Exception {
        ChessPiece blackPawnD2 = board.getSpecificPositionChess(new Position("D2"));
        ChessPiece whitePawnE7 = board.getSpecificPositionChess(new Position("E7"));
        assertEquals(chessMoveReceiver.move(board, blackPawnD2, new Position("D4")), MoveResult.LegalMove);
        assertEquals(chessMoveReceiver.move(board, whitePawnE7, new Position("E5")), MoveResult.LegalMove);
        chessMoveReceiver.move(board, blackPawnD2, new Position("D4"));
        chessMoveReceiver.move(board, whitePawnE7, new Position("E5"));
        assertEquals(chessMoveReceiver.move(board, blackPawnD2, new Position("E5")), MoveResult.Capture);
        assertEquals(board.getWhiteChessSet().size(), 15);

        board.print();
    }


} 
