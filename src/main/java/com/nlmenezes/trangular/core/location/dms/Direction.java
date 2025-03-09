package com.nlmenezes.trangular.core.location.dms;

public enum Direction {
  N("North") {
    @Override
    public Direction getNegative() {
      return S;
    }
  },
  S("South") {
    @Override
    public Direction getNegative() {
      return N;
    }
  },
  E("East") {
    @Override
    public Direction getNegative() {
      return W;
    }
  },
  W("West") {
    @Override
    public Direction getNegative() {
      return E;
    }
  };

  private final String name;

  Direction(String name) {
    this.name = name;
  }

  public abstract Direction getNegative();

  @Override
  public String toString() {
    return "Direction{" +
        "name='" + name + '\'' +
        '}';
  }
}
