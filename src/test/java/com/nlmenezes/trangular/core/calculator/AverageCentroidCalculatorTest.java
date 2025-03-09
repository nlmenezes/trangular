package com.nlmenezes.trangular.core.calculator;

import com.nlmenezes.trangular.core.location.LocationRepresentation;
import com.nlmenezes.trangular.core.location.cartesian.CartesianRepresentation;
import com.nlmenezes.trangular.core.util.MathUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AverageCentroidCalculatorTest {

  private AverageCentroidCalculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new AverageCentroidCalculator();
  }

  @Test
  void testComputeCentroidWithOneLocation() {
    Set<LocationRepresentation> locations = new HashSet<>();
    locations.add(new CartesianRepresentation(MathUtils.createFloat(1), MathUtils.createFloat(2), MathUtils.createFloat(3)));

    LocationRepresentation centroid = calculator.computeCentroid(locations);

    assertEquals(new CartesianRepresentation(MathUtils.createFloat(1), MathUtils.createFloat(2), MathUtils.createFloat(3)), centroid);
  }

  @Test
  void testComputeCentroidWithMultipleLocations() {
    Set<LocationRepresentation> locations = new HashSet<>();
    locations.add(new CartesianRepresentation(MathUtils.createFloat(1), MathUtils.createFloat(2), MathUtils.createFloat(3)));
    locations.add(new CartesianRepresentation(MathUtils.createFloat(4), MathUtils.createFloat(5), MathUtils.createFloat(6)));
    locations.add(new CartesianRepresentation(MathUtils.createFloat(7), MathUtils.createFloat(8), MathUtils.createFloat(9)));

    LocationRepresentation centroid = calculator.computeCentroid(locations);

    assertEquals(new CartesianRepresentation(MathUtils.createFloat(4), MathUtils.createFloat(5), MathUtils.createFloat(6)), centroid);
  }

  @Test
  void testComputeCentroidWithEmptySet() {
    Set<LocationRepresentation> locations = new HashSet<>();

    LocationRepresentation centroid = calculator.computeCentroid(locations);

    assertEquals(new CartesianRepresentation(MathUtils.createFloat(0), MathUtils.createFloat(0), MathUtils.createFloat(0)), centroid);
  }
}