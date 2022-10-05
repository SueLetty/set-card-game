package com.set.control;

 public enum Number {

  ONE, TWO,THREE;

  @Override
  public String toString() {
    String name = name();
    return name.charAt(0) + name.substring(1).toLowerCase();
  }

}
