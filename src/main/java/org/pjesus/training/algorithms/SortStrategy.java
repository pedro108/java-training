package org.pjesus.training.algorithms;

import org.pjesus.training.structures.LinkedList;

public interface SortStrategy {
  <T extends Comparable<T>> LinkedList<T> sort(LinkedList<T> list);
  int getExecutionSteps();
}
