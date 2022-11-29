package agh.ics.oop;

import java.util.LinkedHashMap;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver
{
    protected final LinkedHashMap<Vector2d, AbstractWorldMapElement> mapElements = new LinkedHashMap<>();
    protected final MapVisualizer mapVisualizer = new MapVisualizer(this);
    protected Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean isOccupied(Vector2d position)
    {
        return mapElements.get(position) != null;
    }

    @Override
    public boolean place(Animal animal)
    {
        boolean output = false;
        if (canMoveTo(animal.getPosition()))
        {
            mapElements.put(animal.getPosition(), animal);
            output = true;
        }
        return output;
    }

    @Override
    public AbstractWorldMapElement objectAt(Vector2d position)
    {
        return mapElements.get(position);
    }

    @Override
    public String toString()
    {
        return mapVisualizer.draw(lowerLeft, upperRight);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition)
    {
        AbstractWorldMapElement mapElement = this.mapElements.remove(oldPosition);
        this.mapElements.put(newPosition, mapElement);
    }
}
