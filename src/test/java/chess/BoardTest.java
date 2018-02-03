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
        Chess blackQueen = board.getSpecificPositionChess(new Position("D1"));
        Chess blackPawn = board.getSpecificPositionChess(new Position("D2"));

        assertEquals(board.isLegalMove(blackQueen, new Position("D0")), MoveResult.OffTheBoard);
        assertEquals(board.isLegalMove(blackQueen, new Position("D9")), MoveResult.OffTheBoard);
        assertEquals(board.isLegalMove(blackQueen, new Position("I1")), MoveResult.OffTheBoard);
        assertEquals(board.isLegalMove(blackQueen, new Position(-1, 0)), MoveResult.OffTheBoard);

        assertEquals(board.isLegalMove(blackPawn, new Position("D3")), MoveResult.LegalMove);
        assertEquals(board.isLegalMove(blackQueen, new Position("C3")), MoveResult.IllegalMove);
        assertEquals(board.isLegalMove(blackQueen, new Position("D3")), MoveResult.OverOtherPieces);
    }

    @Test
    public void isOverPiece(){
        Chess blackQueen = board.getSpecificPositionChess(new Position("D1"));
        Chess blackBishop = board.getSpecificPositionChess(new Position("C1"));
        Chess blackPawnD2 = board.getSpecificPositionChess(new Position("D2"));
        Chess blackPawnC2 = board.getSpecificPositionChess(new Position("C2"));
        Chess blackPawnE2 = board.getSpecificPositionChess(new Position("E2"));

        assertEquals(board.isOverPiece(blackQueen, new Position("B3")), true);
        assertEquals(board.isOverPiece(blackQueen, new Position("D3")), true);
        assertEquals(board.isOverPiece(blackQueen, new Position("F3")), true);
        assertEquals(board.isOverPiece(blackQueen, new Position("B1")), true);

        board.chessMove(blackPawnD2, new Position("D4"));
        assertEquals(board.isOverPiece(blackQueen, new Position("D3")), false);
        board.chessMove(blackPawnC2, new Position("C4"));
        assertEquals(board.isOverPiece(blackQueen, new Position("B3")), false);
        board.chessMove(blackPawnE2, new Position("E4"));
        assertEquals(board.isOverPiece(blackQueen, new Position("F3")), false);
        board.chessMove(blackBishop, new Position("D2"));
        assertEquals(board.isOverPiece(blackQueen, new Position("B1")), false);

        board.chessMove(blackPawnD2, new Position("D2"));
        board.chessMove(blackPawnC2, new Position("C2"));
        board.chessMove(blackPawnE2, new Position("E2"));
        board.chessMove(blackBishop, new Position("C1"));

    }

    @Test
    public void chessMove() {
        Chess blackPawnD2 = board.getSpecificPositionChess(new Position("D2"));
        Chess whitePawnE7 = board.getSpecificPositionChess(new Position("E7"));
        assertEquals(board.chessMove(blackPawnD2, new Position("D4")), MoveResult.LegalMove);
        assertEquals(board.chessMove(whitePawnE7, new Position("E7")), MoveResult.LegalMove);
        board.chessMove(blackPawnD2, new Position("D4"));
        board.chessMove(whitePawnE7, new Position("E5"));
        assertEquals(board.chessMove(blackPawnD2, new Position("E5")), MoveResult.Capture);
        board.chessMove(blackPawnD2, new Position("D2"));
        board.chessMove(whitePawnE7, new Position("E7"));
    }

    @Test
    public void canKingMove(){
        Chess blackKing = board.getSpecificPositionChess(new Position("E1"));
        Chess blackPawnE2 = board.getSpecificPositionChess(new Position("E2"));
        assertEquals(board.canKingMove(blackKing), false);
        board.chessMove(blackPawnE2, new Position("E3"));
        assertEquals(board.canKingMove(blackKing), true);
        board.chessMove(blackPawnE2, new Position("E2"));
    }

    @Test
    public void judge() {
        assertEquals(board.judge(), GameResult.Gaming);

        Chess blackKnight = board.getSpecificPositionChess(new Position("B1"));
        board.chessMove(blackKnight, new Position("C6"));
        assertEquals(board.judge(), GameResult.Draw);

        Chess whiteQueen = board.getSpecificPositionChess(new Position("E8"));
        Chess blackQueen = board.getSpecificPositionChess(new Position("D1"));
        board.chessMove(whiteQueen, new Position("E1"));
        assertEquals(board.judge(), GameResult.WhiteWin);
        board.chessMove(blackQueen, new Position("D8"));
        assertEquals(board.judge(), GameResult.BlackWin);


    }
}