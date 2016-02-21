package com.softinite.algorithms.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Softinite on 2016-02-20.
 *
 * Source: https://www.hackerrank.com/challenges/pairs
 *
 * Given NN integers, count the number of pairs of integers whose difference is KK.

 Input Format

 The first line contains NN and KK.
 The second line contains NN numbers of the set. All the NN numbers are unique.

 Output Format

 An integer that tells the number of pairs of integers whose difference is KK.

 Constraints:
 N≤10N≤1055
 0<K<100<K<1099
 Each integer will be greater than 00 and at least KK smaller than 223131−1−1.

 Sample Input

 5 2
 1 5 3 4 2
 Sample Output

 3
 Explanation

 There are 3 pairs of integers in the set with a difference of 2.
 */
public class Pairs {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Integer n = console.nextInt();
        Integer k = console.nextInt();
        final List<Integer> list = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> list.add(console.nextInt()));

        Collections.sort(list);

        System.out.println(calculatePairs(list, k));
    }

    private static Integer calculatePairs(List<Integer> list, Integer k) {
        int size = list.size();
        if (size < 2) {
            return 0;
        }
        int p1 = 0;
        int p2 = 1;
        int pairs = 0;
        while (p1 < size - 1 && p2 < size) {
            Integer pivot = list.get(p1);
            Integer var = list.get(p2);
            while (var - pivot < k && p2 < size) {
                p2++;
                if (p2 == size) {
                    return pairs;
                }
                var = list.get(p2);
            }
            if (var - pivot == k) {
                pairs++;
            }
            p1++;
            p2 = p1 + 1;
        }
        return pairs;
    }

}
