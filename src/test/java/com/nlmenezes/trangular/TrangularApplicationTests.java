package com.nlmenezes.trangular;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TrangularApplicationTests {

  @Test
  public void testMainMethod() {
    // Ensure that the main() method runs without exceptions
    assertDoesNotThrow(() -> TrangularApplication.main(new String[]{}));
  }
}
