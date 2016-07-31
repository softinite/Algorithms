package com.softinite.algorithms.array;

/**
 * Created by Sergiu Ivasenco on 31/07/16.
 */
public class FindMissingElement {

    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        long n = A.length + 1;
        long maxSum = (n * (n + 1))/2;
        long actualSum = 0;
        for(int i = 0; i < A.length; i++) {
            actualSum += A[i];
        }
        Long l = maxSum - actualSum;
        return l.intValue();
    }

}
