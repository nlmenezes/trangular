package com.nlmenezes.trangular.core.location.dms;

import com.nlmenezes.trangular.core.location.LocationRepresentation;
import com.nlmenezes.trangular.core.location.cartesian.CartesianRepresentation;
import com.nlmenezes.trangular.core.location.decimal.DecimalRepresentation;
import java.util.Objects;
import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

public record DMSRepresentation(DMSAngle latitude, DMSAngle longitude) implements
    LocationRepresentation {

  @Override
  public CartesianRepresentation toCartesianRepresentation() {
    Apfloat x = ApfloatMath.cos(longitude.getRadianValue())
        .multiply(ApfloatMath.cos(latitude.getRadianValue()));
    Apfloat y = ApfloatMath.cos(latitude.getRadianValue())
        .multiply(ApfloatMath.sin(longitude.getRadianValue()));
    Apfloat z = ApfloatMath.sin(latitude.getRadianValue());
    return new CartesianRepresentation(x, y, z);
  }

  @Override
  public DecimalRepresentation toDecimalRepresentation() {
    return new DecimalRepresentation(latitude.getDecimalValue(), longitude.getDecimalValue());
  }

  @Override
  public DMSRepresentation toDMSRepresentation() {
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DMSRepresentation that)) {
      return false;
    }
    return Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude);
  }

  @Override
  public int hashCode() {
    return Objects.hash(latitude, longitude);
  }

  @Override
  public String toString() {
    return "DMSRepresentation{" + "latitude=" + latitude + ", longitude=" + longitude + '}';
  }
}