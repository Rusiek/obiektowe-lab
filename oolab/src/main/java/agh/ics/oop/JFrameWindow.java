package agh.ics.oop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JFrameWindow extends JFrame
{
    public JFrameWindow(String[] args)
    {
        super("JFrameWindow");
        java.util.List<MoveDirection> directions = new OptionsParser().parse(args);
        AbstractWorldMap map = new GrassField(10);
        java.util.List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4)));
        IEngine engine = new SimulationEngine(directions, map, positions);
        ArrayList<String> Frames = (ArrayList<String>) engine.run();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLayout(new GridLayout(1, 1));
        for (String frame : Frames)
        {
            JLabel newLabel = new JLabel(frame, SwingConstants.CENTER);
            this.add(newLabel);
            // Wait for 1 second before adding the next frame
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            // Delete last frame
            this.remove(newLabel);
        }
    }

    public static void main(String[] args)
    {
        new JFrameWindow(args);
    }
}
