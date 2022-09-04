package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import lib.Complex;

public class TestComplex {
  @Test
  public void testModule() {
    Complex complex = new Complex(3, 4);
    assertEquals(5, complex.module(), 0);
  }

  @Test
  public void testSum() {
    Complex complex = new Complex(3, 4);
    Complex result = complex.sum(new Complex(1, 2));

    assertEquals(4, result.real(), 0);
    assertEquals(6, result.imaginary(), 0);
  }
  
  @Test
  public void testSumWith() {
    Complex complex = new Complex(3, 4);
    complex.sum_with(1, 2);

    assertEquals(4, complex.real(), 0);
    assertEquals(6, complex.imaginary(), 0);
  }

  @Test
  public void testSub() {
    Complex complex = new Complex(3, 4);
    Complex result = complex.sub(new Complex(1, 2));

    assertEquals(2, result.real(), 0);
    assertEquals(2, result.imaginary(), 0);
  }

  @Test
  public void testSubWith() {
    Complex complex = new Complex(3, 4);
    complex.sub_with(1, 2);

    assertEquals(2, complex.real(), 0);
    assertEquals(2, complex.imaginary(), 0);
  }

  @Test
  public void testMultiply() {
    Complex complex = new Complex(3, 4);
    Complex result = complex.multiply(new Complex(1, 2));

    assertEquals(-5, result.real(), 0);
    assertEquals(10, result.imaginary(), 0);
  }

  @Test
  public void testMultiplyWith() {
    Complex complex = new Complex(3, 4);
    complex.multiply_with(1, 2);

    assertEquals(-5, complex.real(), 0);
    assertEquals(10, complex.imaginary(), 0);
  }

  @Test
  public void testArgument() {
    Complex complex = new Complex(3, 4);
    assertEquals(Math.atan(4.0 / 3.0), complex.argument(), 0);

    complex = new Complex(-3, -4);
    assertEquals(-Math.PI + Math.atan(-4.0 / -3.0), complex.argument(), 0);

    complex = new Complex(-3, 4);
    assertEquals(Math.PI + Math.atan(-4.0 / 3.0), complex.argument(), 0);
  }

  @Test
  public void testToString() {
    Complex complex = new Complex(3, 4);
    assertEquals("3.00+4.00i", complex.toString());
  }
}
