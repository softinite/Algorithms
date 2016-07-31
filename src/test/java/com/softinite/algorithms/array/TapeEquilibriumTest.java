package com.softinite.algorithms.array;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sergiu Ivasenco on 31/07/16.
 */
public class TapeEquilibriumTest {

    @Test
    public void checkEquilibrium() {
        TapeEquilibrium te = new TapeEquilibrium();
        Assert.assertEquals(te.solution(new int[]{3, 1, 2, 4, 3}), 1);
        Assert.assertEquals(te.solution(new int[]{3, -1, 2, -4, 3}), 1);
        Assert.assertEquals(te.solution(new int[]{-1, 1}), 2);
    }

}
