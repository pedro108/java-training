package org.pjesus.training.structures;

public class Queue<T extends Comparable<T>> {
  private final LinkedList<T> queue = new LinkedList<>();

  public Queue() {}

  public void enqueue(T data) {
    queue.append(data);
  }

  public T dequeue() {
    LinkedListNode<T> head = queue.getHead();
    if (head != null) {
      queue.setHead(head.getNext());
      return head.getData();
    }

    return null;
  }

  public int getLength() {
    return this.queue.getLength();
  }
}
