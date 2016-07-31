package com.softinite.algorithms.array;

/**
 * Created by Sergiu Ivasenco on 31/07/16.
 */
public class TapeEquilibrium {

    public int solution(int[] A) {
        if (A.length == 2) {
            return Math.abs(A[0] - A[1]);
        }
        int left = A[0];
        int right = sum(A, 1);
        int minEq = Math.abs(left - right);
        for(int i = 1; i < A.length - 1; i++) {
            left += A[i];
            right -= A[i];
            int tmpSum = Math.abs(left - right);
            if (tmpSum < minEq) {
                minEq = tmpSum;
            }
        }
        return minEq;
    }

    private int sum(int[] A, int idx) {
        int sum = 0;
        for(int i = idx; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }

}
