package com.softinite.algorithms.array.prefixsum;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sergiu Ivasenco on 01/08/16.
 */
public class SliceMinAverageTest {

    @Test
    public void checkSlices() {
        SliceMinAverage sma = new SliceMinAverage();
        Assert.assertEquals(sma.solution(new int[] {4, 2, 2, 5, 1, 5, 8}), 1);
        Assert.assertEquals(sma.solution(new int[] {0, 1}), 0);
        Assert.assertEquals(sma.solution(new int[] {4, 2, 2, -5, 1, 1, -8}), 5);
        Assert.assertEquals(sma.solution(new int[100_000]), 0);
        Assert.assertEquals(sma.solution(new int[] {2, 1}), 0);
    }

}
