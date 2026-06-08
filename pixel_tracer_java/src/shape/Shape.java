package shape;

/**
 * Class Shape
 */
abstract public class Shape {

  //
  // Fields
  //
  private static long counter = 0; // pour générer des IDs uniques

  private long id;
  private char fill;
  private float thickness;
  private int color;
  private double rotation;
  
  //
  // Constructors
  //
  public Shape() {
    this.id = ++counter; // auto-incrément
    this.fill = ' ';     // par défaut vide
    this.thickness = 1.0f;
    this.color = 0x000000; // noir par défaut
    this.rotation = 0.0;
  }

  public Shape(char fill, float thickness, int color, double rotation) {
    this.id = ++counter;
    this.fill = fill;
    this.thickness = thickness;
    this.color = color;
    this.rotation = rotation;
  }
  
  //
  // Accessor methods
  //

  public void setId(long newVar) {
    id = newVar;
  }

  public long getId() {
    return id;
  }

  public void setFill(char newVar) {
    fill = newVar;
  }

  public char getFill() {
    return fill;
  }

  public void setThickness(float newVar) {
    thickness = newVar;
  }

  public float getThickness() {
    return thickness;
  }

  public void setColor(int newVar) {
    color = newVar;
  }

  public int getColor() {
    return color;
  }

  public void setRotation(double newVar) {
    rotation = newVar;
  }

  public double getRotation() {
    return rotation;
  }

  //
  // Other methods
  //

  public String toString() {
    return "Shape[id=" + id +
           ", fill=" + fill +
           ", thickness=" + thickness +
           ", color=#" + String.format("%06X", color) +
           ", rotation=" + rotation + "]";
  }
}