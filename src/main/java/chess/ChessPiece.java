package chess;

import chess.enums.MoveResult;
import chess.enums.Player;

/**
 * All kinds of chess pieces
 */
public abstract class ChessPiece {

    private Player player;
    private Position position;

    /**
     * Constructor of ChessPiece
     *
     * @param player   Belongs to which player
     * @param position Initial position
     */
    public ChessPiece(Player player, Position position) {
        this.player = player;
        this.position = position;
    }

    /**
     * Get current position
     * @return current position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Get player this piece belongs to
     * @return player this piece belongs to
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Move to specific position
     * @param position specific position
     */
    public void move(Position position) {
        this.position = position;
    }

    /**
     * Check if the movement is legal
     * @param pos destination position
     * @return MoveResult
     */
    public abstract MoveResult isLegalMove(Position pos);
}
