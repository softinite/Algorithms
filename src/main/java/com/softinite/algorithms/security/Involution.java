package com.softinite.algorithms.security;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by sivasenco on 2016-01-01.

 Problem Statement

 Consider a function f:X→X where X is any set and f is a bijection. Now, if f=f−1 then f is called an involution.
 Or, to put it in simple terms, a function f is called involution if f(f(x))=x
 In this task you'll be given a permutation f:{1,2,3,...,n}→{1,2,3,...,n} and you have to output if f is an involution or not.

 Constraints

 1≤n≤20
 Input Format

 There are 2 lines in the input. The first line contains a single positive integer n. The second line contains n space separated
 integers, the values of f(1), f(2), f(3), ..., f(n)  respectively.

 Output Format

 Output "YES" if f is an involution, "NO" otherwise.

 Sample Input

 2
 2 1
 Sample Output

 YES
 Explanation

 Since, f(1)=2 and f(2)=1, f−1(1)=2 and f−1(2)=1. Hence f is indeed an involution.

 */
public class Involution {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Integer n = Integer.valueOf(console.nextLine());

        Map<Integer, Integer> fx = new HashMap<>();

        IntStream.rangeClosed(1 ,n).forEach(i -> fx.put(i, console.nextInt()));

        for(Map.Entry<Integer, Integer> entry : fx.entrySet()) {
            if (entry.getKey() != fx.get(entry.getValue())) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

}
