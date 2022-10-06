package com.set.model;

import java.util.Objects;

public class Card {

  /**
   * shape and color for each card
   */
  private final ShapeWithColor shape;
  /**
   * number for each card
   */
  private final Number number;
  /**
   * shading for each card
   */
  private final Shading shading;

  /**
   * constructor initialized all the fields
   *
   * @param number  Number
   * @param shape   ShapeWithColor
   * @param shading Shading
   */
  public Card(Number number, ShapeWithColor shape, Shading shading) {
    this.shape = shape;
    this.number = number;
    this.shading = shading;
  }

  /**
   * get shape from the card
   *
   * @return shape
   */
  public ShapeWithColor getShape() {
    return shape;
  }

  /**
   * get number from the card
   *
   * @return number
   */
  public Number getNumber() {
    return number;
  }

  /**
   * get shading from the card
   *
   * @return shading
   */

  public Shading getShading() {
    return shading;
  }

  @Override
  public int hashCode() {
    return Objects.hash(shape, number, shading);
  }

  @Override
  public boolean equals(Object obj) {
    boolean result;

    if (this == obj) {
      result = true;
    } else if (obj instanceof Card) {
      Card other = (Card) obj;
      result = (this.number == other.number && this.shape == other.shape
          && this.shading == other.shading);
    } else {
      result = false;
    }
    return result;
  }

  @Override
  public String toString() {
    return number.toString() + ", " + shape.toString() + ", " + shading.toString();
  }


}
