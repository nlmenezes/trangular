package com.nlmenezes.trangular.core.location.decimal;

import com.nlmenezes.trangular.core.location.LocationRepresentation;
import com.nlmenezes.trangular.core.location.cartesian.CartesianRepresentation;
import com.nlmenezes.trangular.core.location.dms.DMSAngle;
import com.nlmenezes.trangular.core.location.dms.DMSRepresentation;
import com.nlmenezes.trangular.core.location.dms.Direction;
import org.apfloat.Apfloat;

public record DecimalRepresentation(Apfloat latitude, Apfloat longitude) implements
    LocationRepresentation {

  @Override
  public CartesianRepresentation toCartesianRepresentation() {
    return toDMSRepresentation().toCartesianRepresentation();
  }

  @Override
  public DecimalRepresentation toDecimalRepresentation() {
    return this;
  }

  @Override
  public DMSRepresentation toDMSRepresentation() {
    return new DMSRepresentation(new DMSAngle(latitude, Direction.N),
        new DMSAngle(longitude, Direction.E));
  }
}
