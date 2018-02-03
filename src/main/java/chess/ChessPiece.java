package chess;

import chess.enums.MoveResult;
import chess.enums.Player;

/**
 * All kinds of chess pieces
 */
public abstract class ChessPiece {

    private Player player;
    private Position position;

    public ChessPiece(Player player, Position position) {
        this.player = player;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public Player getPlayer() {
        return player;
    }

    public void move(Position position) {
        this.position = position;
    }

    public abstract MoveResult isLegalMove(Position pos);
}
