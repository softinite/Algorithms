package com.softinite.algorithms.security;

import java.util.Scanner;

/**
 * Created by sivasenco on 2016-01-01.

 Source: https://www.hackerrank.com/challenges/security-function-ii

 Problem Statement

 We now know the definition of functions.

 If f(x)=y, such that x∈X and y∈Y then y is called an image of x and x is called the preimage of y.

 Given x1,x2∈X and y1,y2∈Y
 f(x1)=y1 and f(x2)=y2
 we call the function f:X→Y as 1-1 (one-to-one) if

 f(x1)=f(x2)⟹x1=x2

 Let us define one such one-to-one function f2:X→X, such that f2(x)=x2
 where X={1,2,3,4,......} The function defined in the previous challenge is not one-to-one as

 f1(0)=f1(11)=0,0≠11

 Your task is to complete the function which takes x as input and return x2

 Constraints
 1≤x≤1000



 */
public class SecurityFunctionII {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Integer x = console.nextInt();

        System.out.println(x * x);

    }

}
