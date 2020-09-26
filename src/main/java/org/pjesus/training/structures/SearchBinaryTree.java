package org.pjesus.training.structures;

public class SearchBinaryTree<T extends Comparable<T>> extends BinaryTree<T> {
  public void insert(T value) {
    BinaryTreeNode<T> root = getRoot();
    if (root == null || root.getData() == null) {
      setRoot(new BinaryTreeNode<>(value));
    } else {
      insertInto(value, root);
    }
  }

  public BinaryTreeNode<T> search(T value) {
    BinaryTreeNode<T> root = getRoot();
    if (root == null) {
      return null;
    }

    return null;
  }

  private void insertInto(T value, BinaryTreeNode<T> node) {
    if (node.getData().compareTo(value) > 0) {
      BinaryTreeNode<T> leftChild = node.getLeftChild();
      if (leftChild == null) {
        node.setLeftChild(new BinaryTreeNode<>(value));
      } else {
        insertInto(value, leftChild);
      }
    } else {
      BinaryTreeNode<T> rightChild = node.getRightChild();
      if (rightChild == null) {
        node.setRightChild(new BinaryTreeNode<>(value));
      } else {
        insertInto(value, rightChild);
      }
    }
  }
}
