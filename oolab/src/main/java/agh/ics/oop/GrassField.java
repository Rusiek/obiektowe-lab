package agh.ics.oop;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GrassField extends AbstractWorldMap
{
    private final int maxCoord;


    public GrassField(int grassFieldsCount)
    {
        maxCoord = (int) Math.ceil(Math.sqrt(grassFieldsCount * 10));

        List<Integer> new_x = IntStream.rangeClosed(0, maxCoord).boxed().collect(Collectors.toList());
        List<Integer> new_y = IntStream.rangeClosed(0, maxCoord).boxed().collect(Collectors.toList());
        Collections.shuffle(new_x);
        Collections.shuffle(new_y);

        for (int i = 0; i < grassFieldsCount; i++)
        {
            mapElements.add(new Grass(new Vector2d(new_x.get(i), new_y.get(i))));
        }
    }

    @Override
    public AbstractWorldMapElement objectAt(Vector2d position)
    {
        AbstractWorldMapElement mapElementAt = null;
        for (AbstractWorldMapElement mapElement: mapElements)
        {
            if (mapElement.getPosition().equals(position))
            {
                if (mapElement instanceof Animal)
                {
                    return mapElement;
                }
                else
                {
                    mapElementAt = mapElement;
                }
            }
        }

        return mapElementAt;
    }

    @Override
    public String toString()
    {
        for (AbstractWorldMapElement mapElement: mapElements)
        {
            upperRight = upperRight.upperRight(mapElement.getPosition());
            lowerLeft = lowerLeft.lowerLeft(mapElement.getPosition());
        }

        return super.toString();
    }

    public void spawnGrass()
    {
        Vector2d position;
        do
        {
            int x = (int) (Math.random() * maxCoord);
            int y = (int) (Math.random() * maxCoord);
            position = new Vector2d(x, y);
        } while(objectAt(position) == null);

        mapElements.add(new Grass(position));
    }
}
