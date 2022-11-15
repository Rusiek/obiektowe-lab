package agh.ics.oop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SimulationEngineTest {


    @Test
    void testRun()
    {
        List<MoveDirection> directions = new ArrayList<>();
        IWorldMap map = new RectangularMap(4, 4);
        List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(0, 0), new Vector2d(3, 3)));
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.BACKWARD);
        directions.add(MoveDirection.RIGHT);
        directions.add(MoveDirection.LEFT);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.LEFT);
        directions.add(MoveDirection.LEFT);
        directions.add(MoveDirection.FORWARD);
        directions.add(MoveDirection.FORWARD);
        IEngine engine = new SimulationEngine(directions, map, positions);
        List<String> output = engine.run();

        assertEquals(output.get(0),
                        "<html>y\\x  0 1 2 3\r\n" +
                        "<br>  4: ---------\r\n" +
                        "<br>  3: | | | |^|\r\n" +
                        "<br>  2: | | | | |\r\n" +
                        "<br>  1: | | | | |\r\n" +
                        "<br>  0: |^| | | |\r\n" +
                        "<br> -1: ---------\r\n" +
                        "<br></html>");
        assertEquals(output.get(1),
                        "<html>y\\x  0 1 2 3\r\n" +
                        "<br>  4: ---------\r\n" +
                        "<br>  3: | | | |^|\r\n" +
                        "<br>  2: | | | | |\r\n" +
                        "<br>  1: |^| | | |\r\n" +
                        "<br>  0: | | | | |\r\n" +
                        "<br> -1: ---------\r\n" +
                        "<br></html>");
        assertEquals(output.get(2),
                        "<html>y\\x  0 1 2 3\r\n" +
                        "<br>  4: ---------\r\n" +
                        "<br>  3: | | | | |\r\n" +
                        "<br>  2: | | | |^|\r\n" +
                        "<br>  1: |^| | | |\r\n" +
                        "<br>  0: | | | | |\r\n" +
                        "<br> -1: ---------\r\n" +
                        "<br></html>");
        assertEquals(output.get(3),
                        "<html>y\\x  0 1 2 3\r\n" +
                        "<br>  4: ---------\r\n" +
                        "<br>  3: | | | | |\r\n" +
                        "<br>  2: | | | |^|\r\n" +
                        "<br>  1: |>| | | |\r\n" +
                        "<br>  0: | | | | |\r\n" +
                        "<br> -1: ---------\r\n" +
                        "<br></html>");
        assertEquals(output.get(4),
                        "<html>y\\x  0 1 2 3\r\n" +
                        "<br>  4: ---------\r\n" +
                        "<br>  3: | | | | |\r\n" +
                        "<br>  2: | | | |<|\r\n" +
                        "<br>  1: |>| | | |\r\n" +
                        "<br>  0: | | | | |\r\n" +
                        "<br> -1: ---------\r\n" +
                        "<br></html>");
        assertEquals(output.get(5),
                        "<html>y\\x  0 1 2 3\r\n" +
                        "<br>  4: ---------\r\n" +
                        "<br>  3: | | | | |\r\n" +
                        "<br>  2: | | | |<|\r\n" +
                        "<br>  1: | |>| | |\r\n" +
                        "<br>  0: | | | | |\r\n" +
                        "<br> -1: ---------\r\n" +
                        "<br></html>");
        assertEquals(output.get(6),
                        "<html>y\\x  0 1 2 3\r\n" +
                        "<br>  4: ---------\r\n" +
                        "<br>  3: | | | | |\r\n" +
                        "<br>  2: | | |<| |\r\n" +
                        "<br>  1: | |>| | |\r\n" +
                        "<br>  0: | | | | |\r\n" +
                        "<br> -1: ---------\r\n" +
                        "<br></html>");
        assertEquals(output.get(7),
                        "<html>y\\x  0 1 2 3\r\n" +
                        "<br>  4: ---------\r\n" +
                        "<br>  3: | | | | |\r\n" +
                        "<br>  2: | | |<| |\r\n" +
                        "<br>  1: | | |>| |\r\n" +
                        "<br>  0: | | | | |\r\n" +
                        "<br> -1: ---------\r\n" +
                        "<br></html>");
        assertEquals(output.get(8),
                        "<html>y\\x  0 1 2 3\r\n" +
                        "<br>  4: ---------\r\n" +
                        "<br>  3: | | | | |\r\n" +
                        "<br>  2: | | |v| |\r\n" +
                        "<br>  1: | | |>| |\r\n" +
                        "<br>  0: | | | | |\r\n" +
                        "<br> -1: ---------\r\n" +
                        "<br></html>");
        for (int i = 9; i < 12; ++i)
        {
            assertEquals(output.get(i),
                        "<html>y\\x  0 1 2 3\r\n" +
                        "<br>  4: ---------\r\n" +
                        "<br>  3: | | | | |\r\n" +
                        "<br>  2: | | |v| |\r\n" +
                        "<br>  1: | | |^| |\r\n" +
                        "<br>  0: | | | | |\r\n" +
                        "<br> -1: ---------\r\n" +
                        "<br></html>");
        }


    }
}