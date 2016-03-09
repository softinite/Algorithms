package com.softinite.algorithms.security;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by sivasenco on 2016-01-01.
 *
 * Source: https://www.hackerrank.com/challenges/security-tutorial-permutations
 *
 * Problem Statement

 Consider a function f:X→X where X is any set. If f is a bijection then f is a permutation function of X. There is nothing special about the set X hence it can be replaced by the set {1,2,3,...,n} where n=|X|.

 Consider a permutation f given by (2,3,1) this means that f(1)=2, f(2)=3 and f(3)=1.

 In this task you'll be given a permutation f:{1,2,3,...,n}→{1,2,3,...,n} and you have to output f(f(x)) for all x∈{1,2,3,...,n}.

 Constraints:

 1≤n≤20
 Input Format

 There are 2 lines in the input. The first line contains a single positive integer n. The second line contains n space separated integers, the values of f(1), f(2), f(3), ..., f(n)  respectively.

 Output Format

 Output the values of f(f(1)), f(f(2)), f(f(3)), ..., f(f(n))  respectively, each in a new line.

 Sample Input

 3
 2 3 1
 Sample Output

 3
 1
 2
 Explanation

 f(f(1))=f(2)=3 and so on.
 *
 *
 */
public class Permutations {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Integer n = Integer.valueOf(console.nextLine());

        Map<Integer, Integer> fx = new HashMap<>();

        IntStream.rangeClosed(1 ,n).forEach(i -> fx.put(i, console.nextInt()));

        IntStream.rangeClosed(1 ,n).forEach(i -> System.out.println(fx.get(fx.get(i))));
    }

}
