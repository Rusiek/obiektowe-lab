package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest
{
    @Test
    void testParse()
    {
        List<MoveDirection> directions = OptionsParser.parse(new String[]{"f", "forward", "b", "backward", "r", "right", "l", "left", "u", "unknown"});
        assertEquals(10, directions.size());
        assertEquals(directions.get(0), MoveDirection.FORWARD);
        assertEquals(directions.get(1), MoveDirection.FORWARD);
        assertEquals(directions.get(2), MoveDirection.BACKWARD);
        assertEquals(directions.get(3), MoveDirection.BACKWARD);
        assertEquals(directions.get(4), MoveDirection.RIGHT);
        assertEquals(directions.get(5), MoveDirection.RIGHT);
        assertEquals(directions.get(6), MoveDirection.LEFT);
        assertEquals(directions.get(7), MoveDirection.LEFT);
        assertEquals(directions.get(8), MoveDirection.UNKNOWN);
        assertEquals(directions.get(9), MoveDirection.UNKNOWN);
    }
}