package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap
{
    protected final List<AbstractWorldMapElement> mapElements = new ArrayList<>();
    protected final MapVisualizer mapVisualizer = new MapVisualizer(this);
    protected Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal)
    {
        boolean output = false;
        if (canMoveTo(animal.getPosition()))
        {
            mapElements.add(animal);
            output = true;
        }
        return output;
    }

    @Override
    public boolean isOccupied(Vector2d position)
    {
        boolean output = false;
        for (AbstractWorldMapElement mapElement: mapElements)
        {
            if (mapElement.getPosition().equals(position))
            {
                output = true;
                break;
            }
        }

        return output;
    }

    @Override
    public AbstractWorldMapElement objectAt(Vector2d position)
    {
        AbstractWorldMapElement output = null;
        for (AbstractWorldMapElement mapElement: mapElements)
        {
            if (mapElement.getPosition().equals(position))
            {
                output = mapElement;
                break;
            }
        }
        return output;
    }

    @Override
    public String toString()
    {
        return mapVisualizer.draw(lowerLeft, upperRight);
    }
}
