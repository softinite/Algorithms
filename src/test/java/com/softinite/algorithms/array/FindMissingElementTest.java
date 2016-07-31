package com.softinite.algorithms.array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergiu Ivasenco on 31/07/16.
 */
public class FindMissingElementTest {

    @Test
    public void checkMissing() {
        FindMissingElement fme = new FindMissingElement();
        Assert.assertEquals(fme.solution(new int[]{2, 3, 1, 5}), 4);
        Assert.assertEquals(fme.solution(new int[]{}), 1);
        Assert.assertEquals(fme.solution(new int[]{2, 3, 1, 5, 4, 7, 6}), 8);
        int testList[] = new int[100_000];
        int missing = 1;
        int idx = 0;
        for(int i = 1; i <= 100_001; i++) {
            if (i != missing) {
                testList[idx++] = i;
            }
        }
        int solution = fme.solution(testList);
        Assert.assertEquals(solution, missing);
    }

}
