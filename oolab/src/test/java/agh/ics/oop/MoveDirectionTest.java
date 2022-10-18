package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveDirectionTest {

    @Test
    void values()
    {
        MoveDirection[] directions = MoveDirection.values();
        assertEquals(5, directions.length);
        assertEquals(MoveDirection.FORWARD, directions[0]);
        assertEquals(MoveDirection.BACKWARD, directions[1]);
        assertEquals(MoveDirection.RIGHT, directions[2]);
        assertEquals(MoveDirection.LEFT, directions[3]);
        assertEquals(MoveDirection.UNKNOWN, directions[4]);
    }

    @Test
    void valueOf()
    {
        assertEquals(MoveDirection.FORWARD, MoveDirection.valueOf("FORWARD"));
        assertEquals(MoveDirection.BACKWARD, MoveDirection.valueOf("BACKWARD"));
        assertEquals(MoveDirection.RIGHT, MoveDirection.valueOf("RIGHT"));
        assertEquals(MoveDirection.LEFT, MoveDirection.valueOf("LEFT"));
        assertEquals(MoveDirection.UNKNOWN, MoveDirection.valueOf("UNKNOWN"));
    }
}