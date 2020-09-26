package org.pjesus.training.exercises;

import org.pjesus.training.structures.BinaryTreeNode;

import java.util.function.Function;

public class LevelVisitStrategy implements VisitStrategy {
  public LevelVisitStrategy() {}

  public <T> void visit(BinaryTreeNode<T> node, Function<BinaryTreeNode<T>, ?> visitFn) {
    int height = node.getHeight();

    for (int i = 0; i < height + 1; i++) {
      visitLevel(node, i, visitFn);
    }
  }

  private <T> void visitLevel(BinaryTreeNode<T> node, int level, Function<BinaryTreeNode<T>, ?> visitFn) {
    if (node == null) {
      return;
    }

    if (level == 0) {
      visitFn.apply(node);
    } else {
      visitLevel(node.getLeftChild(), level - 1, visitFn);
      visitLevel(node.getRightChild(), level - 1, visitFn);
    }
  }
}
