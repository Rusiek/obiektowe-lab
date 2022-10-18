package agh.ics.oop;

public class OptionsParser
{
    public static MoveDirection[] parse(String[] args)
    {
        MoveDirection[] directions = new MoveDirection[args.length];
        int i = 0;
        for (String arg : args)
        {
            switch (arg)
            {
                case "f", "forward" -> directions[i] = MoveDirection.FORWARD;
                case "b", "backward" -> directions[i] = MoveDirection.BACKWARD;
                case "r", "right" -> directions[i] = MoveDirection.RIGHT;
                case "l", "left" -> directions[i] = MoveDirection.LEFT;
                default -> directions[i] = MoveDirection.UNKNOWN;
            }
            ++i;
        }
        return directions;
    }
}
