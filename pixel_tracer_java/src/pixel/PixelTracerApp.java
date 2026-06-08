package pixel;

import java.util.List;
import java.util.ArrayList;
import area.Area;
import layer.Layer;
import shape.Shape;

public class PixelTracerApp {
    public List<Area> areas;
    public Area currentArea;
    public Layer currentLayer;
    public Shape currentShape;

    public PixelTracerApp() {
        areas = new ArrayList<>();
        // Initialize with default area
        Area defaultArea = new Area(80, 24, (byte)0, "Default");
        areas.add(defaultArea);
        currentArea = defaultArea;
        currentLayer = null;
        currentShape = null;
    }

    public void destroy() {
        // In Java, garbage collector handles this
    }
}
