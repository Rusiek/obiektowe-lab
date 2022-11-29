package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
public class Animal extends AbstractWorldMapElement
{
    private MapDirection orientation = MapDirection.NORTH;
    private final AbstractWorldMap map;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(AbstractWorldMap map, Vector2d initialPosition)
    {
        this.map = map;
        this.position = initialPosition;
        this.addObserver(map);
    }

    @Override
    public String toString()
    {
        return switch (orientation)
        {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
            default -> "?";
        };
    }

    public void move(MoveDirection direction)
    {
        switch (direction)
        {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD, BACKWARD ->
            {
                Vector2d unitVector = orientation.toUnitVector();
                if (direction == MoveDirection.BACKWARD)
                {
                    unitVector = unitVector.opposite();
                }
                Vector2d newPosition = position.add(unitVector);

                if (map.canMoveTo(newPosition))
                {
                    Object objectAt = map.objectAt(newPosition);

                    if (objectAt instanceof Grass)
                    {
                        map.mapElements.remove(objectAt);
                        positionChanged(position, newPosition);
                        position = newPosition;
                        ((GrassField) map).newGrass();
                    }
                    else if (objectAt == null)
                    {
                        positionChanged(position, newPosition);
                        position = newPosition;
                    }
                }
            }
        }
    }

    private void addObserver(IPositionChangeObserver observer)
    {
        observers.add(observer);
    }

    private void removeObserver(IPositionChangeObserver observer)
    {
        observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition)
    {
        for (IPositionChangeObserver observer : this.observers)
        {
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
