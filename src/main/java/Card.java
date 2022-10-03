import java.util.Objects;

public class Card {
  private final Shape shape;
  private final Number number;
  private final Color color;
  private final Shading shading;


  public Card(Number number, Shape shape, Color color, Shading shading){
    this.shape = shape;
    this.number = number;
    this.color = color;
    this.shading = shading;
  }

  public Shape getShape() {
    return shape;
  }

  public Number getNumber() {
    return number;
  }

  public Color getColor() {
    return color;
  }

  public Shading getShading() {
    return shading;
  }

  @Override
  public int hashCode() {
    return Objects.hash(shape, number,color,shading);
  }

  @Override
  public boolean equals(Object obj) {
    boolean result;

    if(this ==obj){
      result = true;
    }else if(obj instanceof Card){
      Card other = (Card) obj;
      result = (this.number == other.number && this.color == other.color && this.shape == other.shape && this.shading == other.shading);
    }else{
      result = false;
    }
    return result;
  }

  @Override
  public String toString() {
    return number.toString() + color.toString() + shape.toString() + shading.toString();
  }

}
