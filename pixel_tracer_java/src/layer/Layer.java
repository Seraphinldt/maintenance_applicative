package layer;

import java.util.List;
import java.util.ArrayList;
import shape.Shape;

public class Layer {
    public int id;
    public String name;
    public boolean visible;
    public List<Shape> shapes;

    public Layer(int id, String name) {
        this.id = id;
        this.name = name;
        this.visible = true;
        this.shapes = new ArrayList<>();
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }
}