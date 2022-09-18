import lib.MyVector;

public class Main {
  public static void main(String[] args) throws Exception {
    MyVector vector = new MyVector(new Object[] {"Helo", "world"});
    vector.push("!");

    System.out.println(
      vector.atIndex(0) + " " +
      vector.atIndex(1) + "" +
      vector.atIndex(2)
    );
  }
}
