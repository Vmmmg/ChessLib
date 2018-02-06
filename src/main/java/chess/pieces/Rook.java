package chess.pieces;

import chess.ChessPiece;
import chess.Position;
import chess.enums.MoveResult;
import chess.enums.Player;

/**
 * ChessPiece piece: Rook
 */
public class Rook extends ChessPiece {

    /**
     * Constructor of Rook
     *
     * @param player   Belongs to which player
     * @param position Initial position
     */
    public Rook(Player player, Position position) {
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

        // The rook can move any number of squares along any rank or file
        // but may not leap over other pieces.
        if (this.getPosition().isHorizontal(pos)) {
            return MoveResult.LegalMove;
        } else if (this.getPosition().isVertical(pos)) {
            return MoveResult.LegalMove;
        }

        return MoveResult.IllegalMove;
    }

    @Override
    public String toString() {
        return "R";
    }
}
