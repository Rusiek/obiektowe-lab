package agh.ics.oop;

import java.util.Objects;

public class Animal
{
    private MapDirection orientation;
    private Vector2d position;

    public Animal()
    {
        this.orientation = MapDirection.NORTH;
        int startValue = 2;
        this.position = new Vector2d(startValue, startValue);
    }

    public String toString()
    {
        return "Zwierzak jest w punkcie: " +
                this.position.toString() +
                "\nPatrzy w kierunku: " +
                this.orientation.toString();
    }

    public boolean isAt(Vector2d position)
    {
        return this.position.equals(position);
    }

    public boolean isOutsideMap(Vector2d position)
    {
        int maxValue = 4;
        int minValue = 0;
        return position.x > maxValue || position.x < minValue || position.y > maxValue || position.y < minValue;
    }

    public Animal move(MoveDirection direction)
    {
        switch (direction)
        {
            case FORWARD ->
            {
                this.position = this.position.add(Objects.requireNonNull(this.orientation.toUnitVector()));
                if (this.isOutsideMap(this.position))
                {
                    this.position = this.position.subtract(Objects.requireNonNull(this.orientation.toUnitVector()));
                }
            }
            case BACKWARD ->
            {
                this.position = this.position.subtract(Objects.requireNonNull(this.orientation.toUnitVector()));
                if (this.isOutsideMap(this.position))
                {
                    this.position = this.position.add(Objects.requireNonNull(this.orientation.toUnitVector()));
                }
            }
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case UNKNOWN -> {}
        }

        return this;
    }
}
