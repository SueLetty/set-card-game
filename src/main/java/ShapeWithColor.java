enum ShapeWithColor {


  PURPLE_HEART("\ud83d\udc9c", Color.PURPLE),
  GREEN_HEART("\ud83d\udc9a", Color.GREEN),
  RED_HEART("\u2764\ufe0f", Color.RED),
  PURPLE_CIRCLE("\ud83d\udfe3", Color.PURPLE),
  GREEN_CIRCLE("\ud83d\udfe2", Color.GREEN),
  RED_CIRCLE("\ud83d\udd34", Color.RED),
  PURPLE_SQUARE("\ud83d\udfe3", Color.PURPLE),
  GREEN_SQUARE("\ud83d\udfe9", Color.GREEN),
  RED_SQUARE("\ud83d\udfe5", Color.RED);

  private final String symbol;
  private final Color color;

  enum Color {
    RED, GREEN, PURPLE
  }

  ShapeWithColor(String symbol, Color color) {
    this.symbol = symbol;
    this.color = color;
  }

  public String getSymbol() {
    return symbol;
  }

  public Color getColor() {
    return color;
  }

  @Override
  public String toString() {
    String name = name();
    return name.charAt(0) + name.substring(1).toLowerCase();
  }
}
