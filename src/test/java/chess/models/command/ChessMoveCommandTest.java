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

public class ChessMoveCommandTest {


    /**
    *
    * Method: execute(Board board, ChessPiece chess, Position destination)
    *
    */
    @Test
    public void execute(){
        Board board = new Board(GameMode.Classic);
        ChessMove chessMoveReceiver = new ChessMove();
        ChessMoveCommand moveCommand = new ChessMoveCommand(chessMoveReceiver);
        ChessPiece blackPawnD2 = board.getSpecificPositionChess(new Position("D2"));
        ChessPiece whitePawnE7 = board.getSpecificPositionChess(new Position("E7"));
        assertEquals(moveCommand.execute(board, blackPawnD2, new Position("D4")), MoveResult.LegalMove);
        assertEquals(moveCommand.execute(board, whitePawnE7, new Position("E5")), MoveResult.LegalMove);
        moveCommand.execute(board, blackPawnD2, new Position("D4"));
        moveCommand.execute(board, whitePawnE7, new Position("E5"));
        assertEquals(moveCommand.execute(board, blackPawnD2, new Position("E5")), MoveResult.Capture);
        assertEquals(board.getWhiteChessSet().size(), 15);

        board.print();
    }

    /**
    *
    * Method: undo(Board board)
    *
    */
    @Test
    public void undo1(){
        Board board = new Board(GameMode.Classic);
        ChessMove chessMoveReceiver = new ChessMove();
        ChessMoveCommand moveCommand = new ChessMoveCommand(chessMoveReceiver);
        ChessPiece blackPawnD2 = board.getSpecificPositionChess(new Position("D2"));
        ChessPiece whitePawnE7 = board.getSpecificPositionChess(new Position("E7"));
        moveCommand.execute(board, blackPawnD2, new Position("D4"));
        moveCommand.execute(board, whitePawnE7, new Position("E5"));
        assertEquals(board.getWhiteChessSet().size(), 16);
        board.print();
        moveCommand.undo(board);
        assertEquals(board.getWhiteChessSet().size(), 16);
        board.print();

    }

    @Test
    public void undo2(){
        Board board = new Board(GameMode.Classic);
        ChessMove chessMoveReceiver = new ChessMove();
        ChessMoveCommand moveCommand = new ChessMoveCommand(chessMoveReceiver);
        ChessPiece blackPawnD2 = board.getSpecificPositionChess(new Position("D2"));
        ChessPiece whitePawnE7 = board.getSpecificPositionChess(new Position("E7"));
        moveCommand.execute(board, blackPawnD2, new Position("D4"));
        moveCommand.execute(board, whitePawnE7, new Position("E5"));
        moveCommand.execute(board, blackPawnD2, new Position("E5"));
        assertEquals(board.getWhiteChessSet().size(), 15);
        board.print();
        moveCommand.undo(board);
        assertEquals(board.getWhiteChessSet().size(), 16);
        board.print();
    }


} 
