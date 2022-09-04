import lib.Complex;

public class Main {
  public static void main(String[] args) {
    Complex complex = new Complex(3, 4);
    Complex result = complex.multiply(new Complex(1, 2));

    System.out.println(result);
  }
}
