package pixel;

import java.util.List;
import java.util.ArrayList;
import shape.Shape;
import shape.Point;
import shape.Polygone;
import shape.Rectangle;
import shape.Line;
import shape.Circle;
import shape.Curve;

public class PixelConverter {
    public static List<Pixel> shapeToPixels(Shape shape) {
        List<Pixel> pixels = new ArrayList<>();

        if (shape instanceof Point) {
            pixelPoint((Point) shape, pixels);
        } else if (shape instanceof Line) {
            pixelLine((Line) shape, pixels);
        } else if (shape instanceof Circle) {
            pixelCircle((Circle) shape, pixels);
        } else if (shape instanceof Rectangle) {
            pixelRectangle((Rectangle) shape, pixels);
        } else if (shape instanceof Polygone) {
            pixelPolygon((Polygone) shape, pixels);
        } else if (shape instanceof Curve) {
            pixelCurve((Curve) shape, pixels);
        }

        return pixels;
    }

    private static void pixelPoint(Point shape, List<Pixel> pixels) {
        pixels.add(new Pixel(shape.getPos_x(), shape.getPos_y(), shape.getColor()));
    }

    private static void pixelLine(Line shape, List<Pixel> pixels) {
        Point p1 = shape.getP1();
        Point p2 = shape.getP2();
        if (p1 == null || p2 == null) {
            return;
        }

        int x1 = p1.getPos_x();
        int y1 = p1.getPos_y();
        int x2 = p2.getPos_x();
        int y2 = p2.getPos_y();
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;
        int color = shape.getColor();

        while (true) {
            pixels.add(new Pixel(x1, y1, color));
            if (x1 == x2 && y1 == y2) {
                break;
            }
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }

    private static void pixelCircle(Circle shape, List<Pixel> pixels) {
        Point center = shape.getCenter();
        if (center == null) {
            return;
        }

        int cx = center.getPos_x();
        int cy = center.getPos_y();
        int r = shape.getRadius();
        int x = 0;
        int y = r;
        int d = 3 - 2 * r;
        int color = shape.getColor();

        while (x <= y) {
            pixels.add(new Pixel(cx + x, cy + y, color));
            pixels.add(new Pixel(cx - x, cy + y, color));
            pixels.add(new Pixel(cx + x, cy - y, color));
            pixels.add(new Pixel(cx - x, cy - y, color));
            pixels.add(new Pixel(cx + y, cy + x, color));
            pixels.add(new Pixel(cx - y, cy + x, color));
            pixels.add(new Pixel(cx + y, cy - x, color));
            pixels.add(new Pixel(cx - y, cy - x, color));

            if (d < 0) {
                d += 4 * x + 6;
            } else {
                d += 4 * (x - y) + 10;
                y--;
            }
            x++;
        }
    }

    private static void pixelRectangle(Rectangle shape, List<Pixel> pixels) {
        Point p1 = shape.getP1();
        if (p1 == null) {
            return;
        }

        int x1 = p1.getPos_x();
        int y1 = p1.getPos_y();
        int x2 = x1 + shape.getWidth();
        int y2 = y1 + shape.getHeight();
        int color = shape.getColor();

        for (int x = x1; x < x2; x++) {
            pixels.add(new Pixel(x, y1, color));
            pixels.add(new Pixel(x, y2 - 1, color));
        }
        for (int y = y1; y < y2; y++) {
            pixels.add(new Pixel(x1, y, color));
            pixels.add(new Pixel(x2 - 1, y, color));
        }
    }

    private static void pixelPolygon(Polygone shape, List<Pixel> pixels) {
        List<Point> points = shape.getPoints();
        if (points == null || points.isEmpty()) {
            return;
        }

        int color = shape.getColor();
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());
            pixelLine(p1, p2, color, pixels);
        }
    }

    private static void pixelCurve(Curve shape, List<Pixel> pixels) {
        Point p1 = shape.getP1();
        Point p2 = shape.getP2();
        Point p3 = shape.getP3();
        Point p4 = shape.getP4();
        if (p1 == null || p2 == null || p3 == null || p4 == null) {
            return;
        }

        int color = shape.getColor();
        int steps = 100;
        double prevX = p1.getPos_x();
        double prevY = p1.getPos_y();

        for (int i = 1; i <= steps; i++) {
            double t = (double) i / steps;
            double x = cubicBezier(p1.getPos_x(), p2.getPos_x(), p3.getPos_x(), p4.getPos_x(), t);
            double y = cubicBezier(p1.getPos_y(), p2.getPos_y(), p3.getPos_y(), p4.getPos_y(), t);
            Point start = new Point((int) Math.round(prevX), (int) Math.round(prevY));
            Point end = new Point((int) Math.round(x), (int) Math.round(y));
            pixelLine(start, end, color, pixels);
            prevX = x;
            prevY = y;
        }
    }

    private static double cubicBezier(double a, double b, double c, double d, double t) {
        double mt = 1 - t;
        return mt * mt * mt * a + 3 * mt * mt * t * b + 3 * mt * t * t * c + t * t * t * d;
    }

    private static void pixelLine(Point p1, Point p2, int color, List<Pixel> pixels) {
        if (p1 == null || p2 == null) {
            return;
        }

        int x1 = p1.getPos_x();
        int y1 = p1.getPos_y();
        int x2 = p2.getPos_x();
        int y2 = p2.getPos_y();
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            pixels.add(new Pixel(x1, y1, color));
            if (x1 == x2 && y1 == y2) {
                break;
            }
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }
}