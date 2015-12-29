package com.softinite.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by sivasenco on 2015-12-29.
 *
 * Source: https://www.hackerrank.com/challenges/possible-path
 *
 * Adam is standing at point (a,b) in an infinite 2D grid. He wants to know if he can reach point (x,y) or not. The only operation he can do is to move to point (a+b,b), (a,a+b), (a-b,b), or (a,a-b) from some point (a,b). It is given that he can move to any point on this 2D grid,i.e., the points having positive or negative X(or Y) co-ordinates.

 Tell Adam whether he can reach (x,y) or not.

 Input Format
 The first line contains an integer, T, followed by T lines, each containing 4 space separated integers i.e. a b x y

 Output Format
 For each test case, display YES or NO that indicates if Adam can reach (x,y) or not.

 Constraints
 1 ≤ T ≤ 1000
 1 ≤ a,b,x,y ≤ 1018

 Sample Input

 3
 1 1 2 3
 2 1 2 3
 3 3 1 1
 Sample Output

 YES
 YES
 NO
 Explanation

 (1,1) -> (2,1) -> (2,3).

 *
 */
public class PossiblePath {

    static class TestCase {
        Long a, b, x, y;

        TestCase(Scanner console) {
            a = console.nextLong();
            b = console.nextLong();
            x = console.nextLong();
            y = console.nextLong();
        }

        public boolean isPossiblePath() {
            Long gcdAB = gcd(a, b);
            Long gcdXY = gcd(x, y);
            return gcdAB.equals(gcdXY);
        }

        private Long gcd(Long x, Long y) {
            if (x.equals(y)) {
                return x;
            }
            Long a = x;
            Long b = y;
            if (a < b) {
                a = y;
                b = x;
            }
            Long modulo = a % b;
            if (modulo == 0) {
                return b;
            }
            return gcd(b, modulo);
        }

    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Integer t = console.nextInt();

        List<TestCase> cases = new ArrayList<>();

        IntStream.range(0 , t).forEach(i -> cases.add(new TestCase(console)));

        cases.stream().forEach(PossiblePath::solveAndPrint);

    }

    private static void solveAndPrint(TestCase tc) {
        if (tc.isPossiblePath()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
/**
 * PROOF:
 * In order for the path to be possible, the following equations need to be satisfied
 * x = w1 * a + w2 * b
 * y = u1 * a + u2 * b
 *
 * where w1, w2, u1, u2 are natural numbers. In other words, if we can find any combination of w1, w2, u1 and u2
 * satisfying the equation, then the path is possible.
 * Let's introduce g - greatest common divisor between a & b, such that a = m * g & b = n * g
 * The equations become
 * x= w1 * m * g + w2 * n * g = g * (w1 * m + w2 * n)
 * y = u1 * m * g + u2 * n * g = g * (u1 * m + u2 * n)
 *
 * Let gcd be the function calculating the Greatest Common Divisor
 * It's easy to note that gcd(x, y) = gcd(a, b).
 * Conclusion: if x & y have been derived from a, b using the rules of the problem statement, then their greatest common
 * divisor must coincide.
 */
