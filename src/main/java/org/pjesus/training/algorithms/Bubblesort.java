package org.pjesus.training.algorithms;

import org.pjesus.training.structures.LinkedList;
import org.pjesus.training.structures.LinkedListNode;

public class Bubblesort implements SortStrategy {
  private int executionSteps = 0;

  public Bubblesort() {}

  @Override
  public <T extends Comparable<T>> LinkedList<T> sort(LinkedList<T> list) {
    this.executionSteps = 0;
    return applySort(list);
  }

  @Override
  public int getExecutionSteps() {
    return executionSteps;
  }

  private <T extends Comparable<T>> LinkedList<T> applySort(LinkedList<T> list) {
    if (isSorted(list)) {
      return list;
    }

    return applySort(executeSortStep(list));
  }

  private <T extends Comparable<T>> boolean isSorted(LinkedList<T> list) {
    if (list.getHead() == null) {
      return true;
    }

    final boolean[] isSorted = {true};
    list.forEach(node -> {
      LinkedListNode<T> nextNode = node.getNext();
      if (nextNode != null && node.getData().compareTo(nextNode.getData()) > 0) {
        isSorted[0] = false;
      }
      return node;
    });

    return isSorted[0];
  }

  private <T extends Comparable<T>> LinkedList<T> executeSortStep(LinkedList<T> list) {
    LinkedListNode<T> sortedHead = executeSortStepForNode(list.getHead(), null, list.getHead(), list.getHead().getNext());
    return new LinkedList<>(sortedHead);
  }

  private <T extends Comparable<T>> LinkedListNode<T> executeSortStepForNode(LinkedListNode<T> head, LinkedListNode<T> prevNode, LinkedListNode<T> node, LinkedListNode<T> nextNode) {
    executionSteps++;
    if (nextNode == null) {
      return head;
    }

    if(node.getData().compareTo(nextNode.getData()) > 0) {
      node.setNext(nextNode.getNext());
      nextNode.setNext(node);
      if (prevNode != null) {
        prevNode.setNext(nextNode);
        return executeSortStepForNode(head, nextNode, node, node.getNext());
      }

      return executeSortStepForNode(nextNode, nextNode, node, node.getNext());
    }

    return executeSortStepForNode(head, node, nextNode, nextNode.getNext());
  }
}
