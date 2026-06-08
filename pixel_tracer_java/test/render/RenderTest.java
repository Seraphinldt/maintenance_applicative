package render;

import area.Area;
import layer.Layer;
import org.junit.jupiter.api.Test;
import shape.Point;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class RenderTest
 */
class RenderTest {

    @Test
    void testConstantes() {

        assertEquals('.', Render.EMPTY_CHAR);
        assertEquals('#', Render.FULL_CHAR);
    }

    @Test
    void testClearScreen() {

        // Vérifie simplement que la méthode existe
        assertDoesNotThrow(() -> {
            Render.clearScreen();
        });
    }

    @Test
    void testDrawArea() {

        Area area = new Area();

        area.setWidth(2);
        area.setHeight(2);

        char[][] grid = {
                {'.', '#'},
                {'#', '.'}
        };

        area.setArea(grid);

        assertDoesNotThrow(() -> {
            Render.drawArea(area);
        });
    }

    @Test
    void testDrawLayerShapes() {

        Area area = new Area();

        Layer layer = new Layer();

        Point p = new Point();
        p.setPos_x(1);
        p.setPos_y(2);

        ArrayList<shape.Shape> shapes = new ArrayList<>();
        shapes.add(p);

        layer.setShapes(shapes);

        assertDoesNotThrow(() -> {
            Render.drawLayerShapes(area, layer);
        });
    }

    @Test
    void testDrawAllLayers() {

        Area area = new Area();

        Layer layer = new Layer();
        layer.setVisible(true);

        ArrayList<Layer> layers = new ArrayList<>();
        layers.add(layer);

        area.setLst_layers(layers);

        assertDoesNotThrow(() -> {
            Render.drawAllLayers(area);
        });
    }

    @Test
    void testRenderArea() {

        Area area = new Area();

        area.setWidth(1);
        area.setHeight(1);

        char[][] grid = {
                {'.'}
        };

        area.setArea(grid);

        assertDoesNotThrow(() -> {
            Render.renderArea(area);
        });
    }
}