enum ShapeWithColor {

  PURPPLEHEART("\ud83d\udc9c", Color.PURPLE),
  GREENHEART("\ud83d\udc9a",Color.GREEN),
  REDHEART("\ud83d\udc97",Color.RED),
  PURPPLECIRCLE("\ud83d\udfe3",Color.PURPLE),
  GREENCIRCLE("\ud83d\udfe2",Color.GREEN),
  REDCIRCLE("\ud83d\udd34",Color.RED),
  PURPPLESQUARE("\ud83d\udfe3",Color.PURPLE),
  GREENSQUARE("\ud83d\udfe9",Color.GREEN),
  REDSQUARE("\ud83d\udfe5",Color.RED);

  private final String symbol;
  private final Color color;

  enum Color{
    RED, GREEN, PURPLE;
  }

  ShapeWithColor(String symbol, Color color){
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
    return name.charAt(0) + name.substring(1).toLowerCase(); //Oval, Squiggles, Diamond
  }
}
