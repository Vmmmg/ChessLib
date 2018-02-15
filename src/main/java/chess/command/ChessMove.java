package chess.command;

import chess.models.Board;
import chess.models.ChessPiece;
import chess.models.Position;

/**
 * Receiver of the Command Pattern
 */
public class ChessMove {

    /**
     * Move a piece to specific position on the board
     *
     * @param board
     * @param chess  Piece that needs to move
     * @param destination  Destination position
     */
    public void move(Board board, ChessPiece chess, Position destination){
        board.chessMove(chess ,destination);
    }

}
