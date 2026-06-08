package shape;

public class Rectangle extends Shape {
    private Point p1;
    private int width;
    private int height;

    public Rectangle() {
        super();
        this.p1 = null;
        this.width = 0;
        this.height = 0;
    }

    public Rectangle(long id, Point p1, int width, int height) {
        super();
        setId(id);
        this.p1 = p1;
        this.width = width;
        this.height = height;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
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

    @Override
    public String toString() {
        return "Rectangle: " + p1 + " width=" + width + " height=" + height;
    }
}