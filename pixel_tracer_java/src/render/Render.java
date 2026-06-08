package render;

import java.util.List;
import area.Area;
import layer.Layer;
import pixel.Pixel;
import shape.Shape;
import pixel.PixelConverter;

public class Render {
    public static final char EMPTY_CHAR = '.';
    public static final char FULL_CHAR = '#';

    public static void renderArea(Area area) {
        for (int i = 0; i < area.getHeight(); i++) {
            for (int j = 0; j < area.getWidth(); j++) {
                System.out.print(area.getArea()[i][j]);
            }
            System.out.println();
        }
    }

    public static void drawArea(Area area) {
        renderArea(area);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void drawLayerShapes(Area area, Layer layer) {
        if (layer.getVisible() != Layer.LAYER_VISIBLE) return;
        for (Shape shape : layer.getShapes()) {
            List<Pixel> pixels = PixelConverter.shapeToPixels(shape);
            for (Pixel pixel : pixels) {
                if (pixel.getPx() >= 0 && pixel.getPx() < area.getWidth() && pixel.getPy() >= 0 && pixel.getPy() < area.getHeight()) {
                    area.getArea()[pixel.getPy()][pixel.getPx()] = FULL_CHAR;
                }
            }
        }
    }

    public static void drawAllLayers(Area area) {
        area.clear();
        for (Layer layer : area.getLayers()) {
            drawLayerShapes(area, layer);
        }
    }
}
