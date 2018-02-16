package chess.command;

import chess.models.Board;
import chess.models.ChessPiece;
import chess.models.Position;
import chess.models.enums.MoveResult;

/**
 * Receiver of the Command Pattern
 */
public class ChessMove {

    /**
     * Move a piece to specific position on the board
     *
     * @param board       Chess board
     * @param chess       Piece that needs to move
     * @param destination Destination position
     */
    public MoveResult move(Board board, ChessPiece chess, Position destination) {
        return board.chessMove(chess, destination);
    }

}
