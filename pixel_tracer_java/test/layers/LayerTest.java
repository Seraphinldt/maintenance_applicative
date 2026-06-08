package layers;

import layer.Layer;
import org.junit.jupiter.api.Test;
import shape.Point;

import static org.junit.jupiter.api.Assertions.*;

class LayerTest {

    @Test
    void testId() {
        Layer layer = new Layer();

        layer.setId(1);

        assertEquals(1, layer.getId());
    }

    @Test
    void testName() {
        Layer layer = new Layer();

        layer.setName("Background");

        assertEquals("Background", layer.getName());
    }

    @Test
    void testVisible() {
        Layer layer = new Layer();

        layer.setVisible(Layer.LAYER_VISIBLE);

        assertEquals(Layer.LAYER_VISIBLE, layer.getVisible());
    }

    @Test
    void testAddShape() {
        Layer layer = new Layer();

        Point p = new Point();
        p.setPos_x(1);
        p.setPos_y(2);

        layer.addShape(p);

        assertEquals(1, layer.getShapes().size());
    }

    @Test
    void testRemoveShape() {
        Layer layer = new Layer();

        Point p = new Point();

        layer.addShape(p);
        layer.removeShape(p);

        assertEquals(0, layer.getShapes().size());
    }

    @Test
    void testLayerVisible() {
        Layer layer = new Layer();

        layer.setLayerUnvisible();
        layer.setLayerVisible();

        assertEquals(Layer.LAYER_VISIBLE, layer.getVisible());
    }

    @Test
    void testLayerUnvisible() {
        Layer layer = new Layer();

        layer.setLayerUnvisible();

        assertEquals(Layer.LAYER_UNVISIBLE, layer.getVisible());
    }

    @Test
    void testToString() {
        Layer layer = new Layer();

        layer.setId(5);
        layer.setName("TestLayer");

        assertEquals(
            "Layer[id=5, name=TestLayer, visible=1, shapes=[]]",
            layer.toString()
        );
    }
}