package agh.ics.oop;

public enum MapDirection
{
    NORTH,
    SOUTH,
    WEST,
    EAST,
    UNKOWN;

    public String toString()
    {
        return switch (this)
        {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
            case UNKOWN -> "Nieznany";
        };
    }

    public MapDirection next()
    {
        return switch (this)
        {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case EAST -> SOUTH;
            case UNKOWN -> UNKOWN;
        };
    }

    public MapDirection previous()
    {
        return this.next().next().next();
    }

    public Vector2d toUnitVector()
    {
        return switch (this)
        {
            case NORTH -> new Vector2d(0, 1);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
            case EAST -> new Vector2d(1, 0);
            case UNKOWN -> new Vector2d(0, 0);
        };
    }
}
