package shape;

/**
 * Class Point
 */
public class Point extends Shape {

  //
  // Fields
  //
  private int pos_x;
  private int pos_y;
  
  //
  // Constructors
  //
  public Point() {
    super();
    this.pos_x = 0;
    this.pos_y = 0;
  }

  public Point(int x, int y) {
    super();
    this.pos_x = x;
    this.pos_y = y;
  }

  public Point(int x, int y, int color) {
    super();
    this.pos_x = x;
    this.pos_y = y;
    setColor(color);
  }
  
  //
  // Accessor methods
  //

  public void setPos_x(int newVar) {
    pos_x = newVar;
  }

  public int getPos_x() {
    return pos_x;
  }

  public void setPos_y(int newVar) {
    pos_y = newVar;
  }

  public int getPos_y() {
    return pos_y;
  }

  //
  // Other methods
  //

   public String toString() {
    return "Point{" +
           "x=" + pos_x +
           ", y=" + pos_y +
           ", color=#" + String.format("%06X", getColor()) +
           "}";
  }
}