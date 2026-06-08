package shape;


/**
 * Class Circle
 */
public class Circle extends Shape {

  //
  // Fields
  //

  private shape.Point center;
  private int radius;
  
  //
  // Constructors
  //
  public Circle() {
    super();
    this.center = null;
    this.radius = 0;
  }

  public Circle(shape.Point center, int radius) {
    super();
    this.center = center;
    this.radius = radius;
  }

  public Circle(long id, shape.Point center, int radius) {
    super();
    setId(id);
    this.center = center;
    this.radius = radius;
  }
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of center
   * @param newVar the new value of center
   */
  public void setCenter (shape.Point newVar) {
    center = newVar;
  }

  /**
   * Get the value of center
   * @return the value of center
   */
  public shape.Point getCenter () {
    return center;
  }

  /**
   * Set the value of radius
   * @param newVar the new value of radius
   */
  public void setRadius (int newVar) {
    radius = newVar;
  }

  /**
   * Get the value of radius
   * @return the value of radius
   */
  public int getRadius () {
    return radius;
  }

  //
  // Other methods
  //

  /**
   * @return       String
   */
  public String toString()
  {
    return "Circle[center=" + center + "]";
  }


}
