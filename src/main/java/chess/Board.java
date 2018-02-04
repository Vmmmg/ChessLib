package chess;

import chess.enums.GameResult;
import chess.enums.MoveResult;
import chess.enums.Player;
import chess.pieces.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Board, contains the shape and size of chess board, all chess pieces and the judgement of game ending
 */
public class Board {

    private int HEIGHT = 8;
    private int WIDTH = 8;
    private ChessPiece[][] board = new ChessPiece[WIDTH][HEIGHT];
    private Position blackKingPos = new Position("E1");
    private Position whiteKingPos = new Position("E8");
    private Player curPlayer = Player.White;
    private Set<ChessPiece> blackChessSet = new HashSet<>();
    private Set<ChessPiece> whiteChessSet = new HashSet<>();

    /**
     * Constructor of Board
     */
    public Board() {
        init();
    }

    /**
     * Create Initial state of chess board
     */
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
        board[7][3] = new Queen(Player.White, new Position("D8"));
        board[7][4] = new King(Player.White, whiteKingPos);
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

        for (int i = 0; i < 2; i++) {
            blackChessSet.addAll(Arrays.asList(board[i]).subList(0, WIDTH));
        }
        for (int i = 6; i < 8; i++) {
            whiteChessSet.addAll(Arrays.asList(board[i]).subList(0, WIDTH));
        }
    }

    /**
     * Check if the movement is legal
     *
     * @param chessPiece Piece that needs to move
     * @param pos        Destination position
     * @return MoveResult
     */
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

    /**
     * Check if the piece leaps over other pieces
     *
     * @param chessPiece Piece that needs to move
     * @param pos        Destination position
     * @return true is that the piece leaps over other pieces
     */
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

    /**
     * Move a piece to specific position
     *
     * @param chessPiece Piece that needs to move
     * @param pos        Destination position
     * @return MoveResult
     */
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
            if (capturedChessPiece.getPlayer() == Player.Black) {
                blackChessSet.remove(capturedChessPiece);
            } else {
                whiteChessSet.remove(capturedChessPiece);
            }

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

    /**
     * Judge if the game is ended
     *
     * @return GameResult
     */
    public GameResult judge() {
        // check if in checkmate
        ChessPiece capturedKing = null;
        if(curPlayer == Player.White){
            capturedKing = getSpecificPositionChess(blackKingPos);
        }
        else{
            capturedKing = getSpecificPositionChess(whiteKingPos);
        }
        boolean isCheckmate = checkmate(capturedKing);
        if(isCheckmate){
            if(curPlayer == Player.White){
                return GameResult.WhiteWin;
            }
            else{
                return GameResult.BlackWin;
            }
        }

        if(stalemate()){
            return GameResult.Draw;
        }


        return GameResult.Gaming;
    }

    /**
     * Check if the king is in checkmate
     *
     * @param king Selected king
     * @return true is that the king is in checkmate
     */
    public boolean checkmate(ChessPiece king) {
        Set<ChessPiece> opponentChessPieceSet, capturedChessPieceSet;
        Set<ChessPiece> checkmateChessPieceSet = new HashSet<>();

        if (king.getPlayer() == Player.Black) {
            capturedChessPieceSet = blackChessSet;
            opponentChessPieceSet = whiteChessSet;
        } else {
            capturedChessPieceSet = whiteChessSet;
            opponentChessPieceSet = blackChessSet;
        }

        // check if the opponent chess pieces can capture the king
        // if they can, record them
        boolean canCaptureCurrentKing = false;
        for (ChessPiece opponentChess : opponentChessPieceSet) {
            if (isLegalMove(opponentChess, king.getPosition()) == MoveResult.LegalMove) {
                canCaptureCurrentKing = true;
                checkmateChessPieceSet.add(opponentChess);
            }
        }

        //4看本方棋子能否去到那条路上
        if (canCaptureCurrentKing) {
            if(ifKingCanNotMove(king)){
                if(checkmateChessPieceSet.size() > 1){
                    return true;
                }
                else{
                    ChessPiece checkmatePiece = null;
                    for(ChessPiece piece: checkmateChessPieceSet){
                        checkmatePiece = piece;
                    }
                    if(!ifCheckmatePieceCanBeCaptured(checkmatePiece, capturedChessPieceSet)){
                        if(!ifCheckmatePieceCanBeBlocked(checkmatePiece, king, capturedChessPieceSet)){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean ifCheckmatePieceCanBeCaptured(ChessPiece checkmatePiece, Set<ChessPiece> capturedPieceSet){
        for(ChessPiece capturedPiece: capturedPieceSet){
            if(isLegalMove(capturedPiece, checkmatePiece.getPosition()) == MoveResult.LegalMove){
                return true;
            }
        }

        return false;
    }

    public boolean ifCheckmatePieceCanBeBlocked(ChessPiece checkmatePiece, ChessPiece king, Set<ChessPiece> capturedPieceSet){
        if(checkmatePiece instanceof Knight){
            return false;
        }

        Path checkmatePath = new Path(checkmatePiece.getPosition(), king.getPosition());
        Set<Position> checkmatePathPositions = checkmatePath.getPositions();
        checkmatePathPositions.remove(checkmatePiece.getPosition());
        checkmatePathPositions.remove(king.getPosition());
        if(checkmatePathPositions.size() == 0){
            return false;
        }

        for(ChessPiece capturedPiece: capturedPieceSet){
            for(Position checkmatePathPosition: checkmatePathPositions){
                if(isLegalMove(capturedPiece, checkmatePathPosition) == MoveResult.LegalMove){
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Check if the king can move to other position
     *
     * @param king selected King
     * @return true is that the king can move to other position
     */
    private boolean ifKingCanNotMove(ChessPiece king) {
        Set<ChessPiece> theOtherChessPieceSet;
        if (king.getPlayer() == Player.Black) {
            theOtherChessPieceSet = getWhiteChessSet();
        } else {
            theOtherChessPieceSet = getBlackChessSet();
        }

        Position kingPos = king.getPosition();
        List<Position> possibleMovePos = kingPos.aroundPos();
        for (Position position : possibleMovePos) {
            if (isLegalMove(king, position) == MoveResult.LegalMove) {
                ChessPiece targetPieceBackup = getSpecificPositionChess(position);
                board[kingPos.getY()][kingPos.getX()] = null;
                board[position.getY()][position.getX()] = king;

                boolean canOtherChessPieceCaptureKing = false;
                for (ChessPiece theOtherChess : theOtherChessPieceSet) {
                    if (isLegalMove(theOtherChess, position) == MoveResult.LegalMove) {
                        canOtherChessPieceCaptureKing = true;
                        break;
                    }
                }

                // backup
                board[kingPos.getY()][kingPos.getX()] = king;
                if (targetPieceBackup != null) {
                    board[position.getY()][position.getX()] = targetPieceBackup;
                }

                if (!canOtherChessPieceCaptureKing) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean stalemate(){
        Set<ChessPiece> curPlayerChessSet;

        if(curPlayer == Player.White){
            curPlayerChessSet = whiteChessSet;
        }
        else{
            curPlayerChessSet = blackChessSet;
        }

        for(ChessPiece curPlayerChess: curPlayerChessSet){
            if(curPlayerChess.genNextStep(this).size() != 0){
                return false;
            }
        }

        return true;
    }

    /**
     * Get the chess piece in specific position
     *
     * @param position Specific position
     * @return The chess piece in specific position
     */
    public ChessPiece getSpecificPositionChess(Position position) {
        return board[position.getY()][position.getX()];
    }

    /**
     * Get the set of black chess
     *
     * @return The set of black chess
     */
    public Set<ChessPiece> getBlackChessSet() {
        return blackChessSet;
    }

    /**
     * Get the set of white chess
     *
     * @return The set of white chess
     */
    public Set<ChessPiece> getWhiteChessSet() {
        return whiteChessSet;
    }

    /**
     * Print the board to console for testing
     */
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

    public int getWIDTH(){
        return WIDTH;
    }

    public int getHEIGHT(){
        return HEIGHT;
    }
}
