package area;

import java.util.List;
import java.util.ArrayList;
import layer.Layer;

public class Area {
    public byte id;
    public String name;
    public int width;
    public int height;
    public char[][] area;
    public List<Layer> layers;
    public char emptyChar;
    public char fullChar;

    public Area(int width, int height, byte id, String name) {
        this.width = width;
        this.height = height;
        this.id = id;
        this.name = name;
        this.area = new char[height][width];
        this.layers = new ArrayList<>();
        this.emptyChar = '.';
        this.fullChar = '#';
        clear();
    }

    public void clear() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                area[i][j] = emptyChar;
            }
        }
    }
}
