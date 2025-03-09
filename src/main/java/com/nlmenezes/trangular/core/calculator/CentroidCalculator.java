package com.nlmenezes.trangular.core.calculator;

import com.nlmenezes.trangular.core.location.LocationRepresentation;
import java.util.Set;

public interface CentroidCalculator {

  LocationRepresentation computeCentroid(Set<LocationRepresentation> locations);
}
