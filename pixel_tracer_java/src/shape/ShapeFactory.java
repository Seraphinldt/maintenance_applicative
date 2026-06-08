package shape;

import java.util.ArrayList;
import id.Id;

public class ShapeFactory {
    public static Shape createPointShape(int px, int py) {
        Point point = new Point(px, py);
        point.setId(Id.getNextId());
        return point;
    }

    public static Shape createLineShape(int px1, int py1, int px2, int py2) {
        return new Line(Id.getNextId(), new Point(px1, py1), new Point(px2, py2));
    }

    public static Shape createRectangleShape(int px, int py, int width, int height) {
        return new Rectangle(Id.getNextId(), new Point(px, py), width, height);
    }

    public static Shape createCircleShape(int px, int py, int radius) {
        return new Circle(Id.getNextId(), new Point(px, py), radius);
    }

    public static Shape createPolygonShape(int n, int[] coords) {
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < n * 2; i += 2) {
            points.add(new Point(coords[i], coords[i + 1]));
        }
        Polygone polygon = new Polygone(points);
        polygon.setId(Id.getNextId());
        return polygon;
    }
}