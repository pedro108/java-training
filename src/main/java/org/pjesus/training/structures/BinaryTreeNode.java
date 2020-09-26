package org.pjesus.training.structures;

import org.pjesus.training.exercises.PostOrderVisitStrategy;

public class BinaryTreeNode<T> {
  private BinaryTreeNode<T> leftChild;
  private BinaryTreeNode<T> rightChild;
  private T data;

  public BinaryTreeNode() {}

  public BinaryTreeNode(T data) {
    this.data = data;
  }

  public BinaryTreeNode<T> getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(BinaryTreeNode<T> leftChild) {
    this.leftChild = leftChild;
  }

  public void setLeftChild(T leftChildData) {
    this.leftChild = new BinaryTreeNode<>(leftChildData);
  }

  public BinaryTreeNode<T> getRightChild() {
    return rightChild;
  }

  public void setRightChild(BinaryTreeNode<T> rightChild) {
    this.rightChild = rightChild;
  }

  public void setRightChild(T rightChildData) {
    this.rightChild = new BinaryTreeNode<>(rightChildData);
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public int getHeight() {
    final int[] height = {0};
    (new PostOrderVisitStrategy()).visit(this, node -> {
      if (node.getLeftChild() == null && node.getRightChild() == null) {
        return 0;
      }

      int leftHeight = (node.getLeftChild() != null) ? node.getLeftChild().getHeight() : 0;
      int rightHeight = (node.getRightChild() != null) ? node.getRightChild().getHeight() : 0;
      height[0] = Math.max(leftHeight, rightHeight) + 1;
      return height;
    });

    return height[0];
  }
}
