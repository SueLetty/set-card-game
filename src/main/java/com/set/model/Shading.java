package com.set.model;

/**
 * Shading is one of the feature for a card
 */
public enum Shading {
  /**
   * Shading is Outlined
   */
  OUTLINED,
  /**
   * Shading is Solid
   */
  SOLID,
  /**
   * Shading is Striped
   */
  STRIPED;

  @Override
  public String toString() {
    String name = name();
    return name.charAt(0) + name.substring(1).toLowerCase();
  }
}
