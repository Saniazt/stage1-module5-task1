package com.epam.mjc;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase(){
        return str -> str.stream().allMatch(s -> Character.isUpperCase(s.toCharArray()[0]));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> integers.addAll(integers.stream().filter(n -> n % 2 == 0).toList());
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream().filter(s -> Character.isUpperCase(s.toCharArray()[0])).filter(s -> s.endsWith("."))
                .filter(s -> s.split(" ").length > 3)
                .toList();
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> x.stream().collect(Collectors.toMap(String::toString, String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> Stream.concat(list1.stream(), list2.stream()).toList();
    }

}
