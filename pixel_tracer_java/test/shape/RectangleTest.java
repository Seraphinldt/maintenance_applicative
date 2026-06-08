package shape;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void testSetEtGetP1() {
        Rectangle r = new Rectangle();
        Point p = new Point();
        p.setPos_x(1);
        p.setPos_y(2);
        r.setP1(p);
        assertEquals(1, r.getP1().getPos_x());
        assertEquals(2, r.getP1().getPos_y());
    }

    @Test
    void testSetEtGetWidthHeight() {
        Rectangle r = new Rectangle();
        r.setWidth(10);
        r.setHeight(20);
        assertEquals(10, r.getWidth());
        assertEquals(20, r.getHeight());
    }

    @Test
    void testToString() {
        Rectangle r = new Rectangle();
        Point p = new Point();
        p.setPos_x(0);
        p.setPos_y(0);
        r.setP1(p);
        r.setWidth(5);
        r.setHeight(6);
        assertEquals("Rectangle[p1=Point[pos_x=0, pos_y=0], width=5, height=6]", r.toString());
    }
}