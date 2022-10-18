package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest
{
    @Test
    void testToStringA()
    {
        Animal animal = new Animal();
        assertEquals("Zwierzak jest w punkcie: (2,2)\nPatrzy w kierunku: Północ", animal.toString());
    }

    @Test
    void testToStringB()
    {
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD)
                .move(MoveDirection.FORWARD)
                .move(MoveDirection.RIGHT)
                .move(MoveDirection.BACKWARD);
        assertEquals("Zwierzak jest w punkcie: (1,4)\nPatrzy w kierunku: Wschód", animal.toString());
    }

    @Test
    void testIsAtA()
    {
        Animal animal = new Animal();
        assertTrue(animal.isAt(new Vector2d(2, 2)));
    }

    @Test
    void testIsAtB()
    {
        Animal animal = new Animal();
        assertFalse(animal.isAt(new Vector2d(2, 3)));
    }

    @Test
    void testIsAtC()
    {
        Animal animal = new Animal();
        assertFalse(animal.isAt(new Vector2d(3, 2)));
    }

    @Test
    void testIsAtD()
    {
        Animal animal = new Animal();
        assertFalse(animal.isAt(new Vector2d(3, 3)));
    }

    @Test
    void testMoveA()
    {
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2, 3)));
    }

    @Test
    void testMoveB()
    {
        Animal animal = new Animal();
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(2, 1)));
    }

    @Test
    void testMoveC()
    {
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT);
        assertFalse(animal.isAt(new Vector2d(3, 2)));
    }

    @Test
    void testMoveD()
    {
        Animal animal = new Animal();
        animal.move(MoveDirection.LEFT);
        assertFalse(animal.isAt(new Vector2d(1, 2)));
    }

    @Test
    void testMoveE()
    {
        Animal animal = new Animal();
        animal.move(MoveDirection.UNKNOWN);
        assertTrue(animal.isAt(new Vector2d(2, 2)));
    }

    @Test
    void testMoveF()
    {
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD)
                .move(MoveDirection.FORWARD)
                .move(MoveDirection.FORWARD)
                .move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2, 4)));
    }

    @Test
    void testMoveG()
    {
        Animal animal = new Animal();
        animal.move(MoveDirection.BACKWARD)
                .move(MoveDirection.BACKWARD)
                .move(MoveDirection.BACKWARD)
                .move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(2, 0)));
    }

    @Test
    void testMoveH()
    {
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT)
                .move(MoveDirection.RIGHT)
                .move(MoveDirection.RIGHT)
                .move(MoveDirection.RIGHT);
        assertTrue(animal.isAt(new Vector2d(2, 2)));
    }

    @Test
    void testMoveI()
    {
        Animal animal = new Animal();
        animal.move(MoveDirection.LEFT)
                .move(MoveDirection.LEFT)
                .move(MoveDirection.LEFT)
                .move(MoveDirection.LEFT);
        assertTrue(animal.isAt(new Vector2d(2, 2)));
    }

    @Test
    void testMoveJ()
    {
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD)
                .move(MoveDirection.BACKWARD)
                .move(MoveDirection.RIGHT)
                .move(MoveDirection.LEFT);
        assertTrue(animal.isAt(new Vector2d(2, 2)));
    }

    @Test
    void testMoveK()
    {
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD)
                .move(MoveDirection.RIGHT)
                .move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(3, 3)));
    }
}