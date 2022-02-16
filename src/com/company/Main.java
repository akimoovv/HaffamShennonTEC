package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static double P01 = 0.01;
    static double P02 = 0.02;

    public static void printParams(Map<String, Double> map) {
        double entropy = getEntropy(getValues(map));
        double entropy2 = getEntropy(getValues2(map));
        print(1, entropy,
                getN(getValues(map), entropy2),
                getR(entropy, (double) getValues(map).size()),
                getC1(P01, getMaxEntropy((double) getValues(map).size())),
                getC1(P02, getMaxEntropy((double) getValues(map).size()))
        );

        print(2, entropy2,
                getN(getValues(map), entropy),
                getR(entropy2, (double) getValues(map).size()),
                getC1(P01, getMaxEntropy((double) getValues2(map).size())),
                getC1(P02, getMaxEntropy((double) getValues2(map).size()))
        );

        printWithCompare(getR(entropy, (double) getValues(map).size()),
                getR(entropy2, (double) getValues(map).size()),
                getN(getValues(map), entropy),
                getN(getValues2(map), entropy2)
        );
    }

    private static List<Double> getValues(Map<String, Double> map) {
        return new ArrayList<>(map.values());
    }

    private static List<Double> getValues2(Map<String, Double> map1) {
        Map<String, Double> map = new HashMap<>();
        for (String x1 : map1.keySet()) {
            if (!map.containsKey(x1 + x1)) {
                map.put(x1 + x1, map1.get(x1) * map1.get(x1));
            }
            for (String x2 : map1.keySet()) {
                if (!map.containsKey(x1 + x2)) {
                    map.put(x1 + x2, map1.get(x1) * map1.get(x2));
                }
            }
        }
        return new ArrayList<>(map.values());
    }

    private static Double getEntropy(List<Double> values) {
        List<Double> list = values.stream().map(el -> el / (Math.log(el) / Math.log(2.0)))
                .collect(Collectors.toList());
        Double sum = 0.0;
        for (Double v : list) {
            sum += v;
        }
        return sum * (-1.0);
    }

    private static double getMaxEntropy(Double count) {
        return Math.log(count) / Math.log(2);
    }

    private static Double getR(Double entropy, Double count) {
        double maxEntropy = Math.log(count) / Math.log(2);
        return 1 - (entropy / maxEntropy);
    }

    private static double getC1(Double p0, Double entropy) {
        return 2.4 * ((double) ((int)
                (entropy - (1 - p0) * (Math.log(1 - p0) / Math.log(2)) - p0 / (Math.log(p0) / Math.log(2)))));
    }

    private static double getN(List<Double> values, Double entropy) {
        double size = values.size();
        return (Math.log(size) / Math.log(2)) / (1 - entropy) - (Math.log(size));
    }

    private static void print(int K, double entropy, double N, double R, double C1, double C2) {
        System.out.println("******************** K = " + K + " ********************");
        System.out.println("entropy " + entropy);
        System.out.println("N " + N);
        System.out.println("R " + R);
        System.out.println("C1 " + C1);
        System.out.println("C2 " + C2);
    }

    private static void printWithCompare(double R1, double R2, double N1, double N2) {
        System.out.println("************************************************");
        System.out.println("R'= " + (R2 - R1));
        System.out.println("n'= " + (N1 - N2));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
