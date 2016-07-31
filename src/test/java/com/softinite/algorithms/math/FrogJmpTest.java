package com.softinite.algorithms.math;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sergiu Ivasenco on 31/07/16.
 */
public class FrogJmpTest {

    @Test
    public void checkJumps() {
        FrogJmp fj = new FrogJmp();
        Assert.assertEquals(fj.solution(2, 6, 3), 2);
        Assert.assertEquals(fj.solution(10, 85, 30), 3);
        Assert.assertEquals(fj.solution(6, 6, 3), 0);
        Assert.assertEquals(fj.solution(1, 1_000_000_000, 1), 999999999);
    }

}
