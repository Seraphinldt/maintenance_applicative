package shape;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void testSetEtGetP1() {
        Line l = new Line();
        Point p = new Point();
        p.setPos_x(1);
        p.setPos_y(2);
        l.setP1(p); // premier point de la ligne
        assertEquals(1, l.getP1().getPos_x());
        assertEquals(2, l.getP1().getPos_y());
    }

    @Test
    void testSetEtGetP2() {
        Line l = new Line();
        Point p = new Point();
        p.setPos_x(5);
        p.setPos_y(9);
        l.setP2(p); // deuxième point de la ligne
        assertEquals(5, l.getP2().getPos_x());
        assertEquals(9, l.getP2().getPos_y());
    }

    @Test
    void testToString() {
        Line l = new Line();
        Point p1 = new Point();
        Point p2 = new Point();
        p1.setPos_x(0);
        p1.setPos_y(0);
        p2.setPos_x(4);
        p2.setPos_y(4);
        l.setP1(p1);
        l.setP2(p2);
        assertEquals("Line[p1=Point{x=0, y=0, color=#000000}, p2=Point{x=4, y=4, color=#000000}]", l.toString());
    }
}
