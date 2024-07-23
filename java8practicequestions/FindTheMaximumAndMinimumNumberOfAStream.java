package java8practicequestions;

import java.util.*;
import java.util.stream.Stream;

public class FindTheMaximumAndMinimumNumberOfAStream {

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(5, 4, 2, 10, 3, 8, 6);
        System.out.println(list1);

        // Find the minimum value in the list using streams
        Optional<Integer> minInteger1 = list1.stream()
                .min(Integer::compareTo);
        minInteger1.ifPresent(min -> System.out.println("Min Integer is : " + min));

        Optional<Integer> maxInteger1 = list1.stream()
                .max(Integer::compareTo);
        maxInteger1.ifPresent(max -> System.out.println("Max Integer is : " + max));

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(3);
        list2.add(9);
        list2.add(5);
        list2.add(6);
        list2.add(1);
        list2.add(2);
        System.out.println(list2);

        Optional<Integer> minInteger2 = list2.stream()
                .min(Comparator.comparing(Integer::valueOf));
        minInteger2.ifPresent(System.out::println);

        Optional<Integer> maxInteger2 = list2.stream()
                .max(Comparator.comparing(Integer::valueOf));
        maxInteger2.ifPresent(System.out::println);

        Optional<Integer> minInteger3 = Stream.of(3, 5, 11, 4, 8, 6, 7)
                .min(Comparator.comparing(Integer::valueOf));
        minInteger3.ifPresent(System.out::println);

        Optional<Integer> maxInteger3 = Stream.of(2, 3, 5, 12, 4, 1, 6, 7)
                .max(Comparator.comparing(Integer::valueOf));
        maxInteger3.ifPresent(System.out::println);
    }
}
