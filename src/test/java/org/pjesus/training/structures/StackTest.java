package org.pjesus.training.structures;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {
  @Test
  public void emptyStackShouldPopNull() {
    Stack<String> stack = new Stack<>();

    Assert.assertNull(stack.pop());
  }

  @Test
  public void stackShouldPopLastPushedItem() {
    Stack<String> stack = new Stack<>();

    stack.push("1");
    stack.push("2");

    Assert.assertEquals(stack.pop(), "2");
  }

  @Test
  public void stackShouldRemoveItemAfterPop() {
    Stack<String> stack = new Stack<>();

    stack.push("1");
    stack.push("2");
    stack.pop();

    Assert.assertEquals(stack.getLength(), 1);
  }
}
