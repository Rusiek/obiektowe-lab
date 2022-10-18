package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void values()
    {
        Direction[] directions = Direction.values();
        assertEquals(5, directions.length);
        assertEquals(Direction.FORWARD, directions[0]);
        assertEquals(Direction.BACKWARD, directions[1]);
        assertEquals(Direction.RIGHT, directions[2]);
        assertEquals(Direction.LEFT, directions[3]);
        assertEquals(Direction.UNKNOWN, directions[4]);
    }

    @Test
    void valueOf()
    {
        assertEquals(Direction.FORWARD, Direction.valueOf("FORWARD"));
        assertEquals(Direction.BACKWARD, Direction.valueOf("BACKWARD"));
        assertEquals(Direction.RIGHT, Direction.valueOf("RIGHT"));
        assertEquals(Direction.LEFT, Direction.valueOf("LEFT"));
        assertEquals(Direction.UNKNOWN, Direction.valueOf("UNKNOWN"));
    }
}