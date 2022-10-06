package com.set.model;

/**
 * Number is one of the feature for a card
 */
public enum Number {
  /**
   * number one
   */
  ONE,
  /**
   * number two
   */
  TWO,
  /**
   * number three
   */
  THREE;

  @Override
  public String toString() {
    String name = name();
    return name.charAt(0) + name.substring(1).toLowerCase();
  }

}
