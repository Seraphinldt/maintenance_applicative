package layer;

import java.util.List;
import java.util.ArrayList;
import shape.Shape;

public class Layer {
    public static final int LAYER_VISIBLE = 1;
    public static final int LAYER_UNVISIBLE = 0;

    private int id;
    private String name;
    private int visible;
    public List<Shape> shapes;

    // Constructeur sans paramètres
    public Layer() {
        this.id = 0;
        this.name = "DefaultLayer";
        this.visible = LAYER_VISIBLE;
        this.shapes = new ArrayList<>();
    }

    // Constructeur avec paramètres
    public Layer(int id, String name) {
        this.id = id;
        this.name = name;
        this.visible = LAYER_VISIBLE;
        this.shapes = new ArrayList<>();
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible ? LAYER_VISIBLE : LAYER_UNVISIBLE;
    }

    public void setLayerVisible() {
        this.visible = LAYER_VISIBLE;
    }

    public void setLayerUnvisible() {
        this.visible = LAYER_UNVISIBLE;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public String toString() {
        return "Layer[id=" + id + ", name=" + name + ", visible=" + visible + ", shapes=" + shapes + "]";
    }
}