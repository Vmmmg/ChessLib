package chess.models;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PathTest {

    /**
     * Method: getPositions()
     */
    @Test
    public void getPositions1() {
        Position posA1 = new Position("A1");
        Position posB1 = new Position("B1");
        Position posC1 = new Position("C1");
        Set<Position> expectedPosSet = new HashSet<>();
        expectedPosSet.add(posA1);
        expectedPosSet.add(posB1);
        expectedPosSet.add(posC1);
        Path path = new Path(posA1, posC1);
        Set<Position> actualPosSet = path.getPositions();
        boolean isFullEqual = isSetEquals(expectedPosSet, actualPosSet);

        assertEquals(isFullEqual, true);
    }

    @Test
    public void getPositions2() {
        Position posA1 = new Position("A1");
        Position posA2 = new Position("A2");
        Position posA3 = new Position("A3");
        Set<Position> expectedPosSet = new HashSet<>();
        expectedPosSet.add(posA1);
        expectedPosSet.add(posA2);
        expectedPosSet.add(posA3);
        Path path = new Path(posA1, posA3);
        Set<Position> actualPosSet = path.getPositions();
        boolean isFullEqual = isSetEquals(expectedPosSet, actualPosSet);

        assertEquals(isFullEqual, true);
    }

    @Test
    public void getPositions3() {
        Position posA1 = new Position("A1");
        Position posB2 = new Position("B2");
        Position posC3 = new Position("C3");
        Set<Position> expectedPosSet = new HashSet<>();
        expectedPosSet.add(posA1);
        expectedPosSet.add(posB2);
        expectedPosSet.add(posC3);
        Path path = new Path(posA1, posC3);
        Set<Position> actualPosSet = path.getPositions();
        boolean isFullEqual = isSetEquals(expectedPosSet, actualPosSet);

        assertEquals(isFullEqual, true);
    }

    private boolean isSetEquals(Set<Position> expectedPosSet, Set<Position> actualPosSet) {
        boolean isEqual = false;
        boolean isFullEqual = true;

        for (Position expectedPos : expectedPosSet) {
            for (Position actualPos : actualPosSet) {
                System.out.println(actualPos.getX() + " " + actualPos.getY());
                if (actualPos.equals(expectedPos)) {
                    isEqual = true;
                    break;
                }
            }

            if (!isEqual) {
                isFullEqual = false;
                break;
            }
            isEqual = false;
        }

        return isFullEqual;
    }
} 
