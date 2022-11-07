package agh.ics.oop;

public class World
{
//    //lab 2
//    public static void main(String[] args)
//    {
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
//    }

    // lab 3
    public static void main(String[] args)
    {
        Animal animal = new Animal();
        MoveDirection[] move = OptionsParser.parse(args);
        System.out.println(animal);
        for (MoveDirection direction : move)
        {
            animal.move(direction);
        }
        System.out.println(animal.isAt(new Vector2d(4, 2)));
    }

//    //lab 4
//    public static void main(String[] args)
//    {
//
//    }


    public static Direction[] convert(String[] args)
    {
        Direction[] directions = new Direction[args.length];
        for (int i = 0; i < args.length; ++i)
        {
            switch (args[i])
            {
                case "f" -> directions[i] = Direction.FORWARD;
                case "b" -> directions[i] = Direction.BACKWARD;
                case "r" -> directions[i] = Direction.RIGHT;
                case "l" -> directions[i] = Direction.LEFT;
                default -> directions[i] = Direction.UNKNOWN;
            }
        }
        return directions;
    }

    public static void run(Direction[] directions)
    {
        for (Direction direction : directions)
        {
            switch (direction)
            {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case LEFT -> System.out.println("Zwierzak skręca w lewo");
                default -> System.out.println("Nieznany kierunek");
            }
        }
    }
}
