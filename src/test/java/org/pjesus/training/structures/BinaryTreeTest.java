package org.pjesus.training.structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.pjesus.training.exercises.InOrderVisitStrategy;
import org.pjesus.training.exercises.LevelVisitStrategy;
import org.pjesus.training.exercises.PostOrderVisitStrategy;
import org.pjesus.training.exercises.PreOrderVisitStrategy;

import java.util.function.Function;

public class BinaryTreeTest {
  private BinaryTree<String> tree;

  @Before
  public void setup() {
    tree = new BinaryTree<>();
    tree.getRoot().setData("A");
    tree.getRoot().setLeftChild("B");
    tree.getRoot().getLeftChild().setLeftChild("D");
    tree.getRoot().getLeftChild().getLeftChild().setRightChild("G");
    tree.getRoot().setRightChild("C");
    tree.getRoot().getRightChild().setLeftChild("E");
    tree.getRoot().getRightChild().getLeftChild().setLeftChild("H");
    tree.getRoot().getRightChild().getLeftChild().setRightChild("I");
    tree.getRoot().getRightChild().setRightChild("F");
  }

  @Test
  public void treePreOrderTraversal() {
    Function<BinaryTreeNode<String>, ?> visitFn = node -> {
      System.out.println(node.getData());
      return node;
    };

    tree.setVisitStrategy(new PreOrderVisitStrategy()).visit(visitFn);
  }

  @Test
  public void treeInOrderTraversal() {
    Function<BinaryTreeNode<String>, ?> visitFn = node -> {
      System.out.println(node.getData());
      return node;
    };

    tree.setVisitStrategy(new InOrderVisitStrategy()).visit(visitFn);
  }

  @Test
  public void treePostOrderTraversal() {
    final String[] result = {""};
    Function<BinaryTreeNode<String>, ?> visitFn = node -> {
      result[0] += node.getData() + " ";
      return node;
    };

    tree.setVisitStrategy(new PostOrderVisitStrategy()).visit(visitFn);

    Assert.assertEquals("G D B H I E F C A", result[0].trim());
  }

  @Test
  public void treeLevelTraversal() {
    final String[] result = {""};
    Function<BinaryTreeNode<String>, ?> visitFn = node -> {
      result[0] += node.getData() + " ";
      return node;
    };

    tree.setVisitStrategy(new LevelVisitStrategy()).visit(visitFn);

    Assert.assertEquals("A B C D E F G H I", result[0].trim());
  }

  @Test
  public void treeHeightShouldBe3() {
    Assert.assertEquals(tree.getHeight(),3);
  }
}
