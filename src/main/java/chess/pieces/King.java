package chess.pieces;

import chess.ChessPiece;
import chess.Position;
import chess.enums.MoveResult;
import chess.enums.Player;

/**
 * ChessPiece piece: King
 */
public class King extends ChessPiece {

    /**
     * Constructor of King
     *
     * @param player   Belongs to which player
     * @param position Initial position
     */
    public King(Player player, Position position) {
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

        // The king moves one square in any direction.
        if (this.getPosition().distance(pos) == 1) {
            return MoveResult.LegalMove;
        }

        return MoveResult.IllegalMove;
    }

    @Override
    public String toString() {
        return "Ki";
    }
}
