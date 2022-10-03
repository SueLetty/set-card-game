public enum Color {
  GREEN, RED, PURPLE;


  @Override
  public String toString() {
    String name = name();
    return name.charAt(0) + name.substring(1).toLowerCase();
  }
}
