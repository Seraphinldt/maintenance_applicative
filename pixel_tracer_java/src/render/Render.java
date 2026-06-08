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
        for (int i = 0; i < area.height; i++) {
            for (int j = 0; j < area.width; j++) {
                System.out.print(area.area[i][j]);
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
        if (!layer.visible) return;
        for (Shape shape : layer.shapes) {
            List<Pixel> pixels = PixelConverter.shapeToPixels(shape);
            for (Pixel pixel : pixels) {
                if (pixel.x >= 0 && pixel.x < area.width && pixel.y >= 0 && pixel.y < area.height) {
                    area.area[pixel.y][pixel.x] = FULL_CHAR;
                }
            }
        }
    }

    public static void drawAllLayers(Area area) {
        area.clear();
        for (Layer layer : area.layers) {
            drawLayerShapes(area, layer);
        }
    }
}
