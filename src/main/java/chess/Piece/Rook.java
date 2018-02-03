package chess.Piece;

import chess.Chess;
import chess.Position;
import chess.enums.MoveResult;
import chess.enums.Player;

public class Rook extends Chess {
    public Rook(Player player, Position position) {
        super(player, position);
    }

    //The rook can move any number of squares along any rank or file
    //but may not leap over other pieces.
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

        return MoveResult.IllegalMove;
    }
}
