package com.softinite.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Softinite on 2015-12-29.
 *
 * Akash and Akhil are playing a game. They have N balls numbered from 0 to N−1. Akhil asks Akash to reverse the position of the balls, i.e.,
 * to change the order from say, 0,1,2,3 to 3,2,1,0. He further asks Akash to reverse the position of the balls N times, each time starting from
 * one position further to the right, till he reaches the last ball. So, Akash has to reverse the positions of the ball starting from 0th position,
 * then from 1st position, then from 2nd position and so on. At the end of the game, Akhil will ask Akash the final position of any ball numbered K.
 * Akash will win the game, if he can answer. Help Akash.

 Input Format
 The first line contains an integer T, i.e., the number of the test cases.
 The next T lines will contain two integers N and K.

 Output Format
 Print the final index in array.

 Constraints
 1≤T≤50
 1≤N≤105
 0≤K<N
 Sample Input

 2
 3 1
 5 2
 Sample Output

 2
 4
 Explanation
 For first test case, The rotation will be like this:
 0 1 2 -> 2 1 0 -> 2 0 1 -> 2 0 1
 So, Index of 1 will be 2.
 *
 */
public class ReverseGame {

    static class TestCase {

        Integer n,k;

        TestCase(Scanner console) {
            n = console.nextInt();
            k = console.nextInt();
        }

        @Override
        public String toString() {
            Integer idx = 2 * k + 1;
            if (idx < n) {
                return String.valueOf(idx);
            }
            return String.valueOf(2 * (n - k - 1));
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

/**
 * FORMULA:
 * The final order is predictable, thus it is possible to create a formula.
 * Through different trials, it has been noted that index = 2 * k + 1, when the result is less than n and 2 * (n - k - 1) otherwise
 */
