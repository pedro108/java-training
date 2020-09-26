package org.pjesus.training.algorithms;

import org.pjesus.training.structures.LinkedList;
import org.pjesus.training.structures.LinkedListNode;

import java.util.concurrent.atomic.AtomicReference;

public class Quicksort implements SortStrategy {
  private int executionSteps = 0;

  @Override
  public <T extends Comparable<T>> LinkedList<T> sort(LinkedList<T> list) {
    this.executionSteps = 0;
    return applySort(list, 0, list.getLength() - 1);
  }

  @Override
  public int getExecutionSteps() {
    return this.executionSteps;
  }

  private <T extends Comparable<T>> LinkedList<T> applySort(LinkedList<T> list, int low, int high) {
    if (low < high) {
      int partitionResult = applyPartition(list, low, high);
      applySort(list, low, partitionResult - 1);
      applySort(list, partitionResult + 1, high);
    }

    return list;
  }

  private <T extends Comparable<T>> int applyPartition(LinkedList<T> list, int low, int high) {
    LinkedListNode<T> pivot = list.getTail();
    final LinkedListNode<T>[] newHead = new LinkedListNode[]{pivot};
    list.forEach(node -> {
      if (node.getData().compareTo(pivot.getData()) > 0) {
        pivot.setNext(node);
      } else {
        node.setNext(newHead[0]);
        newHead[0] = node;
      }

      return node;
    });

    return 0;
  }
}
