package pixel;

import org.junit.jupiter.api.Test;
import shape.Point;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class PixelTest
 */
class PixelTest {

    @Test
    void testSetEtGetPx() {

        Pixel p = new Pixel();


        p.setPx(10);

        assertEquals(10, p.getPx());
    }

    @Test
    void testSetEtGetPy() {

        Pixel p = new Pixel();

        p.setPy(20);

        assertEquals(20, p.getPy());
    }

    @Test
    void testSetEtGetColor() {

        Pixel p = new Pixel();

        p.setColor(255);

        assertEquals(255, p.getColor());
    }

    @Test
    void testConstructeur() {

        Pixel p = new Pixel(1, 2, 3);

        assertEquals(1, p.getPx());
        assertEquals(2, p.getPy());
        assertEquals(3, p.getColor());
    }

    @Test
    void testToString() {

        Pixel p = new Pixel(4, 5, 255);

        assertEquals(
                "Pixel[px=4, py=5, color=255]",
                p.toString()
        );
    }

    @Test
    void testCreateShapeToPixel() {

        Point point = new Point();

        ArrayList<Pixel> pixels =
                Pixel.createShapeToPixel(point);

        assertNotNull(pixels);
    }

    @Test
    void testRemovePixelShape() {

        ArrayList<Pixel> pixels = new ArrayList<>();

        pixels.add(new Pixel(1, 1, 1));

        Pixel.removePixelShape(pixels);

        assertEquals(0, pixels.size());
    }

    @Test
    void testPixelPoint() {

        Point point = new Point();

        ArrayList<Pixel> pixels = new ArrayList<>();

        assertDoesNotThrow(() -> {
            Pixel.pixelPoint(point, pixels);
        });
    }

    @Test
    void testPixelLine() {

        Point point = new Point();

        ArrayList<Pixel> pixels = new ArrayList<>();

        assertDoesNotThrow(() -> {
            Pixel.pixelLine(point, pixels);
        });
    }

    @Test
    void testPixelCircle() {

        Point point = new Point();

        ArrayList<Pixel> pixels = new ArrayList<>();

        assertDoesNotThrow(() -> {
            Pixel.pixelCircle(point, pixels);
        });
    }

    @Test
    void testPixelRectangle() {

        Point point = new Point();

        ArrayList<Pixel> pixels = new ArrayList<>();

        assertDoesNotThrow(() -> {
            Pixel.pixelRectangle(point, pixels);
        });
    }

    @Test
    void testPixelSquare() {

        Point point = new Point();

        ArrayList<Pixel> pixels = new ArrayList<>();

        assertDoesNotThrow(() -> {
            Pixel.pixelSquare(point, pixels);
        });
    }

    @Test
    void testPixelPolygon() {

        Point point = new Point();

        ArrayList<Pixel> pixels = new ArrayList<>();

        assertDoesNotThrow(() -> {
            Pixel.pixelPolygon(point, pixels);
        });
    }

    @Test
    void testPixelCurve() {

        Point point = new Point();

        ArrayList<Pixel> pixels = new ArrayList<>();

        assertDoesNotThrow(() -> {
            Pixel.pixelCurve(point, pixels);
        });
    }
}