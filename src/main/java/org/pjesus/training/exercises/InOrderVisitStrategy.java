package org.pjesus.training.exercises;

import org.pjesus.training.structures.BinaryTreeNode;

import java.util.function.Function;

public class InOrderVisitStrategy implements VisitStrategy {
  public InOrderVisitStrategy() {}

  public <T> void visit(BinaryTreeNode<T> node, Function<BinaryTreeNode<T>, ?> visitFn) {
    if (node.getLeftChild() != null) {
      visit(node.getLeftChild(), visitFn);
    }
    visitFn.apply(node);
    if (node.getRightChild() != null) {
      visit(node.getRightChild(), visitFn);
    }
  }
}
