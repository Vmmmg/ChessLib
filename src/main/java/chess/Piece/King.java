package chess.Piece;

import chess.enums.MoveResult;
import chess.enums.Player;
import chess.Chess;
import chess.Position;

public class King extends Chess {

    public King(Player player, Position position) {
        super(player, position);
    }

    //The king moves one square in any direction.
    @Override
    public MoveResult isLegalMove(Position pos){
        if(this.getPosition().equals(pos)){
            return MoveResult.SamePosition;
        }

        if(this.getPosition().distance(pos) == 1){
            return MoveResult.LegalMove;
        }

        return MoveResult.IllegalMove;

    }

    public Position[] genNextStep(){

    }

    @Override
    public String toString() {
        return "Ki";
    }
}
