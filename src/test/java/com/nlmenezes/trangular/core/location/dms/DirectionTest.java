package com.nlmenezes.trangular.core.location.dms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {

  @Test
  public void testGetNegative_North() {
    assertEquals(Direction.S, Direction.N.getNegative());
  }

  @Test
  public void testGetNegative_South() {
    assertEquals(Direction.N, Direction.S.getNegative());
  }

  @Test
  public void testGetNegative_East() {
    assertEquals(Direction.W, Direction.E.getNegative());
  }

  @Test
  public void testGetNegative_West() {
    assertEquals(Direction.E, Direction.W.getNegative());
  }

  @Test
  public void testToString_North() {
    assertEquals("Direction{name='North'}", Direction.N.toString());
  }

  @Test
  public void testToString_South() {
    assertEquals("Direction{name='South'}", Direction.S.toString());
  }

  @Test
  public void testToString_East() {
    assertEquals("Direction{name='East'}", Direction.E.toString());
  }

  @Test
  public void testToString_West() {
    assertEquals("Direction{name='West'}", Direction.W.toString());
  }

  @Test
  public void testEnumValues() {
    Direction[] expectedValues = {Direction.N, Direction.S, Direction.E, Direction.W};
    assertArrayEquals(expectedValues, Direction.values());
  }

  @Test
  public void testEnumValueOf() {
    assertEquals(Direction.N, Direction.valueOf("N"));
    assertEquals(Direction.S, Direction.valueOf("S"));
    assertEquals(Direction.E, Direction.valueOf("E"));
    assertEquals(Direction.W, Direction.valueOf("W"));
  }
}
