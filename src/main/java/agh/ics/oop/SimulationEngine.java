package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine
{
    private final List<MoveDirection> directions;
    private final AbstractWorldMap map;
    private final List<Animal> zoo;

    public SimulationEngine(List<MoveDirection> directions, AbstractWorldMap map, List<Vector2d> positions)
    {
        this.directions = directions;
        this.map = map;
        this.zoo = new ArrayList<>();

        for (Vector2d position : positions) {
            Animal animal = new Animal(this.map, position);
            this.map.place(animal);
            this.zoo.add(animal);
        }
    }

    @Override
    public List<String> run()
    {
        List<String> output = new ArrayList<>();
        System.out.println(map);
        output.add(map.toString());
        int animalsCount = zoo.size();
        for (int i = 0; i < directions.size(); i++)
        {
            zoo.get(i % animalsCount).move(directions.get(i));
            System.out.println(map);
            output.add(map.toString());
        }
        return output;
    }
}
