import java.util.Objects;

public class Card {
  private final ShapeWithColor shape;
  private final Number number;
  private final Shading shading;


  public Card(Number number, ShapeWithColor shape, Shading shading){
    this.shape = shape;
    this.number = number;
    this.shading = shading;
  }

  public ShapeWithColor getShape() {
    return shape;
  }

  public Number getNumber() {
    return number;
  }


  public Shading getShading() {
    return shading;
  }

  @Override
  public int hashCode() {
    return Objects.hash(shape, number,shading);
  }

  @Override
  public boolean equals(Object obj) {
    boolean result;

    if(this ==obj){
      result = true;
    }else if(obj instanceof Card){
      Card other = (Card) obj;
      result = (this.number == other.number &&  this.shape == other.shape && this.shading == other.shading);
    }else{
      result = false;
    }
    return result;
  }

  @Override
  public String toString() {
    return number.toString() + ", " + shape.toString() +", "+ shading.toString();
  }



}
