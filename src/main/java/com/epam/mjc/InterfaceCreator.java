package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return l -> {
            for (String s : l) {
                if (!Character.isUpperCase(s.charAt(0))) return false;
            }

            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
//        return l -> {
//            for (int i = 0; i < l.size(); i++) {
//                if (l.get(i) % 2 == 0) l.add(i);
//            }
//        };

        List<Integer> result = new ArrayList<>();
        Consumer<List<Integer>> print;
        print = x -> {
            if (!x.isEmpty()) {

//                Iterator<Integer> iterator = x.iterator();
//                while (iterator.hasNext()) {
//                    result.add(iterator.next());
//                }

                for (int n : x) {
                    result.add(n);
                }

                for (int n : x) {
                    if (n % 2 == 0) result.add(n);
                }
                x.clear();
                x.addAll(result);
            }
        };
        return print;
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)) && s.endsWith("."))
                .filter(s -> s.split("\\s+").length > 3)
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> x.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (l1, l2) -> {
            List<Integer> concatenatedList = new ArrayList<>();
            concatenatedList.addAll(l1); // Add all elements from list1
            concatenatedList.addAll(l2); // Add all elements from list2
            return concatenatedList;
        };
    }
}
