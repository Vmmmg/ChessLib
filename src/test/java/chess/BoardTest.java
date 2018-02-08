package chess;

import chess.models.Board;
import chess.models.ChessPiece;
import chess.models.Position;
import chess.models.enums.GameResult;
import chess.models.enums.MoveResult;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void init() {
        board.print();
    }

    @Test
    public void isLegalMove() {
        ChessPiece blackQueen = board.getSpecificPositionChess(new Position("D1"));
        ChessPiece blackPawn = board.getSpecificPositionChess(new Position("D2"));

        assertEquals(board.isLegalMove(blackQueen, new Position("D0")), MoveResult.OffTheBoard);
        assertEquals(board.isLegalMove(blackQueen, new Position("D9")), MoveResult.OffTheBoard);
        assertEquals(board.isLegalMove(blackQueen, new Position("I1")), MoveResult.OffTheBoard);
        assertEquals(board.isLegalMove(blackQueen, new Position(-1, 0)), MoveResult.OffTheBoard);

        assertEquals(board.isLegalMove(blackPawn, new Position("D3")), MoveResult.LegalMove);
        assertEquals(board.isLegalMove(blackQueen, new Position("C3")), MoveResult.IllegalMove);
        assertEquals(board.isLegalMove(blackQueen, new Position("D3")), MoveResult.OverOtherPieces);

        board.print();
    }

    @Test
    public void isOverPiece() {
        ChessPiece blackQueen = board.getSpecificPositionChess(new Position("D1"));
        ChessPiece blackBishop = board.getSpecificPositionChess(new Position("C1"));
        ChessPiece blackPawnD2 = board.getSpecificPositionChess(new Position("D2"));
        ChessPiece blackPawnC2 = board.getSpecificPositionChess(new Position("C2"));
        ChessPiece blackPawnE2 = board.getSpecificPositionChess(new Position("E2"));

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

        board.print();
    }

    @Test
    public void chessMove() {
        ChessPiece blackPawnD2 = board.getSpecificPositionChess(new Position("D2"));
        ChessPiece whitePawnE7 = board.getSpecificPositionChess(new Position("E7"));
        assertEquals(board.chessMove(blackPawnD2, new Position("D4")), MoveResult.LegalMove);
        assertEquals(board.chessMove(whitePawnE7, new Position("E5")), MoveResult.LegalMove);
        board.chessMove(blackPawnD2, new Position("D4"));
        board.chessMove(whitePawnE7, new Position("E5"));
        assertEquals(board.chessMove(blackPawnD2, new Position("E5")), MoveResult.Capture);
        assertEquals(board.getWhiteChessSet().size(), 15);

        board.print();
    }

    @Test
    public void judge1() {
        assertEquals(board.judge(), GameResult.Gaming);
    }

    @Test
    public void judge2() {
        ChessPiece blackRook1 = board.getSpecificPositionChess(new Position("A1"));
        ChessPiece blackRook2 = board.getSpecificPositionChess(new Position("H1"));
        board.chessMove(blackRook1, new Position("A7"));
        board.chessMove(blackRook1, new Position("B7"));
        board.chessMove(blackRook1, new Position("C7"));
        board.chessMove(blackRook1, new Position("D7"));
        board.chessMove(blackRook1, new Position("E7"));
        board.chessMove(blackRook1, new Position("F7"));
        board.chessMove(blackRook1, new Position("G7"));
        board.chessMove(blackRook1, new Position("H7"));
        board.chessMove(blackRook1, new Position("H8"));
        board.chessMove(blackRook1, new Position("G8"));
        board.chessMove(blackRook1, new Position("F8"));
        board.chessMove(blackRook1, new Position("D8"));
        board.chessMove(blackRook1, new Position("C8"));
        board.chessMove(blackRook1, new Position("B8"));
        board.chessMove(blackRook1, new Position("A8"));
        board.chessMove(blackRook2, new Position("H7"));

        assertEquals(board.judge(), GameResult.BlackWin);
    }

    @Test
    public void judge3() {
        ChessPiece blackRook = board.getSpecificPositionChess(new Position("A1"));
        board.chessMove(blackRook, new Position("A7"));
        board.chessMove(blackRook, new Position("B7"));
        board.chessMove(blackRook, new Position("C7"));
        board.chessMove(blackRook, new Position("D7"));
        board.chessMove(blackRook, new Position("E7"));
        board.chessMove(blackRook, new Position("F7"));
        board.chessMove(blackRook, new Position("G7"));
        board.chessMove(blackRook, new Position("H7"));
        board.chessMove(blackRook, new Position("F8"));
        board.chessMove(blackRook, new Position("D8"));
        board.chessMove(blackRook, new Position("C8"));
        board.chessMove(blackRook, new Position("A1"));
        ChessPiece whiteKnight1 = board.getSpecificPositionChess(new Position("B8"));
        board.chessMove(whiteKnight1, new Position("A2"));
        board.chessMove(whiteKnight1, new Position("B2"));
        board.chessMove(whiteKnight1, new Position("C2"));
        board.chessMove(whiteKnight1, new Position("D2"));
        board.chessMove(whiteKnight1, new Position("E2"));
        board.chessMove(whiteKnight1, new Position("F2"));
        board.chessMove(whiteKnight1, new Position("G2"));
        board.chessMove(whiteKnight1, new Position("H2"));
        board.chessMove(whiteKnight1, new Position("H1"));
        board.chessMove(whiteKnight1, new Position("G1"));
        board.chessMove(whiteKnight1, new Position("F1"));
        board.chessMove(whiteKnight1, new Position("D1"));
        board.chessMove(whiteKnight1, new Position("C1"));
        board.chessMove(whiteKnight1, new Position("B1"));
        board.chessMove(whiteKnight1, new Position("A1"));
        board.chessMove(whiteKnight1, new Position("F3"));
        board.chessMove(whiteKnight1, new Position("G3"));
        ChessPiece whiteKnight2 = board.getSpecificPositionChess(new Position("G8"));
        board.chessMove(whiteKnight2, new Position("B2"));
        ChessPiece whiteRook1 = board.getSpecificPositionChess(new Position("A8"));
        board.chessMove(whiteRook1, new Position("E6"));
        ChessPiece whiteRook2 = board.getSpecificPositionChess(new Position("H8"));
        board.chessMove(whiteRook2, new Position("H2"));
        board.print();
        assertEquals(board.judge(), GameResult.WhiteWin);
    }

    @Test
    public void judge4() {
        ChessPiece blackKing = board.getSpecificPositionChess(new Position("E1"));
        ChessPiece blackPawn = board.getSpecificPositionChess(new Position("A2"));
        ChessPiece whitePawn = board.getSpecificPositionChess(new Position("A7"));
        ChessPiece whiteQueen = board.getSpecificPositionChess(new Position("D8"));
        ChessPiece whiteKing = board.getSpecificPositionChess(new Position("E8"));
        board.chessMove(blackPawn, new Position("B7"));
        board.chessMove(blackPawn, new Position("C7"));
        board.chessMove(blackPawn, new Position("D7"));
        board.chessMove(blackPawn, new Position("E7"));
        board.chessMove(blackPawn, new Position("F7"));
        board.chessMove(blackPawn, new Position("G7"));
        board.chessMove(blackPawn, new Position("H7"));
        board.chessMove(blackPawn, new Position("H8"));
        board.chessMove(blackPawn, new Position("G8"));
        board.chessMove(blackPawn, new Position("F8"));
        board.chessMove(blackPawn, new Position("C8"));
        board.chessMove(blackPawn, new Position("B8"));
        board.chessMove(blackPawn, new Position("A8"));
        board.chessMove(whitePawn, new Position("B2"));
        board.chessMove(whitePawn, new Position("C2"));
        board.chessMove(whitePawn, new Position("D2"));
        board.chessMove(whitePawn, new Position("E2"));
        board.chessMove(whitePawn, new Position("F2"));
        board.chessMove(whitePawn, new Position("G2"));
        board.chessMove(whitePawn, new Position("H2"));
        board.chessMove(whitePawn, new Position("H1"));
        board.chessMove(whitePawn, new Position("G1"));
        board.chessMove(whitePawn, new Position("F1"));
        board.chessMove(whitePawn, new Position("D1"));
        board.chessMove(whitePawn, new Position("C1"));
        board.chessMove(whitePawn, new Position("B1"));
        board.chessMove(whitePawn, new Position("A1"));

        board.chessMove(blackPawn, new Position("B3"));
        board.chessMove(whitePawn, new Position("B4"));
        board.chessMove(blackKing, new Position("H1"));
        board.chessMove(whiteKing, new Position("G7"));
        board.chessMove(whiteQueen, new Position("F2"));

        board.print();

        assertEquals(board.judge(), GameResult.Draw);
    }
}