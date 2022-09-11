import lib.MyList;

public class Main {
  public static void main(String[] args) throws Exception {
    MyList list = new MyList();
    list.unshift("World");
    list.unshift("Hello");
    list.push("!");
    list.push(123);

    System.out.println(
      list.first() + " " +
      list.atIndex(1) +
      list.atIndex(2) + " " +
      list.last()
    );
  }
}
