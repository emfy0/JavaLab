package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import lib.MyVector;

public class TestMyVector {
  @Test
  public void testInitializer() throws Exception {
    MyVector<Integer> vector = new MyVector<Integer> (new Integer[] { 1, 2, 3 });

    assertEquals(3, vector.length());
    assertEquals(16, vector.capacity());
  }

  @Test
  public void testAtIndex() throws Exception {
    MyVector<Object> vector = new MyVector<Object> (new Object[] { 1, "test", 1.3 });

    assertEquals(1.3, vector.atIndex(2));
    assertEquals("test", vector.atIndex(1));

    Exception exception = assertThrows(Exception.class, () -> {
      vector.atIndex(3);
    });

    assertEquals("Out of range index!", exception.getMessage());
  }

  @Test
  public void testPush() throws Exception {
    MyVector<Object> vector = new MyVector<Object> (new Object[] { 1, "test", 1.3 });

    assertEquals("asd", vector.push("asd"));
    assertEquals(4, vector.length());

    for (int i = 0; i < 14; i++) {
      vector.push(i);
    }

    assertEquals(18, vector.length());
    assertEquals(44, vector.capacity());

    assertEquals(13, vector.atIndex(17));
  }

  @Test
  public void testInsertAt() throws Exception {
    MyVector<Object> vector = new MyVector<Object> (new Object[] { 1, "test", 1.3, 3 });

    assertEquals("asd", vector.insertAt(1, "asd"));
    assertEquals(5, vector.length());

    assertEquals(1, vector.atIndex(0));
    assertEquals("asd", vector.atIndex(1));
    assertEquals("test", vector.atIndex(2));
    assertEquals(1.3, vector.atIndex(3));
    assertEquals(3, vector.atIndex(4));
  }

  @Test
  public void testReplaceAt() throws Exception {
    MyVector<Object> vector = new MyVector<Object> (new Object[] { 1, "test", 1.3, 3 });

    assertEquals("asd", vector.replaceAt(1, "asd"));
    assertEquals(4, vector.length());

    assertEquals(1, vector.atIndex(0));
    assertEquals("asd", vector.atIndex(1));
    assertEquals(1.3, vector.atIndex(2));
    assertEquals(3, vector.atIndex(3));
  }

  @Test
  public void testPop() throws Exception {
    MyVector<Object> vector = new MyVector<Object> (new Object[] { 1, "test", 1.3, 3 });

    assertEquals(3, vector.pop());
    assertEquals(3, vector.length());

    assertEquals(1, vector.atIndex(0));
    assertEquals("test", vector.atIndex(1));
    assertEquals(1.3, vector.atIndex(2));
  }

  @Test
  public void testDeleteAt() throws Exception {
    MyVector<Object> vector = new MyVector<Object> (new Object[] { 1, "test", 1.3, 3 });

    assertEquals(1.3, vector.deleteAt(2));
    assertEquals(3, vector.length());

    assertEquals(1, vector.atIndex(0));
    assertEquals("test", vector.atIndex(1));
    assertEquals(3, vector.atIndex(2));
  }

  @Test
  public void testReduceTo() throws Exception {
    MyVector<Object> vector = new MyVector<Object> (new Object[] { 1, "test", 1.3, 3 });

    assertEquals(vector, vector.reduceTo(2));
    assertEquals(2, vector.length());

    assertEquals(1, vector.atIndex(0));
    assertEquals("test", vector.atIndex(1));
  }

  @Test
  public void testRemoveAllElements() throws Exception {
    MyVector<Object> vector = new MyVector<Object> (new Object[] { 1, "test", 1.3, 3 });

    assertEquals(vector, vector.removeAllElements());
    assertEquals(0, vector.length());
    assertEquals(0, vector.capacity());
  }
}
