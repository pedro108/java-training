package org.pjesus.training.structures;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {
  @Test
  public void emptyQueueShouldDequeueNull() {
    Queue<String> queue = new Queue<>();

    Assert.assertNull(queue.dequeue());
  }

  @Test
  public void queueShouldDequeueFirstEnqueuedItem() {
    Queue<String> queue = new Queue<>();

    queue.enqueue("1");
    queue.enqueue("2");

    Assert.assertEquals(queue.dequeue(), "1");
  }

  @Test
  public void queueShouldRemoveItemAfterDequeue() {
    Queue<String> queue = new Queue<>();

    queue.enqueue("1");
    queue.enqueue("2");
    queue.dequeue();

    Assert.assertEquals(queue.getLength(), 1);
  }
}
