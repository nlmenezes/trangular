package com.nlmenezes.trangular.core.location.dms;

import static com.nlmenezes.trangular.core.location.dms.Direction.S;
import static com.nlmenezes.trangular.core.location.dms.Direction.W;
import static com.nlmenezes.trangular.core.util.MathUtils.DELTA;

import com.nlmenezes.trangular.core.util.MathUtils;
import java.util.Objects;
import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

public class DMSAngle {

  private final int degree;
  private final int minute;
  private final Apfloat second;
  private final Direction direction;

  public DMSAngle(Apfloat degrees, Direction posDirection) {
    if(posDirection==Direction.S || posDirection==Direction.W) {
      throw new IllegalArgumentException("posDirection must be either N or E");
    }
    Apfloat abs = ApfloatMath.abs(degrees);
    this.degree = abs.intValue();
    Apfloat remainder = abs.frac().multiply(MathUtils.createFloat(60));
    this.minute = remainder.truncate().intValue();
    this.second = remainder.frac().multiply(MathUtils.createFloat(60));
    this.direction = degrees.compareTo(MathUtils.createFloat(0)) >= 0 ? posDirection
        : posDirection.getNegative();
  }

  public Apfloat getDecimalValue() {
    Apfloat magnitude = MathUtils.createFloat(degree)
        .add(MathUtils.createFloat(minute).divide(MathUtils.createFloat(60)))
        .add(second.divide(MathUtils.createFloat(3600)));
    return direction == W || direction == S ? magnitude.negate() : magnitude;
  }

  public Apfloat getRadianValue() {
    return ApfloatMath.toRadians(getDecimalValue());
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DMSAngle that)) {
      return false;
    }
    return degree == that.degree && minute == that.minute
        && ApfloatMath.abs(second.subtract(that.second)).compareTo(DELTA) < 0
        && direction == that.direction;
  }

  @Override
  public int hashCode() {
    return Objects.hash(degree, minute, second, direction);
  }

  @Override
  public String toString() {
    return "DMSAngle{" +
        "degree=" + degree +
        ", minute=" + minute +
        ", second=" + second +
        ", direction=" + direction +
        '}';
  }

  public Direction getDirection() {
    return direction;
  }
}
