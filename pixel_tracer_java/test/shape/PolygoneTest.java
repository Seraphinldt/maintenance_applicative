package shape;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class PolygoneTest {

    @Test
    void testSetEtGetPoints() {
        Polygone poly = new Polygone();
        ArrayList<Point> points = new ArrayList<>();
        Point p = new Point();
        p.setPos_x(1);
        p.setPos_y(2);
        points.add(p);
        poly.setPoints(points);
        assertEquals(1, poly.getPoints().size());
        assertEquals(1, poly.getPoints().get(0).getPos_x());
    }

    @Test
    void testPointsParDefautEstNull() {
        Polygone poly = new Polygone();
        assertEquals(new ArrayList<>(), poly.getPoints());
    }

    @Test
    void testToString() {
        Polygone poly = new Polygone();
        ArrayList<Point> points = new ArrayList<>();
        Point p = new Point();
        p.setPos_x(0);
        p.setPos_y(1);
        points.add(p);
        poly.setPoints(points);
        assertEquals("Polygone{Shape[id=1, fill= , thickness=1.0, color=#000000, rotation=0.0], points=[Point{x=0, y=1, color=#000000}]}", poly.toString());
    }
}
