package area;

import layer.Layer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AreaTest {

    private Area createArea() {
        return new Area(2, 2, (byte) 0, "");
    }

    @Test
    void testId() {
        Area a = createArea();

        a.id = 1;

        assertEquals(1, a.id);
    }

    @Test
    void testName() {
        Area a = createArea();

        a.name = "Canvas";

        assertEquals("Canvas", a.name);
    }

    @Test
    void testWidth() {
        Area a = createArea();

        a.width = 100;

        assertEquals(100, a.width);
    }

    @Test
    void testHeight() {
        Area a = createArea();

        a.height = 50;

        assertEquals(50, a.height);
    }

    @Test
    void testEmptyChar() {
        Area a = createArea();

        a.emptyChar = '.';

        assertEquals('.', a.emptyChar);
    }

    @Test
    void testFullChar() {
        Area a = createArea();

        a.fullChar = '#';

        assertEquals('#', a.fullChar);
    }

    @Test
    void testAddLayer() {
        Area a = createArea();

        Layer l = new Layer(1, "Layer");

        a.layers.add(l);

        assertEquals(1, a.layers.size());
    }

    @Test
    void testRemoveLayer() {
        Area a = createArea();

        Layer l = new Layer(1, "Layer");

        a.layers.add(l);
        a.layers.remove(l);

        assertEquals(0, a.layers.size());
    }

    @Test
    void testClearArea() {
        Area a = new Area(2, 2, (byte) 0, "Test");

        char[][] grid = {
            {'#', '#'},
            {'#', '#'}
        };

        a.area = grid;
        a.emptyChar = '.';

        a.clear();

        assertEquals('.', a.area[0][0]);
        assertEquals('.', a.area[1][1]);
    }

    @Test
    void testFieldValues() {
        Area a = createArea();

        a.id = 1;
        a.name = "TestArea";
        a.width = 10;
        a.height = 20;
        a.emptyChar = '.';
        a.fullChar = '#';

        assertEquals(1, a.id);
        assertEquals("TestArea", a.name);
        assertEquals(10, a.width);
        assertEquals(20, a.height);
        assertEquals('.', a.emptyChar);
        assertEquals('#', a.fullChar);
    }
}