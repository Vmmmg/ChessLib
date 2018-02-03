package chess.Piece;

import chess.Chess;
import chess.Position;
import chess.enums.MoveResult;
import chess.enums.Player;

public class Knight extends Chess {
    public Knight(Player player, Position position) {
        super(player, position);
    }

    //The knight moves to any of the closest squares that are not on the same rank, file, or diagonal,
    //thus the move forms an "L"-shape: two squares vertically and one square horizontally, or two squares horizontally and one square vertically.
    //The knight is the only piece that can leap over other pieces.
    @Override
    public MoveResult isLegalMove(Position pos){
        if(this.getPosition().equals(pos)){
            return MoveResult.SamePosition;
        }

        if(this.getPosition().isLShape(pos)){
            return MoveResult.LegalMove;
        }

        return MoveResult.IllegalMove;
    }
}
