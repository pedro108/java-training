package org.pjesus.training.structures;

import org.pjesus.training.exercises.VisitStrategy;

import java.util.function.Function;

public class BinaryTree<T> {
  private BinaryTreeNode<T> root = new BinaryTreeNode<>();
  private VisitStrategy visitStrategy;

  public BinaryTree() {}

  public BinaryTreeNode<T> getRoot() {
    return root;
  }

  public void setRoot(BinaryTreeNode<T> root) {
    this.root = root;
  }

  public BinaryTree<T> setVisitStrategy(VisitStrategy visitStrategy) {
    this.visitStrategy = visitStrategy;
    return this;
  }

  public void visit(Function<BinaryTreeNode<T>, ?> visitFn) {
    this.visitStrategy.visit(this.root, visitFn);
  }

  public int getHeight() {
    return this.root.getHeight();
  }
}
