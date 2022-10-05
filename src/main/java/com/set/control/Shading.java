package com.set.control;

public enum Shading {
  OUTLINED, SOLID, STRIPED;

  @Override
  public String toString() {
    String name = name();
    return name.charAt(0) + name.substring(1).toLowerCase();
  }
}
