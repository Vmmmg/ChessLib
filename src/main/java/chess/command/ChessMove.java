package chess.command;

import chess.models.Board;
import chess.models.ChessPiece;
import chess.models.Position;

/**
 * Receiver of the Command Pattern
 */
public class ChessMove {
    public void move(Board board, ChessPiece chess, Position destination){
        board.chessMove(chess ,destination);
    }

}
