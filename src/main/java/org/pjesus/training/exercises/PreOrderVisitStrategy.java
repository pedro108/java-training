package org.pjesus.training.exercises;

import org.pjesus.training.structures.BinaryTreeNode;

import java.util.function.Function;

public class PreOrderVisitStrategy implements VisitStrategy {
  public PreOrderVisitStrategy() {}

  public <T> void visit(BinaryTreeNode<T> node, Function<BinaryTreeNode<T>, ?> visitFn) {
    visitFn.apply(node);
    if (node.getLeftChild() != null) {
      visit(node.getLeftChild(), visitFn);
    }
    if (node.getRightChild() != null) {
      visit(node.getRightChild(), visitFn);
    }
  }
}
