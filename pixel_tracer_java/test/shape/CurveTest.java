package shape;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CurveTest {

    @Test
    void testSetEtGetPoints() {
        Curve c = new Curve();
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        Point p4 = new Point();

        p1.setPos_x(0); p1.setPos_y(0);
        p2.setPos_x(1); p2.setPos_y(2);
        p3.setPos_x(3); p3.setPos_y(4);
        p4.setPos_x(5); p4.setPos_y(6);

        // On met les points dans la courbe
        c.setP1(p1);
        c.setP2(p2);
        c.setP3(p3);
        c.setP4(p4);

        assertEquals(0, c.getP1().getPos_x()); // x du premier point = 0
        assertEquals(6, c.getP4().getPos_y()); // y du dernier point = 6
    }

    @Test
    void testToString() {
        Curve c = new Curve();
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        Point p4 = new Point();

        p1.setPos_x(0); p1.setPos_y(0);
        p2.setPos_x(1); p2.setPos_y(2);
        p3.setPos_x(3); p3.setPos_y(4);
        p4.setPos_x(5); p4.setPos_y(6);

        c.setP1(p1); c.setP2(p2); c.setP3(p3); c.setP4(p4);

        assertEquals(
            "Curve[p1=Point{x=0, y=0, color=#000000}, p2=Point{x=1, y=2, color=#000000}, p3=Point{x=3, y=4, color=#000000}, p4=Point{x=5, y=6, color=#000000}]",
            c.toString()
        );
    }
}