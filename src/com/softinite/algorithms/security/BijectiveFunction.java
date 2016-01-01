package com.softinite.algorithms.security;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by sivasenco on 2016-01-01.
 *
 * Source: https://www.hackerrank.com/challenges/security-bijective-functions
 *
 * Problem Statement

 Now that we know about one-to-one functions, let's talk about onto functions and bijective functions.

 A function f:X→Y is onto iff each element in the codomain Y is the image of at least one element in the domain X. That is,

 Im(f)=Y
 If the function f is both one-to-one and onto then f is a bijection from X to Y or, equivalently, f:X→Y is a bijective function.

 In this task, you'll be given an integer n and a function f:X→X where X={1,2,3,...,n} and you have to tell if it is a bijective function or not.

 Constraints

 1≤n≤20
 Input Format

 There are 2 lines in the input. The first line contains a single positive integer n. The second line contains n space separated integers, the values of f(1), f(2), f(3), ..., f(n)  respectively.

 Output Format

 Output, in a single line, "YES" if f is bijective, "NO" otherwise.

 Sample Input

 3
 1 2 3
 Sample Output

 YES
 Explanation

 This is basically the function f(x)=x.
 *
 */
public class BijectiveFunction {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Integer n = Integer.valueOf(console.nextLine());

        List<Integer> fx = new ArrayList<>();

        IntStream.range(0 ,n).forEach(i -> fx.add(console.nextInt()));

        System.out.println(isBijective(fx) ? "YES" : "NO");
    }

    private static boolean isBijective(List<Integer> fx) {
        Set<Integer> uniqueFx = new HashSet<>(fx);
        return uniqueFx.size() == fx.size();
    }

}
