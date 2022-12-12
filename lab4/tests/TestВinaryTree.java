package tests;

import static org.junit.Assert.*;

import java.beans.Transient;

import org.junit.Test;

import lib.BinaryTree;

public class TestВinaryTree {
  @Test
  public void testInitializer() throws Exception {
    BinaryTree<Integer, Integer> bintree = new BinaryTree<>();

    assertEquals(0, bintree.getLen());

    BinaryTree<Integer, Integer> bintree1 = new BinaryTree<>(10, 10);
    assertEquals(1, bintree1.getLen());

    BinaryTree<Integer, Integer> bintree2 = new BinaryTree<>(bintree1);
    bintree2.insert(11, 11);
    assertEquals(2, bintree2.getLen());
  }

  @Test
  public void testGet() throws Exception {
    BinaryTree<Integer, Integer> bintree = new BinaryTree<>();

    bintree.insert(10, 0);
    assertEquals(Integer.valueOf(0), bintree.get(10));

    bintree.insert(11, 1);
    bintree.insert(9, -1);
    assertEquals(Integer.valueOf(1), bintree.get(11));
    assertEquals(Integer.valueOf(-1), bintree.get(9));

    bintree.insert(10, 3);
    bintree.insert(11, 4);
    assertEquals(Integer.valueOf(4), bintree.get(11));
    assertEquals(Integer.valueOf(3), bintree.get(10));
  }

  @Test
  public void testInsert() throws Exception {
    BinaryTree<Integer, Integer> bintree = new BinaryTree<>();

    bintree.insert(10, 0);
    assertEquals(1, bintree.getLen());

    bintree.insert(11, 1);
    bintree.insert(9, -1);
    assertEquals(3, bintree.getLen());
  }

  @Test
  public void testClear() throws Exception {
    BinaryTree<Integer, Integer> bintree = new BinaryTree<>();

    bintree.insert(10, 0);
    bintree.insert(11, 1);
    bintree.insert(9, -1);
    assertEquals(3, bintree.getLen());

    bintree.clear();
    assertEquals(0, bintree.getLen());
  }

  @Test
  public void sumOfLeftSubtreeElements () throws Exception {
    BinaryTree<Integer, Integer> bintree = new BinaryTree<>();


    //      11
    //   15   13
    // 14    12 9


    //       10
    //     8   20
    //       14  25
    //     13  17

    bintree.insert(10, 10);
    bintree.insert(8, 8);
    bintree.insert(20, 20);
    bintree.insert(14, 14);
    bintree.insert(13, 13);
    bintree.insert(17, 17);
    bintree.insert(25, 25);

    assertEquals(8, bintree.sumOfLeftSubtreeElements(10));
    assertEquals(14 + 13 + 17, bintree.sumOfLeftSubtreeElements(20));
  }
}
// 10 8 20 14 13 17 25
