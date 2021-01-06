package Game1;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class MyFigures {


    public static void CircleR(int centerX, int centerY, int Radius, Color c, Graphics g) {
        g.setColor(c);
        g.drawOval(centerX - Radius, centerY - Radius, Radius * 2, Radius * 2);

    }

    public static void WheelR(int centerX, int centerY, int Radius, Color c, Graphics g) {
        g.setColor(c);
        g.fillOval(centerX - Radius, centerY - Radius, Radius * 2, Radius * 2);

    }

    public static void PointXY(int centerX, int centerY, Color c, Graphics g) {
        g.setColor(c);
        g.drawLine(centerX, centerY, centerX, centerY);

    }


}
