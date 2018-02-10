package chess.models.pieces;

import chess.models.ChessPiece;
import chess.models.Position;
import chess.models.enums.MoveResult;
import chess.models.enums.Player;

import java.util.HashSet;
import java.util.Set;

/**
 * Custom chess piece: Advisor
 */
public class Advisor extends ChessPiece {

    /**
     * Constructor of Advisor
     *
     * @param player   Belongs to which player
     * @param position Initial position
     */
    public Advisor(Player player, Position position) {
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

        // Advisor is Chinese Queen.
        // It can move only one point along rank, file, or diagonal,
        // Ferz that can't leave the Nine Palaces (3×3 zone at the center of South and North sides).
        if (this.getPosition().isHorizontal(pos) || this.getPosition().isVertical(pos) || this.getPosition().isDiagonal(pos)) {
            System.out.println(this.getPosition().isDiagonal(pos));
            int distance = this.getPosition().distance(pos);
            System.out.println(distance);
            if (distance == 1) {
                Set<Position> ninePalaces = this.getNinePalaces();
                for (Position ninePalacesPos : ninePalaces) {
                    if (pos.equals(ninePalacesPos)) {
                        return MoveResult.LegalMove;
                    }
                }
            }
        }

        return MoveResult.IllegalMove;
    }

    public Set<Position> getNinePalaces() {
        Set<Position> ninePalaces = new HashSet<>();

        if (this.getPlayer() == Player.White) {
            Position posC6 = new Position("C6");
            Position posD6 = new Position("D6");
            Position posE6 = new Position("E6");
            Position posC7 = new Position("C7");
            Position posD7 = new Position("D7");
            Position posE7 = new Position("E7");
            Position posC8 = new Position("C8");
            Position posD8 = new Position("D8");
            Position posE8 = new Position("E8");

            ninePalaces.add(posC6);
            ninePalaces.add(posD6);
            ninePalaces.add(posE6);
            ninePalaces.add(posC7);
            ninePalaces.add(posD7);
            ninePalaces.add(posE7);
            ninePalaces.add(posC8);
            ninePalaces.add(posD8);
            ninePalaces.add(posE8);
        } else {
            Position posC1 = new Position("C1");
            Position posD1 = new Position("D1");
            Position posE1 = new Position("E1");
            Position posC2 = new Position("C2");
            Position posD2 = new Position("D2");
            Position posE2 = new Position("E2");
            Position posC3 = new Position("C3");
            Position posD3 = new Position("D3");
            Position posE3 = new Position("E3");

            ninePalaces.add(posC1);
            ninePalaces.add(posD1);
            ninePalaces.add(posE1);
            ninePalaces.add(posC2);
            ninePalaces.add(posD2);
            ninePalaces.add(posE2);
            ninePalaces.add(posC3);
            ninePalaces.add(posD3);
            ninePalaces.add(posE3);
        }

        return ninePalaces;
    }

}
