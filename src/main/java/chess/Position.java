package chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Position of chess pieces on the board
 */
public class Position {

    private int x;
    private int y;

    /**
     * Constructor of Position
     *
     * @param position Position in string format, such as "A4", "E6"
     */
    public Position(String position) {
        this.x = position.substring(0, 1).toUpperCase().charAt(0) - 'A';
        this.y = Integer.parseInt(position.substring(1, 2)) - 1;
    }

    /**
     * Constructor of Position
     * @param x Horizontal position
     * @param y Vertical position
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get horizontal position
     * @return Horizontal position
     */
    public int getX() {
        return x;
    }

    /**
     * Get vertical position
     * @return Vertical position
     */
    public int getY() {
        return y;
    }

    /**
     * Check two position is equal
     * @param pos The other position
     * @return true is that two position is equal
     */
    public boolean equals(Position pos) {
        int otherX = pos.getX();
        int otherY = pos.getY();
        return x == otherX && y == otherY;
    }

    /**
     * Get the distance to the other position
     * @param pos The other position
     * @return distance in Integer Number
     */
    public int distance(Position pos) {
        if (this.isVertical(pos)) {
            return Math.abs(y - pos.getY());
        } else if (this.isHorizontal(pos)) {
            return Math.abs(x - pos.getX());
        } else if (this.isDiagonal(pos)) {
            return Math.abs(x - pos.getX());
        }

        return -1;
    }

    /**
     * Check if two positions are horizontal
     * @param pos the other position
     * @return true is that two positions are horizontal
     */
    public boolean isHorizontal(Position pos) {
        return y == pos.getY();
    }

    /**
     * Check if two positions are vertical
     * @param pos the other position
     * @return true is that two positions are vertical
     */
    public boolean isVertical(Position pos) {
        return x == pos.getX();
    }

    /**
     * Check if two positions are diagonal
     * @param pos the other position
     * @return true is that two positions are diagonal
     */
    public boolean isDiagonal(Position pos) {
        return Math.abs(x - pos.getX()) == Math.abs(y - pos.getY());
    }

    /**
     * Check if two positions are LShape
     * @param pos the other position
     * @return true is that two positions are LShape
     */
    public boolean isLShape(Position pos) {
        if (Math.abs(x - pos.getX()) == 2) {
            return Math.abs(y - pos.getY()) == 1;
        } else if (Math.abs(x - pos.getX()) == 1) {
            return Math.abs(y - pos.getY()) == 2;
        }

        return false;
    }

    /**
     * Get around position of this position
     * @return Around position list
     */
    public List<Position> aroundPos() {
        List<Position> aroundPos = new ArrayList<>();
        aroundPos.add(new Position(x - 1, y - 1));
        aroundPos.add(new Position(x, y - 1));
        aroundPos.add(new Position(x + 1, y - 1));
        aroundPos.add(new Position(x - 1, y));
        aroundPos.add(new Position(x + 1, y));
        aroundPos.add(new Position(x - 1, y + 1));
        aroundPos.add(new Position(x, y + 1));
        aroundPos.add(new Position(x + 1, y + 1));

        return aroundPos;
    }
}
