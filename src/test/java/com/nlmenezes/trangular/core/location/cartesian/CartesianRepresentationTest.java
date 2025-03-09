package com.nlmenezes.trangular.core.location.cartesian;

import com.nlmenezes.trangular.core.location.decimal.DecimalRepresentation;
import com.nlmenezes.trangular.core.location.dms.DMSAngle;
import com.nlmenezes.trangular.core.location.dms.DMSRepresentation;
import com.nlmenezes.trangular.core.location.dms.Direction;
import com.nlmenezes.trangular.core.util.MathUtils;
import org.apfloat.ApfloatMath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartesianRepresentationTest {

  private CartesianRepresentation cartesianRepresentation;

  @BeforeEach
  void setUp() {
    cartesianRepresentation = new CartesianRepresentation(
        MathUtils.createFloat(1),
        MathUtils.createFloat(2),
        MathUtils.createFloat(3)
    );
  }

  @Test
  void testToCartesianRepresentation() {
    CartesianRepresentation result = cartesianRepresentation.toCartesianRepresentation();
    assertEquals(cartesianRepresentation, result);
  }

  @Test
  void testToDecimalRepresentation() {
    DMSRepresentation dmsRepresentation = new DMSRepresentation(
        new DMSAngle(ApfloatMath.toDegrees(ApfloatMath.atan2(MathUtils.createFloat(3),
            ApfloatMath.sqrt(MathUtils.createFloat(5)))), Direction.N),
        new DMSAngle(ApfloatMath.toDegrees(ApfloatMath.atan2(MathUtils.createFloat(2),
            MathUtils.createFloat(1))), Direction.E)
    );
    DecimalRepresentation decimalRepresentation = dmsRepresentation.toDecimalRepresentation();
    assertEquals(decimalRepresentation, cartesianRepresentation.toDecimalRepresentation());
  }

  @Test
  void testToDMSRepresentation() {
    DMSRepresentation dmsRepresentation = new DMSRepresentation(
        new DMSAngle(ApfloatMath.toDegrees(ApfloatMath.atan2(MathUtils.createFloat(3),
            ApfloatMath.sqrt(MathUtils.createFloat(5)))), Direction.N),
        new DMSAngle(ApfloatMath.toDegrees(ApfloatMath.atan2(MathUtils.createFloat(2),
            MathUtils.createFloat(1))), Direction.E)
    );
    assertEquals(dmsRepresentation, cartesianRepresentation.toDMSRepresentation());
  }
}
