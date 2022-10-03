public enum Shape {

  OVAL, SQUIGGLES, DIAMOND;

  @Override
  public String toString() {
    String name = name();
    return name.charAt(0) + name.substring(1).toLowerCase();
  }
}
