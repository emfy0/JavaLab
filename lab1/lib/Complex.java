package lib;

public class Complex {
  double real_part;
  double imaginary_part;

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
    return Math.hypot(this.real_part, this.imaginary_part);
  }

  public double argument() {
    if (this.real_part > 0) {
      return Math.atan(this.imaginary_part / this.real_part);
    } else if (this.imaginary_part < 0) {
      return Math.atan(this.imaginary_part / this.real_part) - Math.PI;
    } else {
      return Math.atan(this.imaginary_part / this.real_part) + Math.PI;
    }
  }

  public Complex sum(Complex another) {
    double real = this.real_part + another.real_part;
    double imaginary = this.imaginary_part + another.imaginary_part;
    return new Complex(real, imaginary);
  }

  public Complex sub(Complex another) {
    double real = this.real_part - another.real_part;
    double imaginary = this.imaginary_part - another.imaginary_part;
    return new Complex(real, imaginary);
  }

  public Complex sum_with(double real, double imaginary) {
    this.real_part += real;
    this.imaginary_part += imaginary;
    return this;
  }

  public Complex sub_with(double real, double imaginary) {
    this.real_part -= real;
    this.imaginary_part -= imaginary;
    return this;
  }

  public Complex multiply(Complex another) {
    double real = this.real_part * another.real_part - this.imaginary_part * another.imaginary_part;
    double imaginary = this.real_part * another.imaginary_part + this.imaginary_part * another.real_part;
    return new Complex(real, imaginary);
  }

  public Complex multiply_with(double real, double imaginary) {
    double current_real = this.real_part;
    double current_imaginary = this.imaginary_part;

    this.real_part = current_real * real - current_imaginary * imaginary;
    this.imaginary_part = current_real * imaginary + current_imaginary * real;
    return this;
  }

  public String toString() {
    return String.format("%.2f+%.2fi", this.real_part, this.imaginary_part);
  }
}
