package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void testToString()
    {
        assertEquals("Północ", MapDirection.NORTH.toString());
        assertEquals("Południe", MapDirection.SOUTH.toString());
        assertEquals("Zachód", MapDirection.WEST.toString());
        assertEquals("Wschód", MapDirection.EAST.toString());
        assertEquals("Nieznany", MapDirection.UNKOWN.toString());
    }

    @Test
    void testNext()
    {
        assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
        assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
        assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
        assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
        assertEquals(MapDirection.UNKOWN, MapDirection.UNKOWN.next());
    }

    @Test
    void testPrevious()
    {
        assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
        assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
        assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
        assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
        assertEquals(MapDirection.UNKOWN, MapDirection.UNKOWN.previous());
    }

    @Test
    void testToUnitVector()
    {
        assertEquals(new Vector2d(0, 1), MapDirection.NORTH.toUnitVector());
        assertEquals(new Vector2d(0, -1), MapDirection.SOUTH.toUnitVector());
        assertEquals(new Vector2d(-1, 0), MapDirection.WEST.toUnitVector());
        assertEquals(new Vector2d(1, 0), MapDirection.EAST.toUnitVector());
        assertEquals(new Vector2d(0, 0), MapDirection.UNKOWN.toUnitVector());
    }

    @Test
    void testValues()
    {
        MapDirection[] directions = MapDirection.values();
        assertEquals(5, directions.length);
        assertEquals(MapDirection.NORTH, directions[0]);
        assertEquals(MapDirection.SOUTH, directions[1]);
        assertEquals(MapDirection.WEST, directions[2]);
        assertEquals(MapDirection.EAST, directions[3]);
        assertEquals(MapDirection.UNKOWN, directions[4]);
    }

    @Test
    void testValueOf()
    {
        assertEquals(MapDirection.NORTH, MapDirection.valueOf("NORTH"));
        assertEquals(MapDirection.SOUTH, MapDirection.valueOf("SOUTH"));
        assertEquals(MapDirection.WEST, MapDirection.valueOf("WEST"));
        assertEquals(MapDirection.EAST, MapDirection.valueOf("EAST"));
        assertEquals(MapDirection.UNKOWN, MapDirection.valueOf("UNKOWN"));
    }
}