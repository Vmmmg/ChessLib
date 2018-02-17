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

/** 
* RequestChessMove Tester. 
* 
* @author <Authors name> 
* @since <pre>¶þÔÂ 17, 2018</pre> 
* @version 1.0 
*/ 
public class RequestChessMoveTest {
    private Board board;
    private ChessMove chessMoveReceiver;
    private ChessMoveCommand moveCommand;
    private RequestChessMove chessMoveInvoker;

    @Before
    public void setUp() {
        board = new Board(GameMode.Classic);
        chessMoveReceiver = new ChessMove();
        moveCommand = new ChessMoveCommand(chessMoveReceiver);
        chessMoveInvoker = new RequestChessMove();
        chessMoveInvoker.setMoveCommand(moveCommand);
    }

    /**
    *
    * Method: executeMoveCommand(Board board, ChessPiece chess, Position destination)
    *
    */
    @Test
    public void executeMoveCommand() {
        ChessPiece blackPawnD2 = board.getSpecificPositionChess(new Position("D2"));
        ChessPiece whitePawnE7 = board.getSpecificPositionChess(new Position("E7"));
        assertEquals(chessMoveInvoker.executeMoveCommand(board, blackPawnD2, new Position("D4")), MoveResult.LegalMove);
        assertEquals(chessMoveInvoker.executeMoveCommand(board, whitePawnE7, new Position("E5")), MoveResult.LegalMove);
        chessMoveInvoker.executeMoveCommand(board, blackPawnD2, new Position("D4"));
        chessMoveInvoker.executeMoveCommand(board, whitePawnE7, new Position("E5"));
        assertEquals(chessMoveInvoker.executeMoveCommand(board, blackPawnD2, new Position("E5")), MoveResult.Capture);
        assertEquals(board.getWhiteChessSet().size(), 15);

        board.print();
    }

    /**
    *
    * Method: undoMoveCommand(Board board)
    *
    */
    @Test
    public void undoMoveCommand1() {
        ChessPiece blackPawnD2 = board.getSpecificPositionChess(new Position("D2"));
        ChessPiece whitePawnE7 = board.getSpecificPositionChess(new Position("E7"));
        chessMoveInvoker.executeMoveCommand(board, blackPawnD2, new Position("D4"));
        chessMoveInvoker.executeMoveCommand(board, whitePawnE7, new Position("E5"));
        assertEquals(board.getWhiteChessSet().size(), 16);
        board.print();
        chessMoveInvoker.undoMoveCommand(board);
        assertEquals(board.getWhiteChessSet().size(), 16);
        board.print();
    }

    @Test
    public void undoMoveCommand2(){
        ChessPiece blackPawnD2 = board.getSpecificPositionChess(new Position("D2"));
        ChessPiece whitePawnE7 = board.getSpecificPositionChess(new Position("E7"));
        chessMoveInvoker.executeMoveCommand(board, blackPawnD2, new Position("D4"));
        chessMoveInvoker.executeMoveCommand(board, whitePawnE7, new Position("E5"));
        chessMoveInvoker.executeMoveCommand(board, blackPawnD2, new Position("E5"));
        assertEquals(board.getWhiteChessSet().size(), 15);
        board.print();
        chessMoveInvoker.undoMoveCommand(board);
        assertEquals(board.getWhiteChessSet().size(), 16);
        board.print();
    }

} 
