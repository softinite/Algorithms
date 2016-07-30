package com.softinite.algorithms.array.equilibrium;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sergiu Ivasenco on 30/07/16.
 */
public class SolutionTest {

    @Test
    public void testSample() {
        int A[] = new int[8];
        A[0] = -1;
        A[1] =  3;
        A[2] = -4;
        A[3] =  5;
        A[4] =  1;
        A[5] = -6;
        A[6] =  2;
        A[7] =  1;
        Assert.assertEquals(new Solution().solution(A), 1);
    }

    @Test
    public void testEmpty() {
        int A[] = new int[0];
        Assert.assertEquals(new Solution().solution(A), -1);
    }

    @Test
    public void testLast() {
        int A[] = new int[4];
        A[0] = -1;
        A[1] = -1;
        A[2] = 2;
        A[3] =  -5;
        Assert.assertEquals(new Solution().solution(A), 3);
    }

    @Test
    public void testLarge() {
        int A[] = new int[5];
        A[0] = Integer.MAX_VALUE;
        A[1] = 1;
        A[2] = 1;
        A[3] = Integer.MIN_VALUE;
        Assert.assertEquals(new Solution().solution(A), -1);
    }

}
