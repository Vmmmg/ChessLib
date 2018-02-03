package chess;

import chess.enums.GameResult;
import chess.enums.MoveResult;
import chess.enums.Player;
import chess.pieces.*;

import java.util.List;

/**
 * Board, contains the shape and size of chess board, all chess pieces and the judgement of game ending
 */
public class Board {

    private int HEIGHT = 8;
    private int WIDTH = 8;
    private ChessPiece[][] board = new ChessPiece[WIDTH][HEIGHT];
    private Position whiteKingPos = new Position("D8");
    private Position blackKingPos = new Position("E1");
    private Player curPlayer = Player.White;

    public Board() {
        init();
    }

    private void init() {
        board[0][0] = new Rook(Player.Black, new Position("A1"));
        board[0][1] = new Knight(Player.Black, new Position("B1"));
        board[0][2] = new Bishop(Player.Black, new Position("C1"));
        board[0][3] = new Queen(Player.Black, new Position("D1"));
        board[0][4] = new King(Player.Black, blackKingPos);
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
        board[7][3] = new King(Player.White, whiteKingPos);
        board[7][4] = new Queen(Player.White, new Position("E8"));
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

    public MoveResult isLegalMove(ChessPiece chessPiece, Position pos) {
        // check if the new position off the board
        int x = pos.getX();
        int y = pos.getY();
        if (x >= this.HEIGHT || x < 0) {
            return MoveResult.OffTheBoard;
        } else if (y >= this.WIDTH || y < 0) {
            return MoveResult.OffTheBoard;
        }

        // check if the new position is occupied by the same player's pieces
        if (board[y][x] != null) {
            if (board[y][x].getPlayer() == chessPiece.getPlayer()) {
                return MoveResult.IllegalMove;
            }
        }

        // check if the movement is legal
        MoveResult chessMoveRes = chessPiece.isLegalMove(pos);
        MoveResult moveResult;
        if (chessMoveRes == MoveResult.LegalMove) {
            if (chessPiece instanceof Knight) {
                return MoveResult.LegalMove;
            } else {
                // check if the pieces leap over other pieces
                if (isOverPiece(chessPiece, pos)) {
                    return MoveResult.OverOtherPieces;
                } else {
                    return MoveResult.LegalMove;
                }
            }
        } else if (chessMoveRes == MoveResult.PawnDiagonally) {
            if (board[y][x] != null) {
                return MoveResult.LegalMove;
            } else {
                moveResult = MoveResult.IllegalMove;
            }
        } else {
            moveResult = chessMoveRes;
        }

        return moveResult;
    }

    public boolean isOverPiece(ChessPiece chessPiece, Position pos) {
        if (chessPiece instanceof King) {
            return false;
        }

        Position chessPos = chessPiece.getPosition();
        int startPoint;
        int endPoint;

        if (chessPos.isHorizontal(pos)) {
            int chessY = chessPos.getY();
            if (chessPos.getX() < pos.getX()) {
                startPoint = chessPos.getX() + 1;
                endPoint = pos.getX();
            } else {
                startPoint = pos.getX() + 1;
                endPoint = chessPos.getX();
            }

            for (int i = startPoint; i < endPoint; i++) {
                if (board[chessY][i] != null) {
                    return true;
                }
            }
        } else if (chessPos.isVertical(pos)) {
            int chessX = chessPos.getX();
            if (chessPos.getY() < pos.getY()) {
                startPoint = chessPos.getY() + 1;
                endPoint = pos.getY();
            } else {
                startPoint = pos.getY() + 1;
                endPoint = chessPos.getY();
            }

            for (int i = startPoint; i < endPoint; i++) {
                if (board[i][chessX] != null) {
                    return true;
                }
            }
        } else if (chessPos.isDiagonal(pos)) {
            int startX, endX, checkY;

            if (chessPos.getX() < pos.getX()) {
                startX = chessPos.getX() + 1;
                endX = pos.getX();
                if (chessPos.getY() < pos.getY()) {
                    checkY = chessPos.getY() + 1;
                    for (int i = startX; i < endX; i++) {
                        if (board[checkY][i] != null) {
                            return true;
                        }
                        checkY++;
                    }
                } else {
                    checkY = chessPos.getY() - 1;
                    for (int i = startX; i < endX; i++) {
                        if (board[checkY][i] != null) {
                            return true;
                        }
                        checkY--;
                    }
                }
            } else {
                startX = pos.getX() + 1;
                endX = chessPos.getX();
                if (pos.getY() < chessPos.getY()) {
                    checkY = pos.getY() + 1;
                    for (int i = startX; i < endX; i++) {
                        if (board[checkY][i] != null) {
                            return true;
                        }
                        checkY++;
                    }
                } else {
                    checkY = pos.getY() - 1;
                    for (int i = startX; i < endX; i++) {
                        if (board[checkY][i] != null) {
                            return true;
                        }
                        checkY--;
                    }
                }
            }
        }

        return false;
    }

    public MoveResult chessMove(ChessPiece chessPiece, Position pos) {
        Position prePos = chessPiece.getPosition();
        curPlayer = chessPiece.getPlayer();
        int preX = prePos.getX();
        int preY = prePos.getY();
        int x = pos.getX();
        int y = pos.getY();

        chessPiece.move(pos);
        if (chessPiece instanceof King) {
            if (chessPiece.getPlayer() == Player.Black) {
                blackKingPos = pos;
            } else {
                whiteKingPos = pos;
            }
        }
        board[preY][preX] = null;
        if (board[y][x] != null) {
            ChessPiece capturedChessPiece = board[y][x];
            if (capturedChessPiece instanceof King) {
                if (capturedChessPiece.getPlayer() == Player.Black) {
                    blackKingPos = null;
                } else {
                    whiteKingPos = null;
                }
            }
            board[y][x] = chessPiece;
            return MoveResult.Capture;
        }
        board[y][x] = chessPiece;
        return MoveResult.LegalMove;
    }

    public GameResult judge() {
        if (curPlayer == Player.Black && whiteKingPos == null) {
            return GameResult.BlackWin;
        } else if (curPlayer == Player.White && blackKingPos == null) {
            return GameResult.WhiteWin;
        }

        boolean canCaptureKing = false;
        Position captureKingPos;
        ChessPiece captureKing;
        if (curPlayer == Player.Black) {
            captureKingPos = whiteKingPos;
            captureKing = board[whiteKingPos.getY()][whiteKingPos.getX()];
        } else {
            captureKingPos = blackKingPos;
            captureKing = board[blackKingPos.getY()][blackKingPos.getX()];
        }

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (board[i][j] != null && board[i][j].getPlayer() == curPlayer) {
                    MoveResult moveRes = this.isLegalMove(board[i][j], captureKingPos);
                    if (moveRes == MoveResult.LegalMove || moveRes == MoveResult.Capture) {
                        canCaptureKing = true;
                        break;
                    }
                }
            }
        }

        if (canCaptureKing) {
            if (!canKingMove(captureKing)) {
                return GameResult.Draw;
            }
        }

        return GameResult.Gaming;
    }

    public boolean canKingMove(ChessPiece king) {
        Position kingPos = king.getPosition();

        List possibleMovePos = kingPos.aroundPos();
        for (int i = 0; i < possibleMovePos.size(); i++) {
            MoveResult moveRes = this.isLegalMove(king, (Position) possibleMovePos.get(i));
            if (moveRes == MoveResult.LegalMove) {
                return true;
            }
        }

        return false;

    }

    public ChessPiece getSpecificPositionChess(Position position) {
        return board[position.getY()][position.getX()];
    }

    public void print() {
        System.out.println("\tA\tB\tC\tD\tE\tF\tG\tH");
        for (int i = 0; i < HEIGHT; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < WIDTH; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j] + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
        System.out.println("==================================");
    }
}
