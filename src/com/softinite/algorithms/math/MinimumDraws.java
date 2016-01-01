package com.softinite.algorithms.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * Jim is off to a party and is searching for a matching pair of socks. His drawer is filled with socks,
 * each pair of a different color. In its worst case scenario, how many socks (x) should Jim remove from his
 * drawer until he finds a matching pair?

 Input Format
 The first line contains the number of test cases T.
 Next T lines contains an integer N which indicates the total pairs of socks present in the drawer.

 Output Format
 Print the number of Draws (x) Jim makes in the worst case scenario.

 Constraints
 1≤T≤1000
 0<N<106
 */
public class MinimumDraws {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        Integer t = Integer.valueOf(console.nextLine());

        List<Integer> ns = new ArrayList<>();

        IntStream.range(0, t).forEach(i -> ns.add(Integer.valueOf(console.nextLine()) + 1));

        ns.stream().forEach(System.out::println);

    }
}

/**
 * PROOF:
 * The Peigeonhole principle can be used here.
 * In this case, it can be noticed that m = N and we're trying to find the smallest n, which would match n = m * k + 1
 * It can be noticed that the smallest n, will be determined by the least positive k, which means k = 1 and n = m+ 1.
 *
 * Conclusion: in the worst scenario, Jim will have to pull m (where m = N) uniques socks and the m + 1 will inevitable match
 * one of the existing draw.
 */
