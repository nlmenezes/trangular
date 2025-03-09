package com.nlmenezes.trangular.core.location.cartesian;

import static com.nlmenezes.trangular.core.location.dms.Direction.E;
import static com.nlmenezes.trangular.core.location.dms.Direction.N;

import com.nlmenezes.trangular.core.location.LocationRepresentation;
import com.nlmenezes.trangular.core.location.decimal.DecimalRepresentation;
import com.nlmenezes.trangular.core.location.dms.DMSAngle;
import com.nlmenezes.trangular.core.location.dms.DMSRepresentation;
import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

public record CartesianRepresentation(Apfloat x, Apfloat y, Apfloat z) implements
    LocationRepresentation {

  @Override
  public CartesianRepresentation toCartesianRepresentation() {
    return this;
  }

  @Override
  public DecimalRepresentation toDecimalRepresentation() {
    return toDMSRepresentation().toDecimalRepresentation();
  }

  @Override
  public DMSRepresentation toDMSRepresentation() {
    Apfloat hypotenuse = ApfloatMath.sqrt(x.multiply(x).add(y.multiply(y)));
    DMSAngle latitude = new DMSAngle(ApfloatMath.toDegrees(ApfloatMath.atan2(z, hypotenuse)), N);
    DMSAngle longitude = new DMSAngle(ApfloatMath.toDegrees(ApfloatMath.atan2(y, x)), E);
    return new DMSRepresentation(latitude, longitude);
  }
}
