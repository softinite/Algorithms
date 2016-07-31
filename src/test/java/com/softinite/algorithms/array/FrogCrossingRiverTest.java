package com.softinite.algorithms.array;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sergiu Ivasenco on 31/07/16.
 */
public class FrogCrossingRiverTest {

    @Test
    public void checkPath() {
        FrogCrossingRiver fcr = new FrogCrossingRiver();
        Assert.assertEquals(fcr.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}), 6);
        Assert.assertEquals(fcr.solution(1, new int[]{1, 1, 1}), 0);
        int input[] = new int[100_000];
        for(int i = 0; i < 100_000; i++) {
            input[i] = i + 1;
        }
        Assert.assertEquals(fcr.solution(100_000, input), 99999);
        Assert.assertEquals(fcr.solution(1, new int[]{1}), 0);
        Assert.assertEquals(fcr.solution(5, new int[]{1, 3, 1, 4, 3, 5, 4}), -1);
        Assert.assertEquals(fcr.solution(1, new int[]{1}), 0);
    }

}
