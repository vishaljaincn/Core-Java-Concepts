package java8practicequestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberSum {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 5, 6, 7, 8, 8, 9, 9, 9, 10);

    // Sum of even numbers
    int sumOfEvens = numbers.stream()
        .filter(num -> num % 2 == 0)
        .mapToInt(Integer::intValue)
        .sum();

    System.out.println("Sum of even numbers: " + sumOfEvens);
    System.out.println("----------------------------------------------------------------");

    // sum of even numbers is=using reduce

    Optional<Integer> sumOfEven = numbers.stream()
        .filter(num -> num % 2 == 0)
        .reduce((i, sum) -> i + sum);

    System.out.println("Sum of even numbers: " + sumOfEven.get());
    System.out.println("----------------------------------------------------------------");

    // Sum of odd numbers
    int sumOfOdds = numbers.stream()
        .filter(num -> num % 2 != 0)
        .mapToInt(Integer::intValue)
        .sum();

    System.out.println("Sum of odd numbers: " + sumOfOdds);
    System.out.println("----------------------------------------------------------------");

    // max number in list
    int max = numbers.stream()
        .max((i1, i2) -> i1.compareTo(i2))
        .get();

    System.out.println("max of  numbers: " + max);
    System.out.println("----------------------------------------------------------------");

    // To remove duplicates from list

    List numWithoutdup = numbersWithDuplicates.stream()
        .distinct().toList();

    for (Object num : numWithoutdup)
      System.out.print(num.toString() + " ");
    System.out.println();

    // with method reference
    numbersWithDuplicates.stream()
        .distinct().forEach(System.out::print);
    ;

    System.out.println("----------------------------------------------------------------------");

    // To find duplicates in list
    Set<Integer> set = new HashSet();

    numbersWithDuplicates.stream()
        .filter(i -> !set.add(i))
        .forEach(System.out::print);

    System.out.println("--------------------------------------------------------------------------");

    String input = "Java Hungry Blog Alive is Awesome";

    Character firstNonRepative = input.chars()
        .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
        .collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting()))
        // .collect(Collectors.toMap(Function.identity(), v -> 1L, (count1, count2) ->
        // count1 + count2, LinkedHashMap::new))
        .entrySet()
        .stream()
        .filter(i -> i.getValue() == 1)
        .map(i -> i.getKey())
        .findFirst()
        .get();

    System.out.println("First non repetative character is " + firstNonRepative);
  }
}
