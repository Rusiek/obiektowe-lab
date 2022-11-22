package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest
{
    GrassField map;
    Vector2d initialPosition;
    Vector2d bigPosition;
    Animal animal;

    @BeforeEach
    void SetUp()
    {
        map = new GrassField(10);
        initialPosition = new Vector2d(0, 0);
        bigPosition = new Vector2d(100, 100);
        animal = new Animal(map, initialPosition);
    }

    @Test
    void canMoveToTest_A()
    {
        assertTrue(map.canMoveTo(new Vector2d(-1, 0)));
        assertTrue(map.canMoveTo(new Vector2d(0, -1)));
        assertTrue(map.canMoveTo(bigPosition));
        assertTrue(map.canMoveTo(initialPosition));
        map.place(animal);
        assertFalse(map.canMoveTo(animal.getPosition()));
        assertTrue(map.canMoveTo(bigPosition));
    }

    @Test
    void placeTest()
    {
        assertTrue(map.place(animal));
        assertFalse(map.place(animal));
        animal.move(MoveDirection.FORWARD);
        assertFalse(map.place(animal));
    }

    @Test
    void isOccupiedTest()
    {
        assertFalse(map.isOccupied(bigPosition));
        map.place(animal);
        assertTrue(map.isOccupied(animal.getPosition()));
    }

    @Test
    void objectAtTest()
    {
        map.place(animal);
        assertEquals(animal, map.objectAt(animal.getPosition()));
        assertNull(map.objectAt(bigPosition));
    }
}