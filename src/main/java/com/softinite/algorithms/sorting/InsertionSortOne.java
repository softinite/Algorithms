package com.softinite.algorithms.sorting;

import java.util.Scanner;

/**
 * Created by Softinite on 2016-02-20.
 *
 * Source -> https://www.hackerrank.com/challenges/insertionsort1
 *
 * Sorting
 One common task for computers is to sort data. For example, people might want to see all their files on a computer sorted by size. Since sorting is a simple problem with many different possible solutions, it is often used to introduce the study of algorithms.

 Insertion Sort
 These challenges will cover Insertion Sort, a simple and intuitive sorting algorithm. We will first start with an already sorted list.

 Insert element into sorted list
 Given a sorted list with an unsorted number ee in the rightmost cell, can you write some simple code to insert ee into the array so that it remains sorted?

 Print the array every time a value is shifted in the array until the array is fully sorted. The goal of this challenge is to follow the correct order of insertion sort.

 Guideline: You can copy the value of ee to a variable and consider its cell "empty". Since this leaves an extra cell empty on the right, you can shift everything over until VV can be inserted. This will create a duplicate of each value, but when you reach the right spot, you can replace it with ee.

 Input Format
 There will be two lines of input:

 SizeSize - the size of the array
 ArrArr - the unsorted array of integers
 Output Format
 On each line, output the entire array every time an item is shifted in it.

 Constraints
 1≤Size≤10001≤Size≤1000
 −10000≤e≤10000,e∈Arr−10000≤e≤10000,e∈Arr

 Sample Input

 5
 2 4 6 8 3
 Sample Output

 2 4 6 8 8
 2 4 6 6 8
 2 4 4 6 8
 2 3 4 6 8
 Explanation

 33 is removed from the end of the array.
 In the 11st line 8>38>3, so 88 is shifted one cell to the right.
 In the 22nd line 6>36>3, so 66 is shifted one cell to the right.
 In the 33rd line 4>34>3, so 44 is shifted one cell to the right.
 In the 44th line 2<32<3, so 33 is placed at position 22.

 Task

 Complete the method insertionSort which takes in one parameter:

 ArrArr - an array with the value ee in the right-most cell.
 *
 */
public class InsertionSortOne {

    public static void insertIntoSorted(int[] ar) {
        Integer length = ar.length;
        int pos = length - 1;
        final int val = ar[pos];
        while (pos > 0 && ar[pos - 1] > val) {
            ar[pos] = ar[pos - 1];
            printArray(ar);
            pos--;
        }
        ar[pos] = val;
        printArray(ar);
    }

    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

}
