package com.example.map_vs_flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMap {
    public static void example() {
        List<Integer> list = Arrays.asList(1, 2, 3);

        // map
        List<List<Integer>> convertedByMap = list
                .stream()
                .map(it -> Arrays.asList(it, it))
                .collect(Collectors.toList());
        System.out.println(convertedByMap);
        // [[1, 1], [2, 2], [3, 3]]

        // flatMap
        List<Integer> convertedByFlatMap = list
                .stream()
                .flatMap(it -> Stream.of(it, it))
                .collect(Collectors.toList());
        System.out.println(convertedByFlatMap);
        // [1, 1, 2, 2, 3, 3]
    }
}
