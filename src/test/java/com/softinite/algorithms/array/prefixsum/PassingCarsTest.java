package com.softinite.algorithms.array.prefixsum;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

/**
 * Created by Sergiu Ivasenco on 01/08/16.
 */
public class PassingCarsTest {

    @Test
    public void checkCases() {
        PassingCars pc = new PassingCars();
        Assert.assertEquals(pc.solution(new int[] {0, 1, 0, 1, 1}), 5);
        int veryLarge[] = new int[100_000];
        IntStream.range(0, 100_000).forEach(i -> veryLarge[i] = i % 2);
        Assert.assertEquals(pc.solution(veryLarge), -1);
        veryLarge[0] = 0;
        IntStream.range(1, 100_000).forEach(i -> veryLarge[i] = 1);
        Assert.assertEquals(pc.solution(veryLarge), 99_999);
        Assert.assertEquals(pc.solution(new int[] {1, 1, 0, 1, 1}), 2);
        Assert.assertEquals(pc.solution(new int[] {0, 1, 0, 1, 1, 0}), 5);
    }

}
