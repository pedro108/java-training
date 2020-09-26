package org.pjesus.training.structures;

import org.junit.Assert;
import org.junit.Test;
import org.pjesus.training.algorithms.Bubblesort;

import java.util.function.Function;

public class LinkedListTest {
  @Test
  public void linkedListShouldSetItsHead() {
    LinkedList<String> list = new LinkedList<>();
    LinkedListNode<String> head = new LinkedListNode<>("head value");
    list.setHead(head);

    Assert.assertEquals(list.getHead(), head);
  }

  @Test
  public void forEachMustVisitAllNodes() {
    LinkedList<Integer> list = new LinkedList<>();
    list.append(4);
    list.append(5);
    list.append(1);
    list.append(3);
    list.append(2);
    final int[] nodesVisited = {0};
    Function<LinkedListNode<Integer>, ?> visitFn = node -> {
      nodesVisited[0]++;
      return node;
    };

    list.forEach(visitFn);

    Assert.assertEquals(nodesVisited[0], 5);
  }

  @Test
  public void sortWithAppliesASorterToSortTheList() {
    LinkedList<Integer> list = new LinkedList<>();
    list.append(4);
    list.append(5);
    list.append(1);
    list.append(3);
    list.append(2);

    list.sortWith(new Bubblesort());

    Assert.assertEquals("1 2 3 4 5", list.toString());
  }

  @Test
  public void toStringShouldReturnTheValueSequenceWithReceivedSeparator() {
    LinkedList<Integer> list = new LinkedList<>();
    list.append(4);
    list.append(5);
    list.append(1);
    list.append(3);
    list.append(2);

    Assert.assertEquals(list.toString(","), "4,5,1,3,2");
  }
}
