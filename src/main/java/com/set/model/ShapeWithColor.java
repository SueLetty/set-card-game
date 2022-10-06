package com.set.model;
/**
 * Shape is one of the feature for a card
 * Color is one of the feature for a card
 * Using symbol to represent shape and color
 */
public enum ShapeWithColor {
  /**
   * Purple heart
   */
  PURPLE_HEART("\ud83d\udc9c", Color.PURPLE),
  /**
   * Green heart
   */
  GREEN_HEART("\ud83d\udc9a", Color.GREEN),
  /**
   * Red heart
   */
  RED_HEART("\u2764\ufe0f", Color.RED),
  /**
   * Purple circle
   */
  PURPLE_CIRCLE("\ud83d\udfe3", Color.PURPLE),
  /**
   * Green circle
   */
  GREEN_CIRCLE("\ud83d\udfe2", Color.GREEN),
  /**
   * Red circle
   */
  RED_CIRCLE("\ud83d\udd34", Color.RED),
  /**
   * Purple square
   */
  PURPLE_SQUARE("\ud83d\udfe3", Color.PURPLE),
  /**
   * Green Square
   */
  GREEN_SQUARE("\ud83d\udfe9", Color.GREEN),
  /**
   * Red square
   */
  RED_SQUARE("\ud83d\udfe5", Color.RED);
  /**
   * symbol for each card
   */
  private final String symbol;
  /**
   * color for each card
   */
  private final Color color;

  /**
   * constructor
   * initialize fields
   * @param symbol String
   * @param color Color
   */
  ShapeWithColor(String symbol, Color color) {
    this.symbol = symbol;
    this.color = color;
  }

  /**
   * get symbol of the card
   * @return a string
   */
  public String getSymbol() {
    return symbol;
  }

  /**
   * get color of the card
   * @return a color
   */
  public Color getColor() {
    return color;
  }

  @Override
  public String toString() {
    String name = name();
    return name.charAt(0) + name.substring(1).toLowerCase();
  }

  enum Color {
    RED, GREEN, PURPLE
  }
}
