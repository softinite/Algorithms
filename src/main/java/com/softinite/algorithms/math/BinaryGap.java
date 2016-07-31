package com.softinite.algorithms.math;

/**
 * Created by Sergiu Ivasenco on 30/07/16.
 */
public class BinaryGap {

    public int solution(int N) {
        if (N <= 2) {
            return 0;
        }
        int maxGap = 0;
        int tmpGap = 0;
        boolean counting = false;
        while(N > 0) {
            int bit = N % 2;
            if (bit == 1) {
                if (counting) {
                    if (tmpGap > maxGap) {
                        maxGap = tmpGap;
                    }
                }
                tmpGap = 0;
                counting = true;
            } else {
                if (counting) {
                    tmpGap++;
                }
            }
            N = N / 2;
        }
        return maxGap;
    }

}
