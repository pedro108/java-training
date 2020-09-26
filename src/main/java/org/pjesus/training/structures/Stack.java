package org.pjesus.training.structures;

public class Stack<T extends Comparable<T>> {
  private final LinkedList<T> stack = new LinkedList<>();

  public Stack() {}

  public void push(T data) {
    LinkedListNode<T> stackHead = this.stack.getHead();
    LinkedListNode<T> node = new LinkedListNode<>(data);
    node.setNext(stackHead);

    this.stack.setHead(node);
  }

  public T pop() {
    LinkedListNode<T> node = this.stack.getHead();
    if (node != null) {
      this.stack.setHead(node.getNext());
      return node.getData();
    }

    return null;
  }

  public int getLength() {
    return this.stack.getLength();
  }
}
