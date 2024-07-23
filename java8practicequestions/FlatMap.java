package java8practicequestions;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<List<String>> listOfLists = Arrays.asList(
				Arrays.asList("one", "two"),
				Arrays.asList("three", "four"),
				Arrays.asList("five", "six"));


		List<String> flattenedList = listOfLists.stream()
				.flatMap(i -> i.stream())
				.collect(Collectors.toList());

		System.out.println("-------------------------------------------------------");
		System.out.println();

		Stream.iterate(0, i -> i + 2).limit(50).forEach(i -> System.out.print(i + " "));

		System.out.println();
		String s = "I am the new Boss. so I am here the I";

		Entry<String, Long> h1 = Arrays.stream(s.split(" "))
				.collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting()))
				.entrySet()
				.stream()
				.max((i, i1) -> i.getValue().compareTo(i1.getValue()))
				.get();

		System.out.println("h " + h1);

		Map<String, Long> h = Arrays.stream(s.split(" "))
				.collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(i -> i.getValue() > 1)
				.collect(Collectors.toMap(i -> i.getKey(), i -> i.getValue()));

		h.entrySet().stream().forEach(i -> System.out.println("key  " + i.getKey() + ",  value  " + i.getValue()));

	}

}
