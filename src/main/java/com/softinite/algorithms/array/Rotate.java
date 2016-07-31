package com.softinite.algorithms.array;

/**
 * Created by Sergiu Ivasenco on 30/07/16.
 */
public class Rotate {

    public int[] solution(int[] A, int K) {
        if (A == null || A.length == 0 || K == 0) {
            return A;
        }
        K = K % A.length;
        int []result = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            int aIdx = i - K;
            if (aIdx < 0) {
                aIdx += A.length;
            }
            result[i] = A[aIdx];
        }
        return result;
    }

}
