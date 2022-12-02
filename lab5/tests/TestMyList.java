package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import lib.MyList;

public class TestMyList {
  @Test
  public void bubleSort() throws Exception {
    MyList list = new MyList();
    list.push(1);
    list.push(2);
    list.push(5);
    list.push(3);
    list.push(4);

    list.bubbleSort();
    
    assertEquals(1, list.atIndex(0));
    assertEquals(2, list.atIndex(1));
    assertEquals(3, list.atIndex(2));
    assertEquals(4, list.atIndex(3));
    assertEquals(5, list.atIndex(4));

  }
}
