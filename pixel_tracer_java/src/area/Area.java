package area;

import java.util.List;
import java.util.ArrayList;
import layer.Layer;

public class Area {
    private byte id;
    private String name;
    private int width;
    private int height;
    private char[][] area;
    private List<Layer> lst_layers;
    private char emptyChar;
    private char fullChar;

    // Constructeur sans paramètres
    public Area() {
        this.width = 80;
        this.height = 24;
        this.id = 0;
        this.name = "DefaultArea";
        this.area = new char[height][width];
        this.lst_layers = new ArrayList<>();
        this.emptyChar = '.';
        this.fullChar = '#';
        clear();
    }

    // Constructeur avec paramètres
    public Area(int width, int height, byte id, String name) {
        this.width = width;
        this.height = height;
        this.id = id;
        this.name = name;
        this.area = new char[height][width];
        this.lst_layers = new ArrayList<>();
        this.emptyChar = '.';
        this.fullChar = '#';
        clear();
    }

    // Getters et Setters
    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = (byte) id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getArea() {
        return area;
    }

    public void setArea(char[][] area) {
        this.area = area;
    }

    public char getEmpty_char() {
        return emptyChar;
    }

    public void setEmpty_char(char emptyChar) {
        this.emptyChar = emptyChar;
    }

    public char getFull_char() {
        return fullChar;
    }

    public void setFull_char(char fullChar) {
        this.fullChar = fullChar;
    }

    public List<Layer> getLst_layers() {
        return lst_layers;
    }

    public void setLst_layers(List<Layer> lst_layers) {
        this.lst_layers = lst_layers;
    }

    public void addLayer(Layer layer) {
        lst_layers.add(layer);
    }

    public void removeLayer(Layer layer) {
        lst_layers.remove(layer);
    }

    // Pour compatibilité avec l'ancien code
    public List<Layer> getLayers() {
        return lst_layers;
    }

    public void clear() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                area[i][j] = emptyChar;
            }
        }
    }

    public void clearArea() {
        clear();
    }

    @Override
    public String toString() {
        return "Area[id=" + id + ", name=" + name + ", width=" + width + ", height=" + height + "]";
    }
}
