package chess.models.pieces;

import chess.models.ChessPiece;
import chess.models.Position;
import chess.models.enums.MoveResult;
import chess.models.enums.Player;

/**
 * Custom chess piece: Soldier
 * Soldier is Chinese Pawn.
 * It move and capture by advancing one point before it crossed the river(the half of ths board).
 * Once they have crossed the river, they may also move and capture one point horizontally.
 */
public class Soldier extends ChessPiece {

    /**
     * Constructor of Soldier
     *
     * @param player   Belongs to which player
     * @param position Initial position
     */
    public Soldier(Player player, Position position) {
        super(player, position);
    }

    /**
     * Check if the movement is legal
     *
     * @param pos Destination position
     * @return MoveResult
     */
    @Override
    public MoveResult isLegalMove(Position pos) {
        if (this.getPosition().equals(pos)) {
            return MoveResult.SamePosition;
        }

        int distance;
        if (this.getPosition().isVertical(pos)) {
            if (this.isForward(pos)) {
                distance = this.getPosition().distance(pos);
                if (distance == 1) {
                    return MoveResult.LegalMove;
                }
            }
        }

        if (this.isCrossTheRiver()) {
            if (this.getPosition().isHorizontal(pos)) {
                distance = this.getPosition().distance(pos);
                if (distance == 1) {
                    return MoveResult.LegalMove;
                }
            }
        }
        return MoveResult.IllegalMove;
    }

    /**
     * Check if the soldier is moving forward
     *
     * @param pos Destination position
     * @return true is that the soldier is moving forward
     */
    public boolean isForward(Position pos) {
        if (this.getPlayer() == Player.White) {
            return this.getPosition().getY() > pos.getY();
        } else if (this.getPlayer() == Player.Black) {
            return this.getPosition().getY() < pos.getY();
        }

        return false;
    }

    /**
     * Check if the soldier cross the river
     *
     * @return true is that the soldier have crossed the river
     */
    public boolean isCrossTheRiver() {
        if (this.getPlayer() == Player.White) {
            return this.getPosition().getY() < 4;
        } else {
            return this.getPosition().getY() > 3;
        }
    }
}
