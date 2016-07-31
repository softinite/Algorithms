package com.softinite.algorithms.array;

import java.util.Arrays;

/**
 * Created by Sergiu Ivasenco on 30/07/16.
 */
public class OddOccurencesInArray {

    public int solution(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        int result = A[0];
        for(int i = 1; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }

}
