package com.softinite.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by sivasenco on 2015-12-29.

 Martha is interviewing at Subway. One of the rounds of the interview requires her to cut a bread of size l×b into
 smaller identical pieces such that each piece is a square having maximum possible side length with no left over piece of bread.

 Input format
 The first line contains an integer T. T lines follow. Each line contains two space separated integers l and b which
 denote length and breadth of the bread.

 Output format

 T lines, each containing an integer that denotes the number of squares of maximum size, when the bread is cut as per the given condition.

 Constraints

 1 <= T <= 1000
 1 <= l, b <= 1000
 Sample Input

 2
 2 2
 6 9
 Sample Output

 1
 6
 Explanation

 The 1st testcase has a bread whose original dimensions are 2×2, the bread is uncut and is a square. Hence the answer is 1.
 The 2nd testcase has a bread of size 6×9. We can cut it into 54 squares of size 1×1, 0 of size 2×2, 6 of size 3×3, 0 of size 4×4,
 0 of size 5×5 and 0 of size 6×6. The number of squares of maximum size that can be cut is 6.

 */
public class Restaurant {

    static class TestCase {
        Integer l,b;

        TestCase(Scanner console) {
            l = console.nextInt();
            b = console.nextInt();
        }

        @Override
        public String toString() {
            Integer g = gcd(l, b);
            return String.valueOf(l/g * b/g);
        }

        private Integer gcd(Integer x, Integer y) {
            if (x.equals(y)) {
                return x;
            }
            Integer a = x;
            Integer b = y;
            if (a < b) {
                a = y;
                b = x;
            }
            Integer modulo = a % b;
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

        cases.stream().forEach(System.out::println);
    }

}
/**
 * PROOF:
 * Because each piece needs to be a square, the side needs to divide both l & b.
 * Thus, Greatest Common Divisor must be the side of the new squares.
 * The number of squares can be obtained by dividing the area of the bread (assuming flat bread) by the
 * the area of a square => l*b/g/g.
 */
