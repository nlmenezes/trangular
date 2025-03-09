package com.nlmenezes.trangular.core.location.decimal;

import com.nlmenezes.trangular.core.location.cartesian.CartesianRepresentation;
import com.nlmenezes.trangular.core.location.dms.DMSRepresentation;
import com.nlmenezes.trangular.core.location.dms.DMSAngle;
import com.nlmenezes.trangular.core.location.dms.Direction;
import com.nlmenezes.trangular.core.util.MathUtils;
import org.apfloat.Apfloat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecimalRepresentationTest {

  @Test
  public void testToDecimalRepresentation() {
    Apfloat latitude = MathUtils.createFloat(23.456);
    Apfloat longitude = MathUtils.createFloat(54.321);

    DecimalRepresentation decimalRepresentation = new DecimalRepresentation(latitude, longitude);

    assertEquals(decimalRepresentation, decimalRepresentation.toDecimalRepresentation());
  }

  @Test
  public void testToDMSRepresentation() {
    Apfloat latitude = MathUtils.createFloat(23.456);
    Apfloat longitude = MathUtils.createFloat(54.321);

    DecimalRepresentation decimalRepresentation = new DecimalRepresentation(latitude, longitude);
    DMSRepresentation dmsRepresentation = decimalRepresentation.toDMSRepresentation();

    assertNotNull(dmsRepresentation);
    DMSAngle latitudeAngle = new DMSAngle(latitude, Direction.N);
    DMSAngle longitudeAngle = new DMSAngle(longitude, Direction.E);

    assertEquals(latitudeAngle, dmsRepresentation.latitude());
    assertEquals(longitudeAngle, dmsRepresentation.longitude());
  }

  @Test
  public void testToCartesianRepresentation() {
    Apfloat latitude = MathUtils.createFloat(23.456);
    Apfloat longitude = MathUtils.createFloat(54.321);

    DecimalRepresentation decimalRepresentation = new DecimalRepresentation(latitude, longitude);
    CartesianRepresentation cartesianRepresentation = decimalRepresentation.toCartesianRepresentation();

    assertNotNull(cartesianRepresentation);
    assertEquals(0.5350477947061206, cartesianRepresentation.x().doubleValue());
    assertEquals(0.7451739892893033, cartesianRepresentation.y().doubleValue());
    assertEquals(0.39804469983505886, cartesianRepresentation.z().doubleValue());
  }
}
