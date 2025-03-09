package com.nlmenezes.trangular.core.location.dms;

import com.nlmenezes.trangular.core.util.MathUtils;
import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DMSAngleTest {

  @Test
  public void testConstructor_PositiveDegrees() {
    Apfloat degrees = MathUtils.createFloat(123.456);
    Direction direction = Direction.N;
    DMSAngle angle = new DMSAngle(degrees, direction);

    assertEquals(123.456, angle.getDecimalValue().doubleValue(), MathUtils.DELTA.doubleValue());
    assertEquals(Direction.N, angle.getDirection());
  }

  @Test
  public void testConstructor_NegativeDegrees() {
    Apfloat degrees = MathUtils.createFloat(-123.456);
    Direction direction = Direction.N;
    DMSAngle angle = new DMSAngle(degrees, direction);

    assertEquals(-123.456, angle.getDecimalValue().doubleValue(), MathUtils.DELTA.doubleValue());
    assertEquals(direction.getNegative(), angle.getDirection());
  }

  @Test
  public void testConstructor_NegativeDegrees_East() {
    Apfloat degrees = MathUtils.createFloat(-23.789);
    Direction direction = Direction.E;
    DMSAngle angle = new DMSAngle(degrees, direction);

    assertEquals(-23.789, angle.getDecimalValue().doubleValue(), MathUtils.DELTA.doubleValue());
    assertEquals(Direction.W, angle.getDirection());
  }


  @Test
  public void testConstructor_InvalidDirection_South() {
    Apfloat degrees = MathUtils.createFloat(123.456);
    Direction direction = Direction.S;

    // Assert that an IllegalArgumentException is thrown
    assertThrows(IllegalArgumentException.class, () -> new DMSAngle(degrees, direction),
        "posDirection must be either N or E");
  }

  @Test
  public void testConstructor_InvalidDirection_West() {
    Apfloat degrees = MathUtils.createFloat(123.456);
    Direction direction = Direction.W;

    // Assert that an IllegalArgumentException is thrown
    assertThrows(IllegalArgumentException.class, () -> new DMSAngle(degrees, direction),
        "posDirection must be either N or E");
  }

  @Test
  public void testNegativeDirectionBehavior_North() {
    Apfloat degrees = MathUtils.createFloat(-75.456);
    Direction direction = Direction.N;
    DMSAngle angle = new DMSAngle(degrees, direction);

    assertEquals(-75.456, angle.getDecimalValue().doubleValue(), MathUtils.DELTA.doubleValue());
    assertEquals(Direction.S, angle.getDirection()); // Negative N becomes South
  }

  @Test
  public void testNegativeDirectionBehavior_West() {
    Apfloat degrees = MathUtils.createFloat(-45);
    Direction direction = Direction.E;
    DMSAngle angle = new DMSAngle(degrees, direction);

    assertEquals(-45, angle.getDecimalValue().doubleValue(), MathUtils.DELTA.doubleValue());
    assertEquals(Direction.W, angle.getDirection()); // Negative E becomes West
  }

  @Test
  public void testGetDecimalValue() {
    Apfloat degrees = MathUtils.createFloat(10.5);
    Direction direction = Direction.E;
    DMSAngle angle = new DMSAngle(degrees, direction);

    assertEquals(degrees, angle.getDecimalValue());
  }

  @Test
  public void testGetRadianValue() {
    Apfloat degrees = MathUtils.createFloat(180);
    Direction direction = Direction.E;
    DMSAngle angle = new DMSAngle(degrees, direction);

    Apfloat radians = ApfloatMath.toRadians(degrees);
    assertEquals(radians, angle.getRadianValue());
  }

  @Test
  public void testEquals_SameInstance() {
    Apfloat degrees = MathUtils.createFloat(45);
    Direction direction = Direction.N;
    DMSAngle angle = new DMSAngle(degrees, direction);

    // Test reflexive property: object equals itself
    assertTrue(angle.equals(angle));
  }

  @Test
  public void testEquals_EquivalentInstance() {
    Apfloat degrees1 = MathUtils.createFloat(45);
    Apfloat degrees2 = MathUtils.createFloat(45);
    Direction direction = Direction.N;

    DMSAngle angle1 = new DMSAngle(degrees1, direction);
    DMSAngle angle2 = new DMSAngle(degrees2, direction);

    // Test equivalent objects
    assertTrue(angle1.equals(angle2));
    assertTrue(angle2.equals(angle1)); // Symmetry
  }
  @Test
  public void testEquals_DifferentClass() {
    DMSAngle angle = new DMSAngle(MathUtils.createFloat(45.123), Direction.N);

    // Test against an object of a different type
    assertFalse(angle.equals("Some String"));
  }

  @Test
  public void testEquals_DifferentDegree() {
    DMSAngle angle1 = new DMSAngle(MathUtils.createFloat(45.123), Direction.N);
    DMSAngle angle2 = new DMSAngle(MathUtils.createFloat(46.123), Direction.N);

    // Different degrees should result in inequality
    assertFalse(angle1.equals(angle2));
  }

  @Test
  public void testEquals_DifferentMinute() {
    DMSAngle angle1 = new DMSAngle(MathUtils.createFloat(45.123), Direction.N);
    DMSAngle angle2 = new DMSAngle(MathUtils.createFloat(45.223), Direction.N);

    // Different minutes should result in inequality
    assertFalse(angle1.equals(angle2));
  }

  @Test
  public void testEquals_DifferentSecond() {
    DMSAngle angle1 = new DMSAngle(MathUtils.createFloat(45.1234), Direction.N);
    DMSAngle angle2 = new DMSAngle(MathUtils.createFloat(45.1235), Direction.N);

    // Use precision threshold to determine equality
    assertFalse(angle1.equals(angle2));
  }

  @Test
  public void testEquals_DifferentDirection() {
    DMSAngle angle1 = new DMSAngle(MathUtils.createFloat(45.123), Direction.N);
    DMSAngle angle2 = new DMSAngle(MathUtils.createFloat(45.123), Direction.E);

    // Different directions should result in inequality
    assertFalse(angle1.equals(angle2));
  }

  @Test
  public void testEquals_EquivalentObjects() {
    DMSAngle angle1 = new DMSAngle(MathUtils.createFloat(45.123), Direction.N);
    DMSAngle angle2 = new DMSAngle(MathUtils.createFloat(45.123), Direction.N);

    // All fields are equal, so objects should be equal
    assertTrue(angle1.equals(angle2));
  }
  @Test
  public void testEquals_Null() {
    Apfloat degrees = MathUtils.createFloat(45);
    Direction direction = Direction.N;
    DMSAngle angle = new DMSAngle(degrees, direction);

    // Test with null
    assertFalse(angle.equals(null));
  }

  @Test
  public void testEquals_DifferentMinutesAndSeconds() {
    DMSAngle angle1 = new DMSAngle(MathUtils.createFloat(45.123456), Direction.N);
    DMSAngle angle2 = new DMSAngle(MathUtils.createFloat(45.654321), Direction.N);

    // Test with different minutes and seconds
    assertFalse(angle1.equals(angle2));
  }

  @Test
  public void testHashCode() {
    Apfloat degrees = MathUtils.createFloat(45);
    Direction direction = Direction.N;
    DMSAngle angle1 = new DMSAngle(degrees, direction);
    DMSAngle angle2 = new DMSAngle(degrees, direction);

    assertEquals(angle1.hashCode(), angle2.hashCode());
  }

  @Test
  public void testToString() {
    Apfloat degrees = MathUtils.createFloat(123.456);
    Direction direction = Direction.N;
    DMSAngle angle = new DMSAngle(degrees, direction);

    String expected = "DMSAngle{degree=123, minute=27, second=2.1600000000010944e1, direction=Direction{name='North'}}";
    assertTrue(angle.toString().contains("DMSAngle"));
    assertEquals(expected, angle.toString());
  }
}
