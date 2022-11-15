package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RectangularMapTest
{
    RectangularMap map;
    Animal animal1;
    Animal animal2;

    @Test
    void testCanMoveTo()
    {
        map = new RectangularMap(10, 5);
        animal1 = new Animal(map, new Vector2d(2, 2));
        animal2 = new Animal(map, new Vector2d(3, 4));
        map.place(animal1);
        map.place(animal2);
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
        assertFalse(map.canMoveTo(new Vector2d(3, 4)));
        assertTrue(map.canMoveTo(new Vector2d(2, 3)));
        assertTrue(map.canMoveTo(new Vector2d(3, 2)));
        assertTrue(map.canMoveTo(new Vector2d(2, 1)));
        assertTrue(map.canMoveTo(new Vector2d(1, 2)));
        assertTrue(map.canMoveTo(new Vector2d(3, 3)));
        assertTrue(map.canMoveTo(new Vector2d(4, 3)));
        animal1.move(MoveDirection.FORWARD).move(MoveDirection.FORWARD);
        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        assertFalse(map.canMoveTo(new Vector2d(3, 4)));
        assertFalse(map.canMoveTo(new Vector2d(2, 4)));
        assertTrue(map.canMoveTo(new Vector2d(2, 3)));
        animal1.move(MoveDirection.FORWARD);
        assertFalse(map.canMoveTo(new Vector2d(2, 4)));
    }


    @Test
    void testPlace()
    {
        RectangularMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal(map, new Vector2d(2, 2));
        Animal animal2 = new Animal(map, new Vector2d(3, 4));
        Animal animal3 = new Animal(map, new Vector2d(2, 2));
        Animal animal4 = new Animal(map, new Vector2d(6, 6));
        assertTrue(map.place(animal1));
        assertTrue(map.place(animal2));
        assertFalse(map.place(animal3));
        assertFalse(map.place(animal4));
    }

    @Test
    void testIsOccupied()
    {
        RectangularMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal(map, new Vector2d(2, 2));
        Animal animal2 = new Animal(map, new Vector2d(3, 4));
        map.place(animal1);
        map.place(animal2);
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(3, 4)));
        assertFalse(map.isOccupied(new Vector2d(2, 3)));
        assertFalse(map.isOccupied(new Vector2d(3, 2)));
        assertFalse(map.isOccupied(new Vector2d(2, 1)));
        assertFalse(map.isOccupied(new Vector2d(1, 2)));
        assertFalse(map.isOccupied(new Vector2d(3, 3)));
        assertFalse(map.isOccupied(new Vector2d(4, 3)));
        animal1.move(MoveDirection.FORWARD).move(MoveDirection.FORWARD);
        assertFalse(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(3, 4)));
        assertTrue(map.isOccupied(new Vector2d(2, 4)));
        assertFalse(map.isOccupied(new Vector2d(2, 3)));
        animal1.move(MoveDirection.FORWARD);
        assertTrue(map.isOccupied(new Vector2d(2, 4)));
    }

    @Test
    void testObjectAt()
    {
        RectangularMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal(map, new Vector2d(2, 2));
        Animal animal2 = new Animal(map, new Vector2d(3, 4));
        Animal animal3 = new Animal(map, new Vector2d(6, 6));
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);
        assertEquals(animal1, map.objectAt(new Vector2d(2, 2)));
        assertEquals(animal2, map.objectAt(new Vector2d(3, 4)));
        assertNull(map.objectAt(new Vector2d(2, 3)));
        assertNull(map.objectAt(new Vector2d(3, 2)));
        assertNull(map.objectAt(new Vector2d(2, 1)));
        assertNull(map.objectAt(new Vector2d(1, 2)));
        assertNull(map.objectAt(new Vector2d(3, 3)));
        assertNull(map.objectAt(new Vector2d(4, 3)));
        animal1.move(MoveDirection.FORWARD).move(MoveDirection.FORWARD);
        assertNull(map.objectAt(new Vector2d(2, 2)));
        assertEquals(animal2, map.objectAt(new Vector2d(3, 4)));
        assertEquals(animal1, map.objectAt(new Vector2d(2, 4)));
        assertNull(map.objectAt(new Vector2d(2, 3)));
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1, map.objectAt(new Vector2d(2, 4)));
    }
}