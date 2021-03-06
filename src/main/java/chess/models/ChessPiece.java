package chess.models;

import chess.models.enums.MoveResult;
import chess.models.enums.Player;

import java.util.HashSet;
import java.util.Set;

/**
 * All kinds of chess pieces
 */
public abstract class ChessPiece {

    //    int id;
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

//    public ChessPiece(Player player, Position position, int id) {
//        this.player = player;
//        this.position = position;
//        this.id = id;
//    }

    /**
     * Get current position
     *
     * @return current position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set chess piece position
     *
     * @param position specific position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Get player this piece belongs to
     *
     * @return player this piece belongs to
     */
    public Player getPlayer() {
        return player;
    }

//    /**
//     * Get the piece's id
//     *
//     * @return the piece's id
//     */
//    public int getId() {
//        return id;
//    }

    /**
     * Move to specific position
     *
     * @param position specific position
     */
    public void move(Position position) {
        this.setPosition(position);
    }

    /**
     * Check if the movement is legal
     *
     * @param pos destination position
     * @return MoveResult
     */
    public abstract MoveResult isLegalMove(Position pos);

    /**
     * Generate all possible next steps of the chess
     *
     * @param board the chess board
     * @return all possible next steps of the chess
     */
    public Set<Position> genNextStep(Board board) {
        Set<Position> nextStep = new HashSet<>();

        for (int i = 0; i < board.getWIDTH(); i++) {
            for (int j = 0; j < board.getHEIGHT(); j++) {
                Position pos = new Position(i, j);
                MoveResult moveRes = board.isLegalMove(this, pos);
                if (moveRes == MoveResult.LegalMove) {
                    nextStep.add(pos);
                }
            }
        }

        return nextStep;
    }
}
