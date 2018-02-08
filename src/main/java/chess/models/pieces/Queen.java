package chess.models.pieces;

import chess.models.ChessPiece;
import chess.models.Position;
import chess.models.enums.MoveResult;
import chess.models.enums.Player;

/**
 * ChessPiece piece: Queen
 */
public class Queen extends ChessPiece {

    /**
     * Constructor of Queen
     *
     * @param player   Belongs to which player
     * @param position Initial position
     */
    public Queen(Player player, Position position) {
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

        // The queen combines the power of the rook and bishop
        // and can move any number of squares along rank, file, or diagonal,
        // but it may not leap over other pieces.
        if (this.getPosition().isHorizontal(pos)) {
            return MoveResult.LegalMove;
        } else if (this.getPosition().isVertical(pos)) {
            return MoveResult.LegalMove;
        } else if (this.getPosition().isDiagonal(pos)) {
            return MoveResult.LegalMove;
        }

        return MoveResult.IllegalMove;
    }

    @Override
    public String toString() {
        return "Q";
    }
}
