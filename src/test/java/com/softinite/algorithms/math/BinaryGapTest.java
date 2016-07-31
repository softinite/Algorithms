package com.softinite.algorithms.math;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sergiu Ivasenco on 30/07/16.
 */
public class BinaryGapTest {

    @Test
    public void checkGaps() {
        BinaryGap bg = new BinaryGap();
        Assert.assertEquals(bg.solution(1041), 5);
        Assert.assertEquals(bg.solution(9), 2);
        Assert.assertEquals(bg.solution(529), 4);
        Assert.assertEquals(bg.solution(20), 1);
        Assert.assertEquals(bg.solution(15), 0);
        Assert.assertEquals(bg.solution(-9), 0);
        Assert.assertEquals(bg.solution(0), 0);
        Assert.assertEquals(bg.solution(Integer.MAX_VALUE), 0);
        Assert.assertEquals(bg.solution(Integer.MIN_VALUE), 0);
    }

}
