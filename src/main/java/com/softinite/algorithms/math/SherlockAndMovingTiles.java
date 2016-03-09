package com.softinite.algorithms.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Source: https://www.hackerrank.com/challenges/sherlock-and-moving-tiles
 * Sherlock is given 2 square tiles, initially both of whose sides have length L placed in an x−y plane;
 * so that the left bottom of each square coincides with the the origin and their sides are parallel to the axes.

 At t=0, both squares start moving along line y=x (along the positive x and y) with velocities S1 and S2.

 For each query of form qi, Sherlock has to report the time at which the overlapping area of tiles is equal to qi.

 img

 Note: Assume all values are in standard units.

 Input Format
 First line contains integers L,S1,S2. Next line contains Q, the number of queries. Each of the next Q lines consists of one integer qi in one line.

 Constraints
 1≤L,S1,S2≤109
 1≤Q≤105
 1≤qi≤L2
 S1≠S2

 Output Format
 For each query, print the required answer in one line. Your answer will be considered correct if it is at most 0.0001 away from the true answer. See the explanation for more details.

 Sample Input

 10 1 2
 2
 50
 100

 Sample Output

 4.1421
 0.0000
 Explanation

 For the first case, note that the answer is around 4.1421356237..., so any of the following will be accepted:

 4.1421356237
 4.14214
 4.14215000
 4.1421
 4.1422

 *
 * Created by sivasenco on 2015-12-29.
 */
public class SherlockAndMovingTiles {

    public static final double SQRT_2 = Math.sqrt(2);

    private static void findAndPrintT(Long qi, Integer L, Integer S1, Integer S2) {
        double sqrtQ = Math.sqrt(qi);
        System.out.println(SQRT_2 * (L - sqrtQ)/Math.abs((S2 - S1)));
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Integer L = console.nextInt();
        Integer S1 = console.nextInt();
        Integer S2 = console.nextInt();
        Integer Q = console.nextInt();

        List<Long> qs = new ArrayList<>();

        IntStream.range(0, Q).forEach(i -> qs.add(console.nextLong()));

        qs.stream().forEach(qi -> findAndPrintT(qi, L, S1, S2));

    }

}

/**
 * PROOF:
 *
 * The tiles are moving relative to each other with diagonal speed DeltaS = |S2 - S1|
 * Be qx the side of the square for given qi, qx = sqrt(qi)
 * (L - qx) will be the distance on axis X necessary to create the square qi
 * S = d/t => t = d/S
 * sqrt2 * (L - qx) will be the distance adjusted to the diagonal
 * => t = sqrt2 * (L - sqrt(qi)) / |S2 - S1|
 */
