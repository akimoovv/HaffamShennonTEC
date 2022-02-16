package com.company;

import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Map<String, Double> map1 = Map.of(
                "x1", 0.25,
                "x2", 0.3,
                "x3", 0.4,
                "x4", 0.05);

        Map<String, Double> map2 = Map.of(
                "x1", 0.4,
                "x2", 0.3,
                "x3", 0.1,
                "x4", 0.05,
                "x5", 0.15
        );

        Map<String, Double> map3 = Map.of(
                "x1", 0.15,
                "x2", 0.1,
                "x3", 0.07,
                "x4", 0.05,
                "x5", 0.03,
                "x7", 0.2,
                "x8", 0.4
        );

        Map<String, Double> map4 = Map.of(
                "x1", 0.2,
                "x2", 0.15,
                "x3", 0.15,
                "x4", 0.4,
                "x5", 0.05,
                "x6", 0.05
        );

        List<Map<String, Double>> map = List.of(map1, map2, map3, map4);

        map.forEach(Main::printParams);
    }
}
