package com.nlmenezes.trangular.core.location.dms;

import com.nlmenezes.trangular.core.location.cartesian.CartesianRepresentation;
import com.nlmenezes.trangular.core.location.decimal.DecimalRepresentation;
import com.nlmenezes.trangular.core.util.MathUtils;
import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DMSRepresentationTest {

  @Test
  public void testToCartesianRepresentation() {
    DMSAngle latitude = new DMSAngle(MathUtils.createFloat(45), Direction.N);
    DMSAngle longitude = new DMSAngle(MathUtils.createFloat(90), Direction.E);
    DMSRepresentation dmsRepresentation = new DMSRepresentation(latitude, longitude);

    CartesianRepresentation cartesianRepresentation = dmsRepresentation.toCartesianRepresentation();

    assertNotNull(cartesianRepresentation);

    // Calculate expected values
    Apfloat expectedX = ApfloatMath.cos(longitude.getRadianValue())
        .multiply(ApfloatMath.cos(latitude.getRadianValue()));
    Apfloat expectedY = ApfloatMath.cos(latitude.getRadianValue())
        .multiply(ApfloatMath.sin(longitude.getRadianValue()));
    Apfloat expectedZ = ApfloatMath.sin(latitude.getRadianValue());

    assertEquals(expectedX, cartesianRepresentation.x());
    assertEquals(expectedY, cartesianRepresentation.y());
    assertEquals(expectedZ, cartesianRepresentation.z());
  }

  @Test
  public void testToDecimalRepresentation() {
    DMSAngle latitude = new DMSAngle(MathUtils.createFloat(45), Direction.N);
    DMSAngle longitude = new DMSAngle(MathUtils.createFloat(90), Direction.E);
    DMSRepresentation dmsRepresentation = new DMSRepresentation(latitude, longitude);

    DecimalRepresentation decimalRepresentation = dmsRepresentation.toDecimalRepresentation();

    assertNotNull(decimalRepresentation);
    assertEquals(latitude.getDecimalValue(), decimalRepresentation.latitude());
    assertEquals(longitude.getDecimalValue(), decimalRepresentation.longitude());
  }

  @Test
  public void testToDMSRepresentation() {
    DMSAngle latitude = new DMSAngle(MathUtils.createFloat(45), Direction.N);
    DMSAngle longitude = new DMSAngle(MathUtils.createFloat(90), Direction.E);
    DMSRepresentation dmsRepresentation = new DMSRepresentation(latitude, longitude);

    assertEquals(dmsRepresentation, dmsRepresentation.toDMSRepresentation());
  }

  @Test
  public void testEquals_SameInstance() {
    DMSAngle latitude = new DMSAngle(MathUtils.createFloat(45), Direction.N);
    DMSAngle longitude = new DMSAngle(MathUtils.createFloat(90), Direction.E);
    DMSRepresentation dmsRepresentation = new DMSRepresentation(latitude, longitude);

    // Reflexive property: an object is equal to itself
    assertTrue(dmsRepresentation.equals(dmsRepresentation));
  }

  @Test
  public void testEquals_EquivalentInstances() {
    DMSAngle latitude1 = new DMSAngle(MathUtils.createFloat(45), Direction.N);
    DMSAngle longitude1 = new DMSAngle(MathUtils.createFloat(90), Direction.E);
    DMSRepresentation dmsRepresentation1 = new DMSRepresentation(latitude1, longitude1);

    DMSAngle latitude2 = new DMSAngle(MathUtils.createFloat(45), Direction.N);
    DMSAngle longitude2 = new DMSAngle(MathUtils.createFloat(90), Direction.E);
    DMSRepresentation dmsRepresentation2 = new DMSRepresentation(latitude2, longitude2);

    // Symmetry property: equivalent objects should be equal
    assertTrue(dmsRepresentation1.equals(dmsRepresentation2));
    assertTrue(dmsRepresentation2.equals(dmsRepresentation1));
  }

  @Test
  public void testEquals_DifferentLatitude() {
    DMSAngle latitude1 = new DMSAngle(MathUtils.createFloat(45), Direction.N);
    DMSAngle latitude2 = new DMSAngle(MathUtils.createFloat(46), Direction.N);
    DMSAngle longitude = new DMSAngle(MathUtils.createFloat(90), Direction.E);

    DMSRepresentation dmsRepresentation1 = new DMSRepresentation(latitude1, longitude);
    DMSRepresentation dmsRepresentation2 = new DMSRepresentation(latitude2, longitude);

    // Test with different latitude
    assertFalse(dmsRepresentation1.equals(dmsRepresentation2));
  }

  @Test
  public void testEquals_DifferentLongitude() {
    DMSAngle latitude = new DMSAngle(MathUtils.createFloat(45), Direction.N);
    DMSAngle longitude1 = new DMSAngle(MathUtils.createFloat(90), Direction.E);
    DMSAngle longitude2 = new DMSAngle(MathUtils.createFloat(91), Direction.E);

    DMSRepresentation dmsRepresentation1 = new DMSRepresentation(latitude, longitude1);
    DMSRepresentation dmsRepresentation2 = new DMSRepresentation(latitude, longitude2);

    // Test with different longitude
    assertFalse(dmsRepresentation1.equals(dmsRepresentation2));
  }

  @Test
  public void testEquals_Null() {
    DMSAngle latitude = new DMSAngle(MathUtils.createFloat(45), Direction.N);
    DMSAngle longitude = new DMSAngle(MathUtils.createFloat(90), Direction.E);
    DMSRepresentation dmsRepresentation = new DMSRepresentation(latitude, longitude);

    // Test against null
    assertFalse(dmsRepresentation.equals(null));
  }

  @Test
  public void testEquals_DifferentClass() {
    DMSAngle latitude = new DMSAngle(MathUtils.createFloat(45), Direction.N);
    DMSAngle longitude = new DMSAngle(MathUtils.createFloat(90), Direction.E);
    DMSRepresentation dmsRepresentation = new DMSRepresentation(latitude, longitude);

    // Test against an object of a different type
    assertFalse(dmsRepresentation.equals("A String Object"));
  }

  @Test
  public void testEquals_DifferentLatitudeAndLongitude() {
    DMSAngle latitude1 = new DMSAngle(MathUtils.createFloat(45), Direction.N);
    DMSAngle longitude1 = new DMSAngle(MathUtils.createFloat(90), Direction.E);

    DMSAngle latitude2 = new DMSAngle(MathUtils.createFloat(46), Direction.N);
    DMSAngle longitude2 = new DMSAngle(MathUtils.createFloat(91), Direction.E);

    DMSRepresentation dmsRepresentation1 = new DMSRepresentation(latitude1, longitude1);
    DMSRepresentation dmsRepresentation2 = new DMSRepresentation(latitude2, longitude2);

    // Test with both latitude and longitude different
    assertFalse(dmsRepresentation1.equals(dmsRepresentation2));
  }

  @Test
  public void testHashCode() {
    DMSAngle latitude = new DMSAngle(MathUtils.createFloat(45), Direction.N);
    DMSAngle longitude = new DMSAngle(MathUtils.createFloat(90), Direction.E);
    DMSRepresentation dmsRepresentation1 = new DMSRepresentation(latitude, longitude);
    DMSRepresentation dmsRepresentation2 = new DMSRepresentation(latitude, longitude);

    assertEquals(dmsRepresentation1.hashCode(), dmsRepresentation2.hashCode());
  }

  @Test
  public void testToString() {
    DMSAngle latitude = new DMSAngle(MathUtils.createFloat(45), Direction.N);
    DMSAngle longitude = new DMSAngle(MathUtils.createFloat(90), Direction.E);
    DMSRepresentation dmsRepresentation = new DMSRepresentation(latitude, longitude);

    String expected = "DMSRepresentation{latitude=" + latitude + ", longitude=" + longitude + "}";
    assertEquals(expected, dmsRepresentation.toString());
  }
}
