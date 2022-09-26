package lib;

public class BinaryTree<TKeyType extends Comparable<TKeyType>, TDataType> {

  static class BinaryTreeNode<TKey, TData> {
    private TKey key;
    private TData data;

    private BinaryTreeNode<TKey, TData> left, right;

    public BinaryTreeNode() {}

    public BinaryTreeNode(TKey key, TData data) {
      this.key = key;
      this.data = data;
      this.left = null;
      this.right = null;
    }

    public BinaryTreeNode(TKey key, TData data, BinaryTreeNode<TKey, TData> left,
        BinaryTreeNode<TKey, TData> right) {
      this.key = key;
      this.data = data;
      this.left = left;
      this.right = right;
    }

    public TKey getKey() {
      return this.key;
    }

    public TData getData() {
      return this.data;
    }
  }

  private BinaryTreeNode<TKeyType, TDataType> head;
  private int len;

  public BinaryTree() {
    this.head = null;
    this.len = 0;
  }

  public BinaryTree(TKeyType head_key, TDataType head_data) {
    this.head = new BinaryTreeNode<TKeyType, TDataType>(head_key, head_data);
    this.len = 1;
  }

  private BinaryTree(BinaryTreeNode<TKeyType, TDataType> head, int len) {
    this.head = head;
    this.len = len;
  }

  public BinaryTree(BinaryTree<TKeyType, TDataType> another_tree) {
    this(another_tree.head, another_tree.len);
  }

  public TDataType get(TKeyType k) {
    BinaryTreeNode<TKeyType, TDataType> node = this.head;

    while (node != null) {
      int res = k.compareTo(node.key);

      if (res == 0) {
        return node.data;
      }

      if (res > 0) {
        node = node.right;
      } else {
        node = node.left;
      }
    }

    return null;
  }

  public void insert(TKeyType key, TDataType data) {
    if (this.head == null) {
      this.head = new BinaryTreeNode<TKeyType, TDataType>(key, data);
      this.len++;
      return;
    }

    BinaryTreeNode<TKeyType, TDataType> node = this.head;

    while (node != null) {
      int res = key.compareTo(node.key);

      if (res == 0) {
        node.data = data;
        return;
      } else {
        if (res > 0) {
          if (node.right != null) {
            node = node.right;
          } else {
            node.right = new BinaryTreeNode<TKeyType, TDataType>(key, data);
            this.len++;
            return;
          }
        } else {
          if (node.left != null) {
            node = node.left;
          } else {
            node.left = new BinaryTreeNode<TKeyType, TDataType>(key, data);
            this.len++;
            return;
          }
        }
      }
    }
  }

  public int getLen() {
    return this.len;
  }

  public void clear() {
    this.head = null;
    this.len = 0;
  }
}
