package com.nlmenezes.trangular.core.calculator;

import com.nlmenezes.trangular.core.location.LocationRepresentation;
import com.nlmenezes.trangular.core.location.cartesian.CartesianRepresentation;
import com.nlmenezes.trangular.core.util.MathUtils;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apfloat.Apfloat;

public class AverageCentroidCalculator implements CentroidCalculator {

  @Override
  public LocationRepresentation computeCentroid(Set<LocationRepresentation> locations) {
    long count = locations.parallelStream().count();

    if (count == 0) {
      return new CartesianRepresentation(
          MathUtils.createFloat(0), MathUtils.createFloat(0), MathUtils.createFloat(0)
      );
    }

    Set<CartesianRepresentation> cartesianRepresentations = locations
        .parallelStream()
        .map(LocationRepresentation::toCartesianRepresentation)
        .collect(Collectors.toSet());

    Function<Function<CartesianRepresentation, Apfloat>, Apfloat> average =
        (getAxis) ->
            cartesianRepresentations
                .parallelStream()
                .map(getAxis)
                .reduce(MathUtils.createFloat(0), Apfloat::add)
                .divide(MathUtils.createFloat(count));

    return new CartesianRepresentation(
        average.apply(CartesianRepresentation::x),
        average.apply(CartesianRepresentation::y),
        average.apply(CartesianRepresentation::z)
    );
  }
}
