package chess;

import java.util.HashSet;
import java.util.Set;

/**
 * Path between two positions.
 */
public class Path {

    private Set<Position> positions;

    /**
     * Constructor of Path
     *
     * @param pos1 One of the end points of the path
     * @param pos2 the ohter end point of the path
     */
    public Path(Position pos1, Position pos2) {
        positions = new HashSet<>();
        int startPoint, endPoint;

        if (pos1.isHorizontal(pos2)) {
            int posY = pos1.getY();
            if (pos1.getX() < pos2.getX()) {
                startPoint = pos1.getX();
                endPoint = pos2.getX();
            } else {
                startPoint = pos2.getX();
                endPoint = pos1.getX();
            }

            for (int i = startPoint; i <= endPoint; i++) {
                positions.add(new Position(i, posY));
            }

        } else if (pos1.isVertical(pos2)) {
            int posX = pos1.getX();
            if (pos1.getY() < pos2.getY()) {
                startPoint = pos1.getY();
                endPoint = pos2.getY();
            } else {
                startPoint = pos2.getY();
                endPoint = pos1.getY();
            }

            for (int i = startPoint; i <= endPoint; i++) {
                positions.add(new Position(posX, i));
            }

        } else if (pos1.isDiagonal(pos2)) {
            int startX, endX, checkY;

            if (pos1.getX() < pos2.getX()) {
                startX = pos1.getX();
                endX = pos2.getX();
                if (pos1.getY() < pos2.getY()) {
                    checkY = pos1.getY();
                    for (int i = startX; i < endX; i++) {
                        positions.add(new Position(i, checkY));
                        checkY++;
                    }
                } else {
                    checkY = pos1.getY() - 1;
                    for (int i = startX; i < endX; i++) {
                        positions.add(new Position(i, checkY));
                        checkY--;
                    }
                }
            } else {
                startX = pos2.getX();
                endX = pos1.getX();
                if (pos2.getY() < pos1.getY()) {
                    checkY = pos2.getY();
                    for (int i = startX; i < endX; i++) {
                        positions.add(new Position(i, checkY));
                        checkY++;
                    }
                } else {
                    checkY = pos2.getY();
                    for (int i = startX; i < endX; i++) {
                        positions.add(new Position(i, checkY));
                        checkY--;
                    }
                }
            }
        }
    }

    /**
     * Get all positions on the path
     *
     * @return all positions on the path
     */
    public Set<Position> getPositions() {
        return positions;
    }
}
