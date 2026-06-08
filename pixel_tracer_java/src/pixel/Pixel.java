package pixel;

import shape.Point;
import java.util.ArrayList;

public class Pixel {
    private int px;
    private int py;
    private int color;

    public Pixel(int px, int py, int color) {
        this.px = px;
        this.py = py;
        this.color = color;
    }

    public Pixel(int px, int py) {
        this(px, py, 0);
    }

    public Pixel() {
        this(0, 0, 0);
    }

    // Getters et Setters
    public int getPx() {
        return px;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public int getPy() {
        return py;
    }

    public void setPy(int py) {
        this.py = py;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pixel[px=" + px + ", py=" + py + ", color=" + color + "]";
    }

    // Méthodes statiques pour gérer les pixels de formes
    public static ArrayList<Pixel> createShapeToPixel(Point point) {
        ArrayList<Pixel> pixels = new ArrayList<>();
        if (point != null) {
            pixels.add(new Pixel(point.getPos_x(), point.getPos_y(), point.getColor()));
        }
        return pixels;
    }

    public static void removePixelShape(ArrayList<Pixel> pixels) {
        pixels.clear();
    }

    public static void pixelPoint(Point point, ArrayList<Pixel> pixels) {
        if (point != null) {
            pixels.add(new Pixel(point.getPos_x(), point.getPos_y(), point.getColor()));
        }
    }

    public static void pixelLine(Point point, ArrayList<Pixel> pixels) {
        if (point != null) {
            pixels.add(new Pixel(point.getPos_x(), point.getPos_y(), point.getColor()));
        }
    }

    public static void pixelCircle(Point point, ArrayList<Pixel> pixels) {
        if (point != null) {
            pixels.add(new Pixel(point.getPos_x(), point.getPos_y(), point.getColor()));
        }
    }

    public static void pixelRectangle(Point point, ArrayList<Pixel> pixels) {
        if (point != null) {
            pixels.add(new Pixel(point.getPos_x(), point.getPos_y(), point.getColor()));
        }
    }

    public static void pixelSquare(Point point, ArrayList<Pixel> pixels) {
        if (point != null) {
            pixels.add(new Pixel(point.getPos_x(), point.getPos_y(), point.getColor()));
        }
    }

    public static void pixelPolygon(Point point, ArrayList<Pixel> pixels) {
        if (point != null) {
            pixels.add(new Pixel(point.getPos_x(), point.getPos_y(), point.getColor()));
        }
    }

    public static void pixelCurve(Point point, ArrayList<Pixel> pixels) {
        if (point != null) {
            pixels.add(new Pixel(point.getPos_x(), point.getPos_y(), point.getColor()));
        }
    }
}
