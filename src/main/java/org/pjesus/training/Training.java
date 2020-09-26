package org.pjesus.training;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Training {
  public static void main(String[] args) {

  }

  public static <T extends Comparable<T>> List<T> sort(List<T> list) {
    return applySort(list, 0, list.size() - 1);
  }

  private static <T extends Comparable<T>> List<T> applySort(List<T> list, int low, int high) {
    if (low < high) {
      Pair<List<T>, Integer> partitionResult = applyPartition(list, low, high);
      applySort(partitionResult.getValue0(), low, partitionResult.getValue1() - 1);
      applySort(partitionResult.getValue0(), partitionResult.getValue1() + 1, high);
    }

    return list;
  }

  private static <T extends Comparable<T>> Pair<List<T>, Integer> applyPartition(List<T> list, int low, int high) {
    T pivot = list.get(high);
    List<T> lowList = new ArrayList<>();
    List<T> highList = new ArrayList<>();

    for (int i = low; i <= high; i ++) {
      T item = list.get(i);

      if (item.compareTo(pivot) < 0) {
        lowList.add(item);
      } else {
        highList.add(item);
      }
    }

    list = Stream
        .concat(Stream.concat(lowList.stream(), Arrays.asList(pivot).stream()), highList.stream())
        .collect(Collectors.toList());

    return new Pair<List<T>, Integer>(newList, newList.indexOf(pivot));
  }
}
