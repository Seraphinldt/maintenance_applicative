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
            "Curve[p1=Point[pos_x=0, pos_y=0], p2=Point[pos_x=1, pos_y=2], p3=Point[pos_x=3, pos_y=4], p4=Point[pos_x=5, pos_y=6]]",
            c.toString()
        );
    }
}