package chess.pieces;

import chess.ChessPiece;
import chess.Position;
import chess.enums.MoveResult;
import chess.enums.Player;

/**
 * ChessPiece piece: Knight
 */
public class Knight extends ChessPiece {

    /**
     * Constructor of Knight
     *
     * @param player   Belongs to which player
     * @param position Initial position
     */
    public Knight(Player player, Position position) {
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

        // The knight moves to any of the closest squares that are not on the same rank, file, or diagonal,
        // thus the move forms an "L"-shape: two squares vertically and one square horizontally, or two squares horizontally and one square vertically.
        // The knight is the only pieces that can leap over other pieces.
        if (this.getPosition().isLShape(pos)) {
            return MoveResult.LegalMove;
        }

        return MoveResult.IllegalMove;
    }

    @Override
    public String toString() {
        return "K";
    }
}
