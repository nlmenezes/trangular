package com.nlmenezes.trangular.core.util;

import org.apfloat.Apfloat;

public class MathUtils {

  // 10^-10
  public static final Apfloat DELTA = new Apfloat(1).divide(new Apfloat(10000000000L));
  private static final int PRECISION = 128;

  public static Apfloat createFloat(int val) {
    return new Apfloat(val, PRECISION);
  }

  public static Apfloat createFloat(double val) {
    return new Apfloat(val, PRECISION);
  }
}
