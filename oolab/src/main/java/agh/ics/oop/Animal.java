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
        return "Zwierzak jest w punkcie: " + this.position.toString() + "\nPatrzy w kierunku: " + this.orientation.toString();
    }

    public boolean isAt(Vector2d position)
    {
        return this.position.equals(position);
    }

    public Animal move(MoveDirection direction)
    {
        int maxValue = 4;
        int minValue = 0;
        switch (direction)
        {
            case FORWARD ->
            {
                if (this.position.y < maxValue && this.orientation == MapDirection.NORTH)
                {
                    this.position = this.position.add(Objects.requireNonNull(this.orientation.toUnitVector()));
                }
                else if (this.position.x < maxValue && this.orientation == MapDirection.EAST)
                {
                    this.position = this.position.add(Objects.requireNonNull(this.orientation.toUnitVector()));
                }
                else if (this.position.y > minValue && this.orientation == MapDirection.SOUTH)
                {
                    this.position = this.position.add(Objects.requireNonNull(this.orientation.toUnitVector()));
                }
                else if (this.position.x > minValue && this.orientation == MapDirection.WEST)
                {
                    this.position = this.position.add(Objects.requireNonNull(this.orientation.toUnitVector()));
                }
            }
            case BACKWARD ->
            {
                if (this.position.y < maxValue && this.orientation == MapDirection.SOUTH)
                {
                    this.position = this.position.subtract(Objects.requireNonNull(this.orientation.toUnitVector()));
                }
                else if (this.position.x < maxValue && this.orientation == MapDirection.WEST)
                {
                    this.position = this.position.subtract(Objects.requireNonNull(this.orientation.toUnitVector()));
                }
                else if (this.position.y > minValue && this.orientation == MapDirection.NORTH)
                {
                    this.position = this.position.subtract(Objects.requireNonNull(this.orientation.toUnitVector()));
                }
                else if (this.position.x > minValue && this.orientation == MapDirection.EAST)
                {
                    this.position = this.position.subtract(Objects.requireNonNull(this.orientation.toUnitVector()));
                }
            }
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case UNKNOWN -> {}
        }

        return this;
    }
}
