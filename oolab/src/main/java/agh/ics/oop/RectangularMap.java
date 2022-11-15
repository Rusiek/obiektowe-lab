package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap
{
    private final int width;
    private final int height;
    private final List<Animal> zoo = new ArrayList<>();
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    public RectangularMap(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Vector2d position)
    {
        boolean output = false;
        if (new Vector2d(0, 0).precedes(position) &&
            new Vector2d(this.width - 1, this.height - 1).follows(position))
        {
            output = !isOccupied(position);
        }
        return output;
    }

    @Override
    public boolean place(Animal animal)
    {
        boolean output = false;
        if (!isOccupied(animal.getPosition()) &&
             animal.getPosition().precedes(new Vector2d(this.width, this.height)) &&
             animal.getPosition().follows(new Vector2d(0, 0)))
        {
            zoo.add(animal);
            output = true;
        }

        return output;
    }

    @Override
    public boolean isOccupied(Vector2d position)
    {
        boolean output = false;
        for (Animal animal : zoo)
        {
            if (animal.getPosition().equals(position))
            {
                output = true;
                break;
            }
        }

        return output;
    }

    @Override
    public Object objectAt(Vector2d position)
    {
        Object output = null;
        for (Animal animal : this.zoo)
        {
            if (animal.getPosition().equals(position))
            {
                output = animal;
                break;
            }
        }

        return output;
    }

    @Override
    public String toString()
    {
        return this.mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(this.width - 1, this.height - 1));
    }
}
