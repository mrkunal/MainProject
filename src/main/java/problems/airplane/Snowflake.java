package problems.airplane;

import java.awt.*;
import javax.swing.*;
import java.util.*;

// This program draws a Snowflake to a window.
// Written by Susan Haller and Erica Eddy
// Date: ???

public class Snowflake extends JFrame {
    public static void main (String [ ] args) {
        Snowflake world = new Snowflake();
        world.setVisible(true);
        world.run();
    }

    private static final long serialVersionUID = 0;

    private Queue<Line> lines = new LinkedList<Line>();
    private Queue<Line> done = new LinkedList<Line>();


    // The constructor
    public Snowflake () {
        setTitle("Fractal Snowflake"); setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Here is where all the work is done
    // We create a triangular snowflake and then
    // repeatedly subdivide its sides.
    public void run () {
        // insert first lines into snowflake
        Point a = new Point(100, 190);
        Point b = new Point(400, 190);
        Point c = new Point(250, 410);

        lines.offer(new Line(a, b));
        lines.offer(new Line(b, c));
        lines.offer(new Line(c, a));

        // now make the snowflake
        while (! lines.isEmpty()) {
            // ALTER THIS LINE FOR CHECKPOINT #5
            Line lne = (Line) lines.remove();
            processLine (lne);
            try {
                Thread.sleep(50);
            } catch(Exception e) { }
            repaint();
        }
    }

    // This method either subdivides the line into 4 parts
    // or, if small enough (less than 10 pixels in length) leaves it alone
    private void processLine (Line lne) {
        // first compute line lengths
        int dx = (lne.stop.x - lne.start.x)/3;
        int dy = (lne.stop.y - lne.start.y)/3;
        if ((dx * dx + dy * dy) < 10) {
            done.offer(lne); // line is too small
        } else {
            Point a = new Point (lne.start.x + dx, lne.start.y+dy);
            Point b = new Point (lne.start.x + 3*dx/2 + dy,
                    lne.start.y + 3*dy/2 - dx);
            Point c = new Point (lne.start.x+2*dx, lne.start.y+2*dy);
            lines.offer(new Line(lne.start, a));
            lines.offer(new Line(a, b));
            lines.offer(new Line(b, c));
            lines.offer(new Line(c, lne.stop));
        }
    }

    // This method draws the image to the window, both when it is first created and
    // anytime it need redrawing
    public void paint (Graphics g) {
        Iterator e = lines.iterator();
        while (e.hasNext()) {
            Line lne = (Line) e.next();
            lne.draw(g);
        }
        e = done.iterator();
        while (e.hasNext()) {
            Line lne = (Line) e.next();
            lne.draw(g);
        }
    }
}

// The line class is a second class in the same file as the Snowflake class.
// A file may have only 1 public class, but any number of non-public classes.
// The main method (if it exists) must be in the public class.
class Line {

    public Point start;
    public Point stop;

    Line (Point s, Point e) {
        start = s;
        stop = e;
    }

    public void draw (Graphics g) {
        g.drawLine(start.x, start.y, stop.x, stop.y);
    }
}


