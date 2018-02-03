package chess.pieces;

import chess.ChessPiece;
import chess.Position;
import chess.enums.MoveResult;
import chess.enums.Player;

/**
 * ChessPiece piece: Rook
 */
public class Rook extends ChessPiece {

    public Rook(Player player, Position position) {
        super(player, position);
    }

    //The rook can move any number of squares along any rank or file
    //but may not leap over other pieces.
    @Override
    public MoveResult isLegalMove(Position pos) {
        if (this.getPosition().equals(pos)) {
            return MoveResult.SamePosition;
        }

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
