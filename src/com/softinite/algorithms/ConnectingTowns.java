package com.softinite.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by sivasenco on 2015-12-29.
 *
 * Source: https://www.hackerrank.com/challenges/connecting-towns
 *
 * Gandalf is travelling from Rohan to Rivendell to meet Frodo but there is no direct route from Rohan (T1) to Rivendell (Tn).

 But there are towns T2,T3,T4...Tn-1 such that there are N1 routes from Town T1 to T2, and in general, Ni routes from
 Ti to Ti+1 for i=1 to n-1 and 0 routes for any other Ti to Tj for j ≠ i+1

 Find the total number of routes Gandalf can take to reach Rivendell from Rohan.

 Note
 Gandalf has to pass all the towns Ti for i=1 to n-1 in numerical order to reach Tn.
 For each Ti , Ti+1 there are only Ni distinct routes Gandalf can take.

 Input Format
 The first line contains an integer T, T test-cases follow.
 Each test-case has 2 lines. The first line contains an integer N (the number of towns).
 The second line contains N - 1 space separated integers where the ith integer denotes the number of routes, Ni,
 from the town Ti to Ti+1

 Output Format
 Total number of routes from T1 to Tn modulo 1234567
 http://en.wikipedia.org/wiki/Modular_arithmetic

 Constraints
 1 <= T<=1000
 2< N <=100
 1 <= Ni <=1000

 Sample Input

 2
 3
 1 3
 4
 2 2 2
 Sample Output

 3
 8
 Explanation
 Case 1: 1 route from T1 to T2, 3 routes from T2 to T3, hence only 3 routes.
 Case 2: There are 2 routes from each city to the next, at each city, Gandalf has 2 choices to make, hence 2 * 2 * 2 = 8.
 *
 */
public class ConnectingTowns {

    private static final Integer MOD = 1234567;

    static class TestCase{

        Integer n;
        List<Long> ns;

        TestCase(Scanner console) {
            n = console.nextInt();
            ns = new ArrayList<>();
            IntStream.range(1, n).forEach(i -> ns.add(console.nextLong()));
        }

        @Override
        public String toString() {
            Long nbPaths = ns.parallelStream().reduce(1l, (a,b) -> (a * (b % MOD)) % MOD);
            return String.valueOf(nbPaths % MOD);
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Integer t = console.nextInt();

        List<TestCase> cases = new ArrayList<>();

        IntStream.range(0 , t).forEach(i -> cases.add(new TestCase(console)));

        cases.stream().forEach(System.out::println);
    }

}
