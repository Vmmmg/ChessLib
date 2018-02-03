package chess.Piece;

import chess.Chess;
import chess.Position;
import chess.enums.MoveResult;
import chess.enums.Player;

public class Bishop extends Chess {

    public Bishop(Player player, Position position) {
        super(player, position);
    }

    //The bishop can move any number of squares diagonally
    //but may not leap over other pieces.
    @Override
    public MoveResult isLegalMove(Position pos){
        if(this.getPosition().equals(pos)){
            return MoveResult.SamePosition;
        }

        if(this.getPosition().isDiagonal(pos)){
            return MoveResult.LegalMove;
        }

        return MoveResult.IllegalMove;
    }

    @Override
    public String toString() {
        return "B";
    }
}
