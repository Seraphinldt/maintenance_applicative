package area;

import layer.Layer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AreaTest {

    @Test
    void testId() {
        Area a = new Area();

        a.setId(1);

        assertEquals(1, a.getId());
    }

    @Test
    void testName() {
        Area a = new Area();

        a.setName("Canvas");

        assertEquals("Canvas", a.getName());
    }

    @Test
    void testWidth() {
        Area a = new Area();

        a.setWidth(100);

        assertEquals(100, a.getWidth());
    }

    @Test
    void testHeight() {
        Area a = new Area();

        a.setHeight(50);

        assertEquals(50, a.getHeight());
    }

    @Test
    void testEmptyChar() {
        Area a = new Area();

        a.setEmpty_char('.');

        assertEquals('.', a.getEmpty_char());
    }

    @Test
    void testFullChar() {
        Area a = new Area();

        a.setFull_char('#');

        assertEquals('#', a.getFull_char());
    }

    @Test
    void testAddLayer() {
        Area a = new Area();

        Layer l = new Layer();

        a.addLayer(l);

        assertEquals(1, a.getLst_layers().size());
    }

    @Test
    void testRemoveLayer() {
        Area a = new Area();

        Layer l = new Layer();

        a.addLayer(l);
        a.removeLayer(l);

        assertEquals(0, a.getLst_layers().size());
    }

    @Test
    void testClearArea() {
        Area a = new Area();

        char[][] grid = {
            {'#', '#'},
            {'#', '#'}
        };

        a.setArea(grid);
        a.setEmpty_char('.');

        a.clearArea();

        assertEquals('.', a.getArea()[0][0]);
        assertEquals('.', a.getArea()[1][1]);
    }

    @Test
    void testToString() {
        Area a = new Area();

        a.setId(1);
        a.setName("TestArea");
        a.setWidth(10);
        a.setHeight(20);
        a.setEmpty_char('.');
        a.setFull_char('#');

        assertEquals(
            "Area[id=1, name=TestArea, width=10, height=20]",
            a.toString()
        );
    }
}