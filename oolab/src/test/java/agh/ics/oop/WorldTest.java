package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest
{
    @Test
    void testConvertMiniBasicA()
    {
        String[] args = {"f"};
        Direction[] directions = World.convert(args);
        assertEquals(Direction.FORWARD, directions[0]);
    }

    @Test
    void testConvertMiniBasicB()
    {
        String[] args = {"b"};
        Direction[] directions = World.convert(args);
        assertEquals(Direction.BACKWARD, directions[0]);
    }

    @Test
    void testConvertMiniBasicC()
    {
        String[] args = {"l"};
        Direction[] directions = World.convert(args);
        assertEquals(Direction.LEFT, directions[0]);
    }

    @Test
    void testConvertMiniBasicD()
    {
        String[] args = {"r"};
        Direction[] directions = World.convert(args);
        assertEquals(Direction.RIGHT, directions[0]);
    }

    @Test
    void testConvertMiniBasicE()
    {
        String[] args = {"a", "c", "d", "e", "g", "h", "i", "j", "k", "m"};
        Direction[] directions = World.convert(args);
        for (int i = 0; i < args.length; ++i)
        {
            assertEquals(Direction.UNKNOWN, directions[i]);
        }
    }

    @Test
    void testConvertMiniBasicF()
    {
        String[] args = {"n", "o", "p", "s", "t", "u", "v", "w", "x", "y", "z"};
        Direction[] directions = World.convert(args);
        for (int i = 0; i < args.length; ++i)
        {
            assertEquals(Direction.UNKNOWN, directions[i]);
        }
    }

    @Test
    void testConvertBig()
    {
        int testSize = 1000000;
        String[] args = new String[testSize];
        for (int i = 0; i < testSize / 5; ++i)
        {
            args[i] = "f";
        }
        for (int i = testSize / 5; i < 2 * testSize / 5; ++i)
        {
            args[i] = "b";
        }
        for (int i = 2 * testSize / 5; i < 3 * testSize / 5; ++i)
        {
            args[i] = "l";
        }
        for (int i = 3 * testSize / 5; i < 4 * testSize / 5; ++i)
        {
            args[i] = "r";
        }
        for (int i = 4 * testSize / 5; i < testSize; ++i)
        {
            args[i] = "u";
        }

        Direction[] directions = World.convert(args);
        for (int i = 0; i < testSize / 5; ++i)
        {
            assertEquals(Direction.FORWARD, directions[i]);
        }
        for (int i = testSize / 5; i < 2 * testSize / 5; ++i)
        {
            assertEquals(Direction.BACKWARD, directions[i]);
        }
        for (int i = 2 * testSize / 5; i < 3 * testSize / 5; ++i)
        {
            assertEquals(Direction.LEFT, directions[i]);
        }
        for (int i = 3 * testSize / 5; i < 4 * testSize / 5; ++i)
        {
            assertEquals(Direction.RIGHT, directions[i]);
        }
        for (int i = 4 * testSize / 5; i < testSize; ++i)
        {
            assertEquals(Direction.UNKNOWN, directions[i]);
        }
    }

    @Test
    void testRun()
    {
        Direction[] directions = {Direction.FORWARD, Direction.BACKWARD, Direction.LEFT, Direction.RIGHT, Direction.UNKNOWN};
        StorePrintStream printStream = new StorePrintStream(System.out);
        System.setOut(printStream);
        World.run(directions);
        assertEquals("Zwierzak idzie do przodu", StorePrintStream.printList.get(0));
        assertEquals("Zwierzak idzie do tyłu", StorePrintStream.printList.get(1));
        assertEquals("Zwierzak skręca w lewo", StorePrintStream.printList.get(2));
        assertEquals("Zwierzak skręca w prawo", StorePrintStream.printList.get(3));
        assertEquals("Nieznany kierunek", StorePrintStream.printList.get(4));
    }

}