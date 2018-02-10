package chess.models;

import chess.models.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void distance() {
        Position position = new Position("A1");

        assertEquals(position.distance(new Position("A1")), 0);
        assertEquals(position.distance(new Position("A2")), 1);
        assertEquals(position.distance(new Position("A3")), 2);
        assertEquals(position.distance(new Position("A4")), 3);
        assertEquals(position.distance(new Position("A5")), 4);
        assertEquals(position.distance(new Position("A6")), 5);
        assertEquals(position.distance(new Position("A7")), 6);
        assertEquals(position.distance(new Position("A8")), 7);

        assertEquals(position.distance(new Position("B1")), 1);
        assertEquals(position.distance(new Position("C1")), 2);
        assertEquals(position.distance(new Position("D1")), 3);
        assertEquals(position.distance(new Position("E1")), 4);
        assertEquals(position.distance(new Position("F1")), 5);
        assertEquals(position.distance(new Position("G1")), 6);
        assertEquals(position.distance(new Position("H1")), 7);

        assertEquals(position.distance(new Position("B2")), 1);
        assertEquals(position.distance(new Position("C3")), 2);
        assertEquals(position.distance(new Position("D4")), 3);
        assertEquals(position.distance(new Position("E5")), 4);
        assertEquals(position.distance(new Position("F6")), 5);
        assertEquals(position.distance(new Position("G7")), 6);
        assertEquals(position.distance(new Position("H8")), 7);

        assertEquals(position.distance(new Position("B3")), -1);
        assertEquals(position.distance(new Position("B4")), -1);
        assertEquals(position.distance(new Position("C2")), -1);
        assertEquals(position.distance(new Position("C4")), -1);
    }

    @Test
    public void isHorizontal() {
        Position position = new Position("A1");

        assertEquals(position.isHorizontal(new Position("A1")), true);
        assertEquals(position.isHorizontal(new Position("B1")), true);
        assertEquals(position.isHorizontal(new Position("C1")), true);
        assertEquals(position.isHorizontal(new Position("D1")), true);
        assertEquals(position.isHorizontal(new Position("E1")), true);
        assertEquals(position.isHorizontal(new Position("F1")), true);
        assertEquals(position.isHorizontal(new Position("G1")), true);
        assertEquals(position.isHorizontal(new Position("H1")), true);

        assertEquals(position.isHorizontal(new Position("A2")), false);
        assertEquals(position.isHorizontal(new Position("A3")), false);
        assertEquals(position.isHorizontal(new Position("A4")), false);
        assertEquals(position.isHorizontal(new Position("A5")), false);
        assertEquals(position.isHorizontal(new Position("A6")), false);
        assertEquals(position.isHorizontal(new Position("A7")), false);
        assertEquals(position.isHorizontal(new Position("A8")), false);

        assertEquals(position.isHorizontal(new Position("B2")), false);
        assertEquals(position.isHorizontal(new Position("C3")), false);
        assertEquals(position.isHorizontal(new Position("D4")), false);
        assertEquals(position.isHorizontal(new Position("E5")), false);
        assertEquals(position.isHorizontal(new Position("F6")), false);
        assertEquals(position.isHorizontal(new Position("G7")), false);
        assertEquals(position.isHorizontal(new Position("H8")), false);
    }

    @Test
    public void isVertical() {
        Position position = new Position("A1");

        assertEquals(position.isVertical(new Position("A1")), true);
        assertEquals(position.isVertical(new Position("A2")), true);
        assertEquals(position.isVertical(new Position("A3")), true);
        assertEquals(position.isVertical(new Position("A4")), true);
        assertEquals(position.isVertical(new Position("A5")), true);
        assertEquals(position.isVertical(new Position("A6")), true);
        assertEquals(position.isVertical(new Position("A7")), true);
        assertEquals(position.isVertical(new Position("A8")), true);

        assertEquals(position.isVertical(new Position("B1")), false);
        assertEquals(position.isVertical(new Position("C1")), false);
        assertEquals(position.isVertical(new Position("D1")), false);
        assertEquals(position.isVertical(new Position("E1")), false);
        assertEquals(position.isVertical(new Position("F1")), false);
        assertEquals(position.isVertical(new Position("G1")), false);
        assertEquals(position.isVertical(new Position("H1")), false);

        assertEquals(position.isVertical(new Position("B2")), false);
        assertEquals(position.isVertical(new Position("C3")), false);
        assertEquals(position.isVertical(new Position("D4")), false);
        assertEquals(position.isVertical(new Position("E5")), false);
        assertEquals(position.isVertical(new Position("F6")), false);
        assertEquals(position.isVertical(new Position("G7")), false);
        assertEquals(position.isVertical(new Position("H8")), false);
    }

    @Test
    public void isDiagonal() {
        Position position = new Position("A1");

        assertEquals(position.isDiagonal(new Position("A1")), true);
        assertEquals(position.isDiagonal(new Position("B2")), true);
        assertEquals(position.isDiagonal(new Position("C3")), true);
        assertEquals(position.isDiagonal(new Position("D4")), true);
        assertEquals(position.isDiagonal(new Position("E5")), true);
        assertEquals(position.isDiagonal(new Position("F6")), true);
        assertEquals(position.isDiagonal(new Position("G7")), true);
        assertEquals(position.isDiagonal(new Position("H8")), true);

        assertEquals(position.isDiagonal(new Position("A2")), false);
        assertEquals(position.isDiagonal(new Position("A3")), false);
        assertEquals(position.isDiagonal(new Position("A4")), false);
        assertEquals(position.isDiagonal(new Position("A5")), false);
        assertEquals(position.isDiagonal(new Position("A6")), false);
        assertEquals(position.isDiagonal(new Position("A7")), false);
        assertEquals(position.isDiagonal(new Position("A8")), false);

        assertEquals(position.isDiagonal(new Position("B1")), false);
        assertEquals(position.isDiagonal(new Position("C1")), false);
        assertEquals(position.isDiagonal(new Position("D1")), false);
        assertEquals(position.isDiagonal(new Position("E1")), false);
        assertEquals(position.isDiagonal(new Position("F1")), false);
        assertEquals(position.isDiagonal(new Position("G1")), false);
        assertEquals(position.isDiagonal(new Position("H1")), false);
    }

    @Test
    public void isLShape() {
        Position position = new Position("E4");

        assertEquals(position.isLShape(new Position("D2")), true);
        assertEquals(position.isLShape(new Position("F2")), true);
        assertEquals(position.isLShape(new Position("C3")), true);
        assertEquals(position.isLShape(new Position("G3")), true);
        assertEquals(position.isLShape(new Position("C5")), true);
        assertEquals(position.isLShape(new Position("G5")), true);
        assertEquals(position.isLShape(new Position("D6")), true);
        assertEquals(position.isLShape(new Position("F6")), true);

        assertEquals(position.isLShape(new Position("E1")), false);
        assertEquals(position.isLShape(new Position("E2")), false);
        assertEquals(position.isLShape(new Position("E3")), false);
        assertEquals(position.isLShape(new Position("E5")), false);
        assertEquals(position.isLShape(new Position("E6")), false);
        assertEquals(position.isLShape(new Position("E7")), false);
        assertEquals(position.isLShape(new Position("E8")), false);

        assertEquals(position.isLShape(new Position("A1")), false);
        assertEquals(position.isLShape(new Position("B1")), false);
        assertEquals(position.isLShape(new Position("C1")), false);
        assertEquals(position.isLShape(new Position("D1")), false);
        assertEquals(position.isLShape(new Position("E1")), false);
        assertEquals(position.isLShape(new Position("F1")), false);
        assertEquals(position.isLShape(new Position("G1")), false);
        assertEquals(position.isLShape(new Position("H1")), false);
    }
}