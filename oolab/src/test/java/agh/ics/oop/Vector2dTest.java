package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.Random;


import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToStringA()
    {
        Vector2d vector = new Vector2d(1, 2);
        assertEquals("(1,2)", vector.toString());
    }

    @Test
    void testToStringB()
    {
        Vector2d vector = new Vector2d(-1, -2);
        assertEquals("(-1,-2)", vector.toString());
    }

    @Test
    void testToStringC()
    {
        Vector2d vector = new Vector2d(0, 0);
        assertEquals("(0,0)", vector.toString());
    }

    @Test
    void testToStringD()
    {
        Vector2d vector = new Vector2d(1, 0);
        assertEquals("(1,0)", vector.toString());
    }

    @Test
    void testToStringE()
    {
        Vector2d vector = new Vector2d(0, 1);
        assertEquals("(0,1)", vector.toString());
    }

    @Test
    void testToStringBigNumbers()
    {
        Vector2d vector = new Vector2d(1000000000, 1000000000);
        assertEquals("(1000000000,1000000000)", vector.toString());
    }

    @Test
    void testPrecedesA()
    {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(2, 3);
        assertTrue(vector1.precedes(vector2));
    }

    @Test
    void testPrecedesB()
    {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(1, 3);
        assertTrue(vector1.precedes(vector2));
    }

    @Test
    void testPrecedesC()
    {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(2, 2);
        assertTrue(vector1.precedes(vector2));
    }

    @Test
    void testPrecedesD()
    {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(1, 2);
        assertTrue(vector1.precedes(vector2));
    }

    @Test
    void testPrecedesE()
    {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(0, 1);
        assertFalse(vector1.precedes(vector2));
    }

    @Test
    void testPrecedesF()
    {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(1, 1);
        assertFalse(vector1.precedes(vector2));
    }

    @Test
    void testPrecedesG()
    {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(0, 2);
        assertFalse(vector1.precedes(vector2));
    }

    @Test
    void testFollowsA()
    {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(2, 3);
        assertTrue(vector2.follows(vector1));
    }

    @Test
    void testFollowsB()
    {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(1, 3);
        assertTrue(vector2.follows(vector1));
    }

    @Test
    void testFollowsC()
    {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(2, 2);
        assertTrue(vector2.follows(vector1));
    }

    @Test
    void testFollowsD()
    {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(1, 2);
        assertTrue(vector2.follows(vector1));
    }

    @Test
    void testFollowsE()
    {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(0, 1);
        assertFalse(vector2.follows(vector1));
    }

    @Test
    void testFollowsF()
    {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(1, 1);
        assertFalse(vector2.follows(vector1));
    }

    @Test
    void testFollowsG()
    {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(0, 2);
        assertFalse(vector2.follows(vector1));
    }

    @Test
    void testAddA()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);
        Vector2d v3 = v1.add(v2);
        assertEquals(v1.x + v2.x, v3.x);
        assertEquals(v1.y + v2.y, v3.y);
    }

    @Test
    void testAddB()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, -4);
        Vector2d v3 = v1.add(v2);
        assertEquals(v1.x + v2.x, v3.x);
        assertEquals(v1.y + v2.y, v3.y);
    }

    @Test
    void testAddC()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(0, 0);
        Vector2d v3 = v1.add(v2);
        assertEquals(v1.x + v2.x, v3.x);
        assertEquals(v1.y + v2.y, v3.y);
    }

    @Test
    void testAddD()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 0);
        Vector2d v3 = v1.add(v2);
        assertEquals(v1.x + v2.x, v3.x);
        assertEquals(v1.y + v2.y, v3.y);
    }

    @Test
    void testAddThreeA()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);
        Vector2d v3 = new Vector2d(5, 6);
        Vector2d v4 = v1.add(v2).add(v3);
        assertEquals(v1.x + v2.x + v3.x, v4.x);
        assertEquals(v1.y + v2.y + v3.y, v4.y);
    }

    @Test
    void testAddThreeB()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);
        Vector2d v3 = new Vector2d(-5, -6);
        Vector2d v4 = v1.add(v2).add(v3);
        assertEquals(v1.x + v2.x + v3.x, v4.x);
        assertEquals(v1.y + v2.y + v3.y, v4.y);
    }

    @Test
    void testSubtractA()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);
        Vector2d v3 = v1.subtract(v2);
        assertEquals(v1.x - v2.x, v3.x);
        assertEquals(v1.y - v2.y, v3.y);
    }

    @Test
    void testSubtractB()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, -4);
        Vector2d v3 = v1.subtract(v2);
        assertEquals(v1.x - v2.x, v3.x);
        assertEquals(v1.y - v2.y, v3.y);
    }

    @Test
    void testSubtractC()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(0, 0);
        Vector2d v3 = v1.subtract(v2);
        assertEquals(v1.x - v2.x, v3.x);
        assertEquals(v1.y - v2.y, v3.y);
    }

    @Test
    void testSubtractD()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 0);
        Vector2d v3 = v1.subtract(v2);
        assertEquals(v1.x - v2.x, v3.x);
        assertEquals(v1.y - v2.y, v3.y);
    }

    @Test
    void testSubtractThreeA()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);
        Vector2d v3 = new Vector2d(5, 6);
        Vector2d v4 = v1.subtract(v2).subtract(v3);
        assertEquals(v1.x - v2.x - v3.x, v4.x);
        assertEquals(v1.y - v2.y - v3.y, v4.y);
    }

    @Test
    void testSubtractThreeB()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);
        Vector2d v3 = new Vector2d(-5, -6);
        Vector2d v4 = v1.subtract(v2).subtract(v3);
        assertEquals(v1.x - v2.x - v3.x, v4.x);
        assertEquals(v1.y - v2.y - v3.y, v4.y);
    }

    @Test
    void testUpperRightA()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);
        Vector2d v3 = v1.upperRight(v2);
        assertEquals(v2.x, v3.x);
        assertEquals(v2.y, v3.y);
    }

    @Test
    void testUpperRightB()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, -4);
        Vector2d v3 = v1.upperRight(v2);
        assertEquals(v1.x, v3.x);
        assertEquals(v1.y, v3.y);
    }

    @Test
    void testUpperRightC()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(0, 0);
        Vector2d v3 = v1.upperRight(v2);
        assertEquals(v1.x, v3.x);
        assertEquals(v1.y, v3.y);
    }

    @Test
    void testUpperRightD()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 0);
        Vector2d v3 = v1.upperRight(v2);
        assertEquals(v1.x, v3.x);
        assertEquals(v1.y, v3.y);
    }

    @Test
    void testUpperRightE()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(0, 1);
        Vector2d v3 = v1.upperRight(v2);
        assertEquals(v1.x, v3.x);
        assertEquals(v1.y, v3.y);
    }

    @Test
    void testUpperRightF()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d v3 = v1.upperRight(v2);
        assertEquals(v1.x, v3.x);
        assertEquals(v1.y, v3.y);
    }

    @Test
    void testUpperRightG()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 1);
        Vector2d v3 = v1.upperRight(v2);
        assertEquals(v1.x, v3.x);
        assertEquals(v1.y, v3.y);
    }

    @Test
    void testUpperRightH()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 1);
        Vector2d v3 = v1.upperRight(v2);
        assertEquals(v2.x, v3.x);
        assertEquals(v1.y, v3.y);
    }

    @Test
    void testUpperRightI()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 2);
        Vector2d v3 = v1.upperRight(v2);
        assertEquals(v2.x, v3.x);
        assertEquals(v2.y, v3.y);
    }

    @Test
    void testUpperRightJ()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 3);
        Vector2d v3 = v1.upperRight(v2);
        assertEquals(v2.x, v3.x);
        assertEquals(v2.y, v3.y);
    }

    @Test
    void testLowerLeftA()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);
        Vector2d v3 = v1.lowerLeft(v2);
        assertEquals(v1.x, v3.x);
        assertEquals(v1.y, v3.y);
    }

    @Test
    void testLowerLeftB()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(-3, -4);
        Vector2d v3 = v1.lowerLeft(v2);
        assertEquals(v2.x, v3.x);
        assertEquals(v2.y, v3.y);
    }

    @Test
    void testLowerLeftC()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(0, 0);
        Vector2d v3 = v1.lowerLeft(v2);
        assertEquals(v2.x, v3.x);
        assertEquals(v2.y, v3.y);
    }

    @Test
    void testLowerLeftD()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 0);
        Vector2d v3 = v1.lowerLeft(v2);
        assertEquals(v2.x, v3.x);
        assertEquals(v2.y, v3.y);
    }

    @Test
    void testLowerLeftE()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(0, 1);
        Vector2d v3 = v1.lowerLeft(v2);
        assertEquals(v2.x, v3.x);
        assertEquals(v2.y, v3.y);
    }

    @Test
    void testLowerLeftF()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        Vector2d v3 = v1.lowerLeft(v2);
        assertEquals(v1.x, v3.x);
        assertEquals(v1.y, v3.y);
    }

    @Test
    void testLowerLeftG()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 1);
        Vector2d v3 = v1.lowerLeft(v2);
        assertEquals(v2.x, v3.x);
        assertEquals(v2.y, v3.y);
    }

    @Test
    void testLowerLeftH()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 1);
        Vector2d v3 = v1.lowerLeft(v2);
        assertEquals(v1.x, v3.x);
        assertEquals(v2.y, v3.y);
    }

    @Test
    void testLowerLeftI()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 2);
        Vector2d v3 = v1.lowerLeft(v2);
        assertEquals(v1.x, v3.x);
        assertEquals(v1.y, v3.y);
    }

    @Test
    void testLowerLeftJ()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 3);
        Vector2d v3 = v1.lowerLeft(v2);
        assertEquals(v1.x, v3.x);
        assertEquals(v1.y, v3.y);
    }

    @Test
    void testOppositeA()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = v1.opposite();
        assertEquals(-v1.x, v2.x);
        assertEquals(-v1.y, v2.y);
    }

    @Test
    void testOppositeB()
    {
        Vector2d v1 = new Vector2d(-1, -2);
        Vector2d v2 = v1.opposite();
        assertEquals(-v1.x, v2.x);
        assertEquals(-v1.y, v2.y);
    }

    @Test
    void testOppositeC()
    {
        Vector2d v1 = new Vector2d(0, 0);
        Vector2d v2 = v1.opposite();
        assertEquals(-v1.x, v2.x);
        assertEquals(-v1.y, v2.y);
    }

    @Test
    void testOppositeD()
    {
        Vector2d v1 = new Vector2d(1, 0);
        Vector2d v2 = v1.opposite();
        assertEquals(-v1.x, v2.x);
        assertEquals(-v1.y, v2.y);
    }

    @Test
    void testOppositeE()
    {
        Vector2d v1 = new Vector2d(0, 1);
        Vector2d v2 = v1.opposite();
        assertEquals(-v1.x, v2.x);
        assertEquals(-v1.y, v2.y);
    }

    @Test
    void testOppositeF()
    {
        Vector2d v1 = new Vector2d(1, 1);
        Vector2d v2 = v1.opposite();
        assertEquals(-v1.x, v2.x);
        assertEquals(-v1.y, v2.y);
    }

    @Test
    void testEqualsA()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        assertTrue(v1.equals(v2));
    }

    @Test
    void testEqualsB()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 3);
        assertFalse(v1.equals(v2));
    }

    @Test
    void testEqualsC()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 2);
        assertFalse(v1.equals(v2));
    }

    @Test
    void testEqualsD()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(2, 3);
        assertFalse(v1.equals(v2));
    }

    @Test
    void testEqualsE()
    {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(1, 2);
        assertTrue(v1.equals(v2));
    }

    @Test
    void testHashCode()
    {
        int testSize = 10000;
        int upperbound = 100000000;
        Random rand = new Random(0);
        Vector2d[] vectorSet = new Vector2d[testSize];
        for (int i = 0; i < testSize; ++i)
        {
            int new_x = rand.nextInt(upperbound) - (upperbound / 2);
            int new_y = rand.nextInt(upperbound) - (upperbound / 2);
            vectorSet[i] = new Vector2d(new_x, new_y);
        }

        for (int i = 0; i < testSize; ++i)
        {
            for (int j = i; j < testSize; ++j)
            {
                if (i == j)
                {
                    assertEquals(vectorSet[i].hashCode(), vectorSet[j].hashCode());
                }
                else
                {
                    assertNotEquals(vectorSet[i].hashCode(), vectorSet[j].hashCode());
                }
            }
        }
    }
}