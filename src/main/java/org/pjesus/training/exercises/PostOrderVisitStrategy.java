package org.pjesus.training.exercises;

import org.pjesus.training.structures.BinaryTreeNode;

import java.util.function.Function;

public class PostOrderVisitStrategy implements VisitStrategy {
  public PostOrderVisitStrategy() {}

  public <T> void visit(BinaryTreeNode<T> node, Function<BinaryTreeNode<T>, ?> visitFn) {
    if (node.getLeftChild() != null) {
      visit(node.getLeftChild(), visitFn);
    }
    if (node.getRightChild() != null) {
      visit(node.getRightChild(), visitFn);
    }
    visitFn.apply(node);
  }
}
