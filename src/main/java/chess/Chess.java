package chess;

import chess.enums.MoveResult;
import chess.enums.Player;


public class Chess {
    private Player player;
    private Position position;

    public Chess(Player player, Position position){
        this.player = player;
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

    public Player getPlayer() {
        return player;
    }

    public void move(Position position){
        this.position = position;
    }

    public MoveResult isLegalMove(Position pos){
        if(this.getPosition().equals(pos)){
            return MoveResult.SamePosition;
        }

        this.position = pos;
        return MoveResult.LegalMove;
    }
}
