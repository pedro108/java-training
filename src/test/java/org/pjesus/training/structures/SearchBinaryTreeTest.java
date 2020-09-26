package org.pjesus.training.structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.pjesus.training.exercises.PreOrderVisitStrategy;

import java.util.function.Function;

public class SearchBinaryTreeTest {
  private SearchBinaryTree<String> tree;

  @Before
  public void setup() {
    tree = new SearchBinaryTree<>();
    tree.insert("A");
    tree.insert("B");
    tree.insert("D");
    tree.insert("G");
    tree.insert("C");
    tree.insert("E");
    tree.insert("H");
    tree.insert("I");
    tree.insert("F");
  }

  @Test
  public void treePreOrderTraversal() {
    final String[] result = {""};
    Function<BinaryTreeNode<String>, ?> visitFn = node -> {
      result[0] += node.getData() + " ";
      return node;
    };

    tree.setVisitStrategy(new PreOrderVisitStrategy()).visit(visitFn);

    Assert.assertEquals("A B D C G E F H I", result[0].trim());
  }

  @Test
  public void treeHeightShouldBe5() {
    Assert.assertEquals(tree.getHeight(),5);
  }
}
