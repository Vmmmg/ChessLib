package chess.models.pieces;

import chess.models.ChessPiece;
import chess.models.Position;
import chess.models.enums.MoveResult;
import chess.models.enums.Player;

/**
 * Custom chess piece: Crab
 */
public class Crab extends ChessPiece {
    /**
     * Constructor of ChessPiece
     *
     * @param player   Belongs to which player
     * @param position Initial position
     */
    public Crab(Player player, Position position) {
        super(player, position);
    }

    /**
     * Check if the movement is legal
     * @param pos Destination position
     * @return MoveResult
     */
    @Override
    public MoveResult isLegalMove(Position pos) {
        if (this.getPosition().equals(pos)) {
            return MoveResult.SamePosition;
        }

        // The bishop can move any number of squares horizontally
        // but may not leap over other pieces.
        if (this.getPosition().isHorizontal(pos)) {
            return MoveResult.LegalMove;
        }

        return MoveResult.IllegalMove;
    }
}
