package chess;

import chess.Piece.*;
import chess.enums.GameResult;
import chess.enums.MoveResult;
import chess.enums.Player;

public class Board {
    private int HEIGHT = 8;
    private int WIDTH = 8;
    private Chess[][] board = new Chess[WIDTH][HEIGHT];
    private Position whiteKingPos = new Position("E8");
    private Position blackKingPos = new Position("E1");

    public Board(){
        init();
    }

    public void init(){
        board[0][0] = new Rook(Player.Black, new Position("A1"));
        board[0][1] = new Knight(Player.Black, new Position("B1"));
        board[0][2] = new Bishop(Player.Black, new Position("C1"));
        board[0][3] = new Queen(Player.Black, new Position("D1"));
        board[0][4] = new King(Player.Black, new Position("E1"));
        board[0][5] = new Bishop(Player.Black, new Position("F1"));
        board[0][6] = new Knight(Player.Black, new Position("G1"));
        board[0][7] = new Rook(Player.Black, new Position("H1"));
        board[1][0] = new Pawn(Player.Black, new Position("A2"));
        board[1][1] = new Pawn(Player.Black, new Position("B2"));
        board[1][2] = new Pawn(Player.Black, new Position("C2"));
        board[1][3] = new Pawn(Player.Black, new Position("D2"));
        board[1][4] = new Pawn(Player.Black, new Position("E2"));
        board[1][5] = new Pawn(Player.Black, new Position("F2"));
        board[1][6] = new Pawn(Player.Black, new Position("G2"));
        board[1][7] = new Pawn(Player.Black, new Position("H2"));
        board[7][0] = new Rook(Player.White, new Position("A8"));
        board[7][1] = new Knight(Player.White, new Position("B8"));
        board[7][2] = new Bishop(Player.White, new Position("C8"));
        board[7][3] = new Queen(Player.White, new Position("D8"));
        board[7][4] = new King(Player.White, new Position("E8"));
        board[7][5] = new Bishop(Player.White, new Position("F8"));
        board[7][6] = new Knight(Player.White, new Position("G8"));
        board[7][7] = new Rook(Player.White, new Position("H8"));
        board[6][0] = new Pawn(Player.White, new Position("A7"));
        board[6][1] = new Pawn(Player.White, new Position("B7"));
        board[6][2] = new Pawn(Player.White, new Position("C7"));
        board[6][3] = new Pawn(Player.White, new Position("D7"));
        board[6][4] = new Pawn(Player.White, new Position("E7"));
        board[6][5] = new Pawn(Player.White, new Position("F7"));
        board[6][6] = new Pawn(Player.White, new Position("G7"));
        board[6][7] = new Pawn(Player.White, new Position("H7"));

    }

    public MoveResult isLegalMove(Chess chess, Position pos){
        //check if the new position off the board
        int x = pos.getX();
        int y = pos.getY();
        if(x > this.WIDTH){
            return MoveResult.OffTheBoard;
        }
        else if(y > this.HEIGHT){
            return MoveResult.OffTheBoard;
        }

        //check if the new position is occupied by the same player's pieces
        if(board[y][x] != null){
            if(board[y][x].getPlayer() == chess.getPlayer()){
                return MoveResult.IllegalMove;
            }
        }

        //check if the movement is legal
        MoveResult chessMoveRes = chess.isLegalMove(pos);
        MoveResult moveResult = null;
        if(chessMoveRes == MoveResult.LegalMove){
            if(chess instanceof Knight){
                this.chessMove(chess, pos);
            }
            else{
                //check if the piece leap over other pieces
                if(isOverPiece(chess, pos)){
                    return MoveResult.OverOtherPieces;
                }
                else{
                    this.chessMove(chess, pos);
                }
            }
        }
        else if(chessMoveRes == MoveResult.PawnDiagonally){
            if(board[y][x] != null){
                this.chessMove(chess, pos);
            }
            else{
                moveResult = MoveResult.IllegalMove;
            }
        }
        else{
            moveResult = chessMoveRes;
        }

        return moveResult;
    }

    public boolean isOverPiece(Chess chess, Position pos){
        if(chess instanceof King){
            return false;
        }

        Position chessPos = chess.getPosition();
        int startPoint;
        int endPoint;

        if(chessPos.isHorizontal(pos)){
            int chessY = chessPos.getY();
            if(chessPos.getX() < pos.getX()){
                startPoint = chessPos.getX() + 1;
                endPoint = pos.getX();
            }
            else{
                startPoint = pos.getX() + 1;
                endPoint = chessPos.getX();
            }

            for(int i = startPoint; i < endPoint; i++){
                if(board[chessY][i] != null){
                    return true;
                }
            }
        }
        else if(chessPos.isVertical(pos)){
            int chessX = chessPos.getX();
            if(chessPos.getY() < pos.getY()){
                startPoint = chessPos.getY() + 1;
                endPoint = pos.getY();
            }
            else{
                startPoint = pos.getY() + 1;
                endPoint = chessPos.getY();
            }

            for(int i = startPoint; i < endPoint; i++){
                if(board[i][chessX] != null){
                    return true;
                }
            }
        }
        else if(chessPos.isDiagonal(pos)){
            int startX, endX, startY, endY;

            if(chessPos.getX() < pos.getY()){
                startPoint = chessPos.getY() + 1;
                endPoint = pos.getY();
            }
            else{
                startPoint = pos.getY() + 1;
                endPoint = chessPos.getY();
            }
        }

        return false;
    }

    public MoveResult chessMove(Chess chess, Position pos){
        Position prePos = chess.getPosition();
        int preX = prePos.getX();
        int preY = prePos.getY();
        int x = pos.getX();
        int y = pos.getY();

        chess.move(pos);
        if (chess instanceof King){
            if(chess.getPlayer() == Player.Black){
                blackKingPos = pos;
            }
            else{
                whiteKingPos = pos;
            }
        }
        board[preY][preX] = null;
        if(board[y][x] != null){
            Chess capturedChess = board[y][x];
            if(capturedChess instanceof King){
                if(capturedChess.getPlayer() == Player.Black){
                    blackKingPos = null;
                }
                else{
                    whiteKingPos = null;
                }
            }
            board[y][x] = chess;
            return MoveResult.Capture;
        }
        board[y][x] = chess;
        return MoveResult.LegalMove;
    }

    public GameResult judge(){
        GameResult res = GameResult.Gaming;

        if(whiteKingPos == null){
            return GameResult.BlackWin;
        }
        else if(blackKingPos == null){
            return GameResult.WhiteWin;
        }

        //平局

        return res;
    }
}
