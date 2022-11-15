package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest
{
    Animal animal;
    @BeforeEach
    void setUp()
    {
        animal = new Animal(new RectangularMap(5, 5), new Vector2d(2, 2));
    }

    @Test
    void testIsAtA()
    {
        assertTrue(animal.isAt(new Vector2d(2, 2)));
    }

    @Test
    void testIsAtB()
    {
        assertFalse(animal.isAt(new Vector2d(2, 3)));
    }

    @Test
    void testIsAtC()
    {
        assertFalse(animal.isAt(new Vector2d(3, 2)));
    }

    @Test
    void testIsAtD()
    {
        assertFalse(animal.isAt(new Vector2d(3, 3)));
    }

    @Test
    void testMoveA()
    {
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2, 3)));
    }

    @Test
    void testMoveB()
    {
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(2, 1)));
    }

    @Test
    void testMoveC()
    {
        animal.move(MoveDirection.RIGHT);
        assertFalse(animal.isAt(new Vector2d(3, 2)));
    }

    @Test
    void testMoveD()
    {
        animal.move(MoveDirection.LEFT);
        assertFalse(animal.isAt(new Vector2d(1, 2)));
    }

    @Test
    void testMoveE()
    {
        animal.move(MoveDirection.UNKNOWN);
        assertTrue(animal.isAt(new Vector2d(2, 2)));
    }

    @Test
    void testMoveF()
    {
        animal.move(MoveDirection.FORWARD)
                .move(MoveDirection.FORWARD)
                .move(MoveDirection.FORWARD)
                .move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2, 4)));
    }

    @Test
    void testMoveG()
    {
        animal.move(MoveDirection.BACKWARD)
                .move(MoveDirection.BACKWARD)
                .move(MoveDirection.BACKWARD)
                .move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(2, 0)));
    }

    @Test
    void testMoveH()
    {
        animal.move(MoveDirection.RIGHT)
                .move(MoveDirection.RIGHT)
                .move(MoveDirection.RIGHT)
                .move(MoveDirection.RIGHT);
        assertTrue(animal.isAt(new Vector2d(2, 2)));
    }

    @Test
    void testMoveI()
    {
        animal.move(MoveDirection.LEFT)
                .move(MoveDirection.LEFT)
                .move(MoveDirection.LEFT)
                .move(MoveDirection.LEFT);
        assertTrue(animal.isAt(new Vector2d(2, 2)));
    }

    @Test
    void testMoveJ()
    {
        animal.move(MoveDirection.FORWARD)
                .move(MoveDirection.BACKWARD)
                .move(MoveDirection.RIGHT)
                .move(MoveDirection.LEFT);
        assertTrue(animal.isAt(new Vector2d(2, 2)));
    }

    @Test
    void testMoveK()
    {
        animal.move(MoveDirection.FORWARD)
                .move(MoveDirection.RIGHT)
                .move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(3, 3)));
    }
}