import lib.MyVector;

public class Main {
  public static void main(String[] args) throws Exception {
    MyVector<String> vector = new MyVector<String> (new String[] {"Helo", "world"});
    vector.push("!");

    System.out.println(
      vector.atIndex(0) + " " +
      vector.atIndex(1) + "" +
      vector.atIndex(2)
    );
  }
}
