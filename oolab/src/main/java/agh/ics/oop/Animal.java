package agh.ics.oop;

import java.util.ArrayList;

public class Animal
{
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(0,0);
    private IWorldMap map;


    public Animal() { }

    public Animal(IWorldMap map)
    {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition)
    {
        this.map = map;
        this.position = initialPosition;
    }

    public String toString()
    {
        return switch (orientation)
        {
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
            default -> "?";
        };
    }

    public boolean isAt(Vector2d position)
    {
        return position.equals(position);
    }

    public Vector2d getPosition()
    {
        return position;
    }

    public Animal move(MoveDirection direction)
    {
        switch (direction)
        {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD, BACKWARD ->
            {
                Vector2d newMove = orientation.toUnitVector();
                if (direction == MoveDirection.BACKWARD)
                {
                    newMove = newMove.opposite();
                }

                Vector2d newPosition = position.add(newMove);

                if (map.canMoveTo(newPosition))
                {
                    position = newPosition;
                }
            }
        }
        return this;
    }
}
