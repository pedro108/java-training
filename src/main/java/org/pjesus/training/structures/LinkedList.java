package org.pjesus.training.structures;

import org.pjesus.training.algorithms.SortStrategy;

import java.util.function.Function;

public class LinkedList<T extends Comparable<T>> {
  private LinkedListNode<T> head = null;

  public LinkedList() {}

  public LinkedList(LinkedListNode<T> head) {
    this.head = head;
  }

  public LinkedListNode<T> getHead() {
    return head;
  }

  public void setHead(LinkedListNode<T> head) {
    this.head = head;
  }

  public LinkedListNode<T> getTail() {
    return getTailForNode(head);
  }

  public void append(T data) {
    LinkedListNode<T> node = new LinkedListNode<>(data);
    if (this.head == null) {
      this.setHead(node);
      return;
    }

    this.getTail().setNext(node);
  }

  public int getLength() {
    int length = 0;
    LinkedListNode<T> currentNode = this.head;

    while(currentNode != null) {
      length++;
      currentNode = currentNode.getNext();
    }

    return length;
  }

  public void forEach(Function<LinkedListNode<T>, ?> iteratorFn) {
    LinkedListNode<T> node = head;
    do {
      iteratorFn.apply(node);
      node = node.getNext();
    } while (node.getNext() != null);
    iteratorFn.apply(node);
  }

  public void sortWith(SortStrategy sortStrategy) {
    this.head = sortStrategy.sort(this).getHead();
  }

  public String toString() {
    return toString(" ");
  }

  public String toString(String separator) {
    StringBuilder stringBuilder = new StringBuilder();

    this.forEach(node -> {
      stringBuilder.append(node.getData());
      if (node.getNext() != null) {
        stringBuilder.append(separator);
      }
      return node;
    });

    return stringBuilder.toString();
  }

  private LinkedListNode<T> getTailForNode(LinkedListNode<T> node) {
    if (node.getNext() == null) {
      return node;
    }

    return getTailForNode(node.getNext());
  }
}
