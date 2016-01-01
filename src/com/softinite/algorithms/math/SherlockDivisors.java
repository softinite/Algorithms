package com.softinite.algorithms.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Softinite on 2015-12-29.
 *
 * Source: https://www.hackerrank.com/challenges/sherlock-and-divisors
 *
 * Watson gives an integer N to Sherlock and asks him: What is the number of divisors of N that are divisible by 2?.

 Input Format
 First line contains T, the number of testcases. This is followed by T lines each containing an integer N.

 Output Format
 For each testcase, print the required answer in one line.

 Constraints
 1≤T≤100
 1≤N≤109

 Sample Input

 2
 9
 8
 Sample Output

 0
 3
 Explanation
 9 has three divisors 1, 3 and 9 none of which is divisible by 2.
 8 has four divisors 1,2,4 and 8, out of which three are divisible by 2.
 *
 */
public class SherlockDivisors {

    private static final Integer MAX_PRIME = 3_000_000;
    private static final Integer MAX_FACTORS = 2000;
    private static final boolean PRIMES[] = new boolean[MAX_PRIME + 2];

    static {
        IntStream.range(2, MAX_PRIME).forEach( i -> PRIMES[i] = true);
        IntStream.range(2, MAX_FACTORS + 1).forEach(i -> {
            if (PRIMES[i]) {
                Integer n = i*i;
                Integer k=0;

                for(int j=n; j < MAX_PRIME; k++, j = n + (i*k))
                    PRIMES[j]=false;
            }
        });
    }

    static class TestCase {

        Integer n;

        TestCase(Scanner console) {
            n = Integer.valueOf(console.nextLine());
        }

        @Override
        public String toString() {
            return String.valueOf(evenDivisors(n));
        }

        private Long evenDivisors(Integer n) {
            if (n % 2 == 1) {
                return 0l;
            }
            Long nbDivisors = 0l;
            while(n > 1 && n % 2 == 0) {
                nbDivisors++;
                n = n / 2;
            }
            int factors[] = new int[MAX_FACTORS];
            IntStream.range(1, MAX_FACTORS).forEach(i -> factors[i] = 1);
            factors[0] = nbDivisors.intValue();
            int j = 1;
            for(int k=3; k < n; k+=2)
            {
                if (k >= MAX_PRIME) {
                    break;
                }
                if(PRIMES[k] && n % k == 0)
                {
                    while( n % k == 0)
                    {
                        factors[j] += 1;
                        n = n/k;
                    }
                    j+=1;
                }
            }
            if (n != 1) {
                factors[j++]++;
            }
            nbDivisors = 1l;
            for(int k = 0; k < j; k++)
                nbDivisors = nbDivisors * factors[k];

            return nbDivisors;
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Integer t = Integer.valueOf(console.nextLine());

        List<TestCase> cases = new ArrayList<>();

        IntStream.range(0 , t).forEach(i -> cases.add(new TestCase(console)));

        cases.stream().forEach(System.out::println);
    }

}
