package lib;

public class Complex {
  private double real_part;
  private double imaginary_part;

  public Complex (double real_part, double imaginary_part) {
    this.real_part = real_part;
    this.imaginary_part = imaginary_part;
  }

  public double real() {
    return real_part;
  }

  public double imaginary() {
    return imaginary_part;
  }

  public double module() {
    return Math.hypot(real_part, imaginary_part);
  }

  public double argument() {
    if (real_part > 0) {
      return Math.atan(imaginary_part / real_part);
    } else if (imaginary_part < 0) {
      return Math.atan(imaginary_part / real_part) - Math.PI;
    } else {
      return Math.atan(imaginary_part / real_part) + Math.PI;
    }
  }

  public Complex sum(Complex another) {
    double real = real_part + another.real_part;
    double imaginary = imaginary_part + another.imaginary_part;
    return new Complex(real, imaginary);
  }

  public Complex sub(Complex another) {
    double real = real_part - another.real_part;
    double imaginary = imaginary_part - another.imaginary_part;
    return new Complex(real, imaginary);
  }

  public Complex sum_with(double real, double imaginary) {
    real_part += real;
    imaginary_part += imaginary;
    return this;
  }

  public Complex sub_with(double real, double imaginary) {
    real_part -= real;
    imaginary_part -= imaginary;
    return this;
  }

  public Complex multiply(Complex another) {
    double real = real_part * another.real_part - imaginary_part * another.imaginary_part;
    double imaginary = real_part * another.imaginary_part + imaginary_part * another.real_part;
    return new Complex(real, imaginary);
  }

  public Complex multiply_with(double real, double imaginary) {
    double current_real = real_part;
    double current_imaginary = imaginary_part;

    real_part = current_real * real - current_imaginary * imaginary;
    imaginary_part = current_real * imaginary + current_imaginary * real;
    return this;
  }

  public String toString() {
    return String.format("%.2f+%.2fi", real_part, imaginary_part);
  }
}
