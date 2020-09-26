package org.pjesus.training.algorithms;

import org.junit.Assert;
import org.junit.Test;
import org.pjesus.training.structures.LinkedList;

public class BubblesortTest {
  @Test
  public void sortsALinkedList() {
    LinkedList<Integer> list = new LinkedList<>();
    Bubblesort sorter = new Bubblesort();
    list.append(4);
    list.append(5);
    list.append(1);
    list.append(3);
    list.append(2);

    LinkedList<Integer> sortedList = sorter.sort(list);

    Assert.assertEquals("1 2 3 4 5", sortedList.toString());
    Assert.assertEquals(3 * 5, sorter.getExecutionSteps());
  }

  @Test
  public void worstCaseScenario() {
    LinkedList<Integer> list = new LinkedList<>();
    Bubblesort sorter = new Bubblesort();
    list.append(5);
    list.append(4);
    list.append(3);
    list.append(2);
    list.append(1);

    LinkedList<Integer> sortedList = sorter.sort(list);

    Assert.assertEquals("1 2 3 4 5", sortedList.toString());
    Assert.assertEquals(4 * 5, sorter.getExecutionSteps());
  }
}
