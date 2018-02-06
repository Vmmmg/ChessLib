package chess.models.pieces;

import chess.models.ChessPiece;
import chess.models.Position;
import chess.models.enums.MoveResult;
import chess.models.enums.Player;

/**
 * ChessPiece piece: Pawn
 */
public class Pawn extends ChessPiece {

    private boolean isFirstStep;

    /**
     * Constructor of Pawn
     *
     * @param player   Belongs to which player
     * @param position Initial position
     */
    public Pawn(Player player, Position position) {
        super(player, position);
        isFirstStep = true;
    }

    /**
     * Check if the movement is legal
     * @param pos Destination position
     * @return MoveResult
     */
    @Override
    public MoveResult isLegalMove(Position pos) {
        if (this.getPosition().equals(pos)) {
            return MoveResult.SamePosition;
        }

        // The pawn may move forward to the unoccupied square immediately in front of it on the same file;
        // or on its first move it may advance two squares along the same file provided both squares are unoccupied;
        // or it may move to a square occupied by an opponent's pieces which is diagonally in front of it on an adjacent file, capturing that pieces.
        if (this.getPosition().isVertical(pos)) {
            if (this.isForward(pos)) {
                int distance = this.getPosition().distance(pos);
                if (isFirstStep) {
                    if (distance == 1 || distance == 2) {
                        return MoveResult.PawnForward;
                    }
                } else {
                    if (distance == 1) {
                        return MoveResult.PawnForward;
                    }
                }
            }
        } else if (this.getPosition().isDiagonal(pos)) {
            if (this.isForward(pos)) {
                if (this.getPosition().distance(pos) == 1) {
                    return MoveResult.PawnDiagonally;
                }
            }
        }

        return MoveResult.IllegalMove;
    }

    /**
     * Check if the pawn is moving forward
     * @param pos Destination position
     * @return true is that the pawn is moving forward
     */
    public boolean isForward(Position pos) {
        if (this.getPlayer() == Player.White) {
            return this.getPosition().getY() > pos.getY();
        } else if (this.getPlayer() == Player.Black) {
            return this.getPosition().getY() < pos.getY();
        }

        return false;
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public void move(Position pos){
        if(isFirstStep){
            isFirstStep = false;
        }

        this.setPosition(pos);
    }
}
