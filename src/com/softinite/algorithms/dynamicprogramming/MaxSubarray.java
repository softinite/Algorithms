package com.softinite.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Softinite on 2016-02-20.
 *
 * Source -> https://www.hackerrank.com/challenges/maxsubarray
 *
 * Given an array A={a1,a2,…,aN}A={a1,a2,…,aN} of NN elements, find the maximum possible sum of a

 Contiguous subarray
 Non-contiguous (not necessarily contiguous) subarray.
 Empty subarrays/subsequences should not be considered.

 Input Format

 First line of the input has an integer TT. TT cases follow.
 Each test case begins with an integer NN. In the next line, NN integers follow representing the elements of array AA.

 Constraints:

 1≤T≤101≤T≤10
 1≤N≤1051≤N≤105
 −104≤ai≤104−104≤ai≤104
 The subarray and subsequences you consider should have at least one element.

 Output Format

 Two, space separated, integers denoting the maximum contiguous and non-contiguous subarray. At least one integer should be selected and put into the subarrays (this may be required in cases where all elements are negative).

 Sample Input

 2
 4
 1 2 3 4
 6
 2 -1 2 3 4 -5
 Sample Output

 10 10
 10 11
 Explanation

 In the first case:
 The max sum for both contiguous and non-contiguous elements is the sum of ALL the elements (as they are all positive).

 In the second case:
 [2 -1 2 3 4] --> This forms the contiguous sub-array with the maximum sum.
 For the max sum of a not-necessarily-contiguous group of elements, simply add all the positive elements.
 *
 */
public class MaxSubarray {

    static class TestCase {

        Integer n;
        List<Integer> list = new ArrayList<>();

        TestCase(Scanner console) {
            n = console.nextInt();
            IntStream.range(0, n).forEach(i -> list.add(console.nextInt()));
        }

        public void solve() {
            int max_ending_here = 0;
            int max_so_far = Integer.MIN_VALUE;

            for(int x : list){
                max_ending_here = Math.max(x, max_ending_here + x);
                max_so_far = Math.max(max_so_far, max_ending_here);
            }

            System.out.print(max_so_far);

            //2) For max non-continuous sub array, order doesn't matter
            Collections.sort(list);
            int sum = 0;

            //if there is none positive value in entire array
            if(list.get(list.size() - 1) <= 0)
                sum = list.get(list.size() - 1);
                //accumulate all positive values in entire array
            else{
                sum = list.stream().reduce(0, (s, e) -> s + Math.max(0, e));
            }
            System.out.println(" " + sum);
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int t = console.nextInt();

        List<TestCase> testCases = new ArrayList<>();

        IntStream.range(0, t).forEach(i -> testCases.add(new TestCase(console)));

        testCases.stream().forEach(TestCase::solve);
    }

}
