package com.softinite.algorithms.security;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by sivasenco on 2016-01-01.
 *
 * Source: https://www.hackerrank.com/challenges/security-inverse-of-a-function
 *
 * Problem Statement

 Consider a bijective function f:X→Y and define another function g:Y→X such that for x∈X and y∈Y if f(x)=y then g(y)=x.
 Then, the function g is said to be the inverse function of f and is denoted as g=f−1.

 In this task, you'll be given an integer n and a bijective function f:X→X where X={1,2,3,...,n}.
 You'll have to output the inverse of f.

 Constraints:

 1≤n≤20
 Input Format

 There are 2 lines in the input. The first line contains a single positive integer n. The second line contains n space
 separated integers, the values of f(1), f(2), f(3), ..., f(n)  respectively.

 Output Format

 Output n lines. The ith line should contain the value of f−1(i).

 Sample Input

 3
 1 2 3
 Sample Output

 1
 2
 3
 Explanation

 This is basically the function f(x)=x. Hence it's the inverse of itself.

 Note: Function is not always f(x)=x.
 *
 *
 */
public class FunctionInverse {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Integer n = Integer.valueOf(console.nextLine());

        Map<Integer, Integer> gx = new HashMap<>();

        IntStream.rangeClosed(1 ,n).forEach(i -> gx.put(console.nextInt(), i));

        IntStream.rangeClosed(1 ,n).forEach(i -> System.out.println(gx.get(i)));
    }

}
