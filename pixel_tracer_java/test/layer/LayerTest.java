package layer;

import org.junit.jupiter.api.Test;
import shape.Point;

import static org.junit.jupiter.api.Assertions.*;

class LayerTest {

    @Test
    void testConstructorAndFields() {
        Layer layer = new Layer(1, "Background");

        assertEquals(1, layer.id);
        assertEquals("Background", layer.name);
        assertTrue(layer.visible);
        assertNotNull(layer.shapes);
        assertEquals(0, layer.shapes.size());
    }

    @Test
    void testSetVisible() {
        Layer layer = new Layer(1, "Layer");

        layer.setVisible(false);

        assertFalse(layer.visible);

        layer.setVisible(true);

        assertTrue(layer.visible);
    }

    @Test
    void testAddShape() {
        Layer layer = new Layer(1, "Layer");

        Point p = new Point();
        p.setPos_x(1);
        p.setPos_y(2);

        layer.addShape(p);

        assertEquals(1, layer.shapes.size());
        assertSame(p, layer.shapes.get(0));
    }

    @Test
    void testRemoveShape() {
        Layer layer = new Layer(1, "Layer");

        Point p = new Point();
        layer.addShape(p);

        layer.removeShape(p);

        assertEquals(0, layer.shapes.size());
    }
}
