package org.pjesus.training.exercises;

import org.pjesus.training.structures.BinaryTreeNode;

import java.util.function.Function;

public interface VisitStrategy {
  <T> void visit(BinaryTreeNode<T> node, Function<BinaryTreeNode<T>, ?> visitFn);
}
