package shape;

import java.util.ArrayList;

/**
 * Class Polygone
 */
public class Polygone extends Shape {

  //
  // Fields
  //
  private ArrayList<Point> points;
  
  //
  // Constructors
  //
  public Polygone() {
    super();
    this.points = new ArrayList<>();
  }

  public Polygone(ArrayList<Point> points) {
    super();
    this.points = points != null ? points : new ArrayList<>();
  }
  
  //
  // Accessor methods
  //

  public void setPoints(ArrayList<Point> newVar) {
    this.points = newVar != null ? newVar : new ArrayList<>();
  }

  public ArrayList<Point> getPoints() {
    return points;
  }

  //
  // Other methods
  //

  public String toString() {
    StringBuilder sb = new StringBuilder();
    
    sb.append("Polygone{");
    sb.append(super.toString()); // infos de Shape
    sb.append(", points=");

    if (points == null || points.isEmpty()) {
      sb.append("[]");
    } else {
      sb.append("[");
      for (int i = 0; i < points.size(); i++) {
        sb.append(points.get(i));
        if (i < points.size() - 1) {
          sb.append(", ");
        }
      }
      sb.append("]");
    }

    sb.append("}");
    return sb.toString();
  }
}