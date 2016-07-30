package com.softinite.algorithms.array.equilibrium;

/**
 * Created by Sergiu Ivasenco on 30/07/16.
 */
class Solution {
    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        long left = 0;
        long right = sum(A, 1);
        if (left == right) {
            return 0;
        }
        for(int i = 1; i < A.length; i++) {
            right -= A[i];
            left += A[i - 1];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }

    private long sum(int[] a, int i) {
        long sum = 0;
        for(int j = i; j < a.length; j++) {
            sum += a[j];
        }
        return sum;
    }
}
