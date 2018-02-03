package chess.pieces;

import chess.ChessPiece;
import chess.Position;
import chess.enums.MoveResult;
import chess.enums.Player;

/**
 * ChessPiece piece: King
 */
public class King extends ChessPiece {

    public King(Player player, Position position) {
        super(player, position);
    }

    //The king moves one square in any direction.
    @Override
    public MoveResult isLegalMove(Position pos) {
        if (this.getPosition().equals(pos)) {
            return MoveResult.SamePosition;
        }

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
