package lib;

public class MyList {
  private class Node {
    private Object object;
    private Node next;
    private Node prev;

    Node(Object object, Node next, Node prev) {
      this.object = object;
      this.next = next;
      this.prev = prev;
    }
  }

  private int size;
  private Node first;
  private Node last;

  public MyList() {
    size = 0;
    first = null;
    last = null;
  }

  public MyList(MyList copyFrom) throws Exception {
    for (int i = 0; i < copyFrom.size(); i++) {
      push(copyFrom.atIndex(i));
    }
  }

  public Object last() {
    return last.object;
  }

  public Object first() {
    return first.object;
  }

  public int size() {
    return size;
  }

  public Object unshift(Object object) {
    size++;
    if (size == 1) {
      return initializeList(object);
    }

    first = new Node(object, first, null);
    return object;
  }

  public Object push(Object object) {
    size++;
    if (size == 1) {
      return initializeList(object);
    }

    last.next = new Node(object, null, null);
    last = last.next;
    return object;
  }

  public Object shift() throws Exception {
    if (size == 0) {
      throw new Exception("List is empty");
    }

    Object curFirstObj = first.object;

    size--;
    if (size == 0) {
      destroy();
    } else {
      first = first.next;
    }

    return curFirstObj;
  }

  public Object pop() throws Exception {
    if (size == 0) {
      throw new Exception("List is empty");
    }

    Object curObject = last.object;

    size--;
    if (size == 0) {
      destroy();
    } else {
      Node penultimateNode = getNodeAtIndex(size - 2);
      penultimateNode.next = null;
      last = penultimateNode;
    }

    return curObject;
  }

  public Object deleteAt(int index) throws Exception {
    if (index == size - 1) {
      return pop();
    } else if (index == 0) {
      return shift();
    }

    Node node = getNodeAtIndex(index - 1);
    size--;

    Object prevNodeObject = node.next.object;
    node.next = node.next.next;
    return prevNodeObject;
  }

  public Object bubbleSort() throws Exception {
    if (size == 0) {
      throw new Exception("List is empty");
    }

    for (int i = 0; i < size; i++) {
      for (int j = size - 1; j > i; j--) {
        if ((int) getNodeAtIndex(j).object < (int) (getNodeAtIndex(j - 1).object)) {
          Object tmp = getNodeAtIndex(j - 1).object;
          getNodeAtIndex(j - 1).object = getNodeAtIndex(j).object;
          getNodeAtIndex(j).object = tmp;
        }
      }
    }

    return this;
  }

  public Object atIndex(int index) throws Exception {
    if (index == size - 1) {
      return last.object;
    } else if (index == 0) {
      return first.object;
    }

    Node node = getNodeAtIndex(index);
    return node.object;
  }

  public void destroy() {
    first = null;
    last = null;
    size = 0;
  }

  private Node initializeList (Object object) {
    last = new Node(object, null, null);
    return first = last;
  }

  private Node getNodeAtIndex(int index) throws Exception {
    if (index > size) {
      throw new Exception("Index is out of range");
    }

    Node node = first;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }

    return node;
  }
}
