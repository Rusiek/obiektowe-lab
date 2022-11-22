package agh.ics.oop;

public class Animal extends AbstractWorldMapElement
{
    private MapDirection orientation = MapDirection.NORTH;
    private final AbstractWorldMap map;

    public Animal(AbstractWorldMap map, Vector2d initialPosition)
    {
        this.map = map;
        this.position = initialPosition;
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

                    if (objectAt == null || objectAt instanceof Grass)
                    {
                        position = newPosition;
                    }

                    if (eatAttempt(objectAt))
                    {
                        ((GrassField) map).spawnGrass();
                    }
                }
            }
        }
    }
    private boolean eatAttempt(Object objectAt)
    {
        boolean output = false;
        if (objectAt instanceof Grass)
        {
            map.mapElements.remove(objectAt);
            output = true;
        }
        return output;
    }
}
