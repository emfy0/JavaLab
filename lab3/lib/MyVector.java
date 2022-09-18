package lib;

import java.util.Arrays;

public class MyVector {
  private Object[] objectArray;
  private int length;
  private int capacity;

  public MyVector(Object[] array) {
    length = array.length;
    capacity = 2 * length + 10;
    objectArray = Arrays.copyOf(array, length * 2 + 10);
  }

  public MyVector() {
    objectArray = new Object[10];
    length = 0;
    capacity = 10;
  }

  public MyVector(int size) {
    length = size;
    capacity = size * 2 + 10;
    objectArray = new Object[capacity];
  }

  public MyVector(MyVector copyFrom) {
    objectArray = Arrays.copyOf(copyFrom.objectArray, copyFrom.objectArray.length);
    length = copyFrom.length;
    capacity = copyFrom.capacity;
  }

  public int length() {
    return length;
  }

  public int capacity() {
    return capacity;
  }

  public Object atIndex(int index) throws Exception {
    if (index >= length) {
      throw new Exception("Out of range index!");
    }

    return objectArray[index];
  }

  public Object push(Object newObj) {
    length++;
    resolveArrayCapacity();

    objectArray[length - 1] = newObj;

    return newObj;
  }

  public Object pop() throws Exception {
    length--;
    if (length < 0) {
      throw new Exception("Vector is empty!");
    }

    Object deteledObject = objectArray[length];
    objectArray[length] = null;

    return deteledObject;
  }

  public Object replaceAt(int index, Object obj) throws Exception {
    if (index >= length) {
      throw new Exception("Out of range index!");
    }

    objectArray[index] = obj;

    return obj;
  }

  public Object deleteAt(int index) throws Exception {
    if (index >= length) {
      throw new Exception("Out of range index!");
    }

    Object objectAtIndex = objectArray[index];

    for (int i = index; i < length - 1; i++) {
      objectArray[i] = objectArray[i + 1];
    }

    length--;
    objectArray[length] = null;

    return objectAtIndex;
  }

  public Object insertAt(int index, Object obj) throws Exception {
    if (index >= length) {
      throw new Exception("Out of range index!");
    }

    length++;
    resolveArrayCapacity();

    for (int i = length - 2; i >= index; i--) {
      objectArray[i + 1] = objectArray[i];
    }

    objectArray[index] = obj;

    return obj;
  }

  public MyVector reduceTo(int size) throws Exception {
    if (size > length) {
      throw new Exception("Out of range size!");
    }

    for (int i = size; i < length; i++) {
      objectArray[i] = null;
    }

    length = size;

    return this;
  }

  public MyVector removeAllElements() {
    objectArray = null;
    length = 0;
    capacity = 0;

    return this;
  }

  private void resolveArrayCapacity() {
    if (length > capacity) {
      int newCapacity = length * 2 + 10;

      Object[] tempArray = new Object[newCapacity];
      System.arraycopy(objectArray, 0, tempArray, 0, capacity);

      capacity = newCapacity;
      objectArray = tempArray;
    }
  }
}
