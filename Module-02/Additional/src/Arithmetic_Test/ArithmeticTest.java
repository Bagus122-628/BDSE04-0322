package Arithmetic_Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArithmeticTest {
  @Test
  void testAdd() {
    var result = Arithmetic.add(10, 20);
    assertEquals(30, result);
  }

  @Test
  void testSubstraction() {
    var result = Arithmetic.substraction(10, 20);
    assertEquals(-10, result);
  }

  @Test
  void testMultiplication() {
    var result = Arithmetic.multiplication(10, 20);
    assertEquals(200, result);
  }

  @Test
  void testDivision() {
    var result = Arithmetic.division(20, 10);
    assertEquals(2, result);
  }
}
