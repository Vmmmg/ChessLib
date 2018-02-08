package chess.models.pieces;

import chess.models.ChessPiece;
import chess.models.Position;
import chess.models.enums.MoveResult;
import chess.models.enums.Player;

/**
 * ChessPiece piece: Bishop
 */
public class Bishop extends ChessPiece {

    /**
     * Constructor of Bishop
     *
     * @param player   Belongs to which player
     * @param position Initial position
     */
    public Bishop(Player player, Position position) {
        super(player, position);
    }

    /**
     * Check if the movement is legal
     *
     * @param pos Destination position
     * @return MoveResult
     */
    @Override
    public MoveResult isLegalMove(Position pos) {
        if (this.getPosition().equals(pos)) {
            return MoveResult.SamePosition;
        }

        // The bishop can move any number of squares diagonally
        // but may not leap over other pieces.
        if (this.getPosition().isDiagonal(pos)) {
            return MoveResult.LegalMove;
        }

        return MoveResult.IllegalMove;
    }

    @Override
    public String toString() {
        return "B";
    }
}
