package chess.Piece;

import chess.Chess;
import chess.Position;
import chess.enums.MoveResult;
import chess.enums.Player;

public class Queen extends Chess {
    public Queen(Player player, Position position) {
        super(player, position);
    }

    //The queen combines the power of the rook and bishop
    //and can move any number of squares along rank, file, or diagonal,
    //but it may not leap over other pieces.
    @Override
    public MoveResult isLegalMove(Position pos){
        if(this.getPosition().equals(pos)){
            return MoveResult.SamePosition;
        }

        if(this.getPosition().isHorizontal(pos)){
            return MoveResult.LegalMove;
        }
        else if(this.getPosition().isVertical(pos)){
            return MoveResult.LegalMove;
        }
        else if(this.getPosition().isDiagonal(pos)){
            return MoveResult.LegalMove;
        }

        return MoveResult.IllegalMove;
    }

    @Override
    public String toString() {
        return "Q";
    }
}
