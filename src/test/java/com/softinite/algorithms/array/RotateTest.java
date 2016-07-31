package com.softinite.algorithms.array;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sergiu Ivasenco on 30/07/16.
 */
public class RotateTest {

    @Test
    public void rotate() {
        Rotate r = new Rotate();
        int[] arr = {};
        Assert.assertEquals(r.solution(arr, 100), arr);
        Assert.assertEquals(r.solution(arr, 0), arr);
        arr = new int[] {1};
        Assert.assertEquals(r.solution(arr, 0), arr);
        Assert.assertEquals(r.solution(arr, 100), arr);
        Assert.assertEquals(r.solution(arr, 1), arr);
        arr = new int[] {1,2};
        Assert.assertEquals(r.solution(arr, 0), arr);
        Assert.assertEquals(r.solution(arr, 100), arr);
        int[] sol = r.solution(arr, 1);
        Assert.assertEquals(sol.length, 2);
        Assert.assertEquals(sol[0], 2);
        Assert.assertEquals(sol[1], 1);
        arr = new int[]{3, 8, 9, 7, 6};
        sol = r.solution(arr, 3);
        Assert.assertEquals(sol.length, 5);
        Assert.assertEquals(sol[0], 9);
        Assert.assertEquals(sol[1], 7);
        Assert.assertEquals(sol[2], 6);
        Assert.assertEquals(sol[3], 3);
        Assert.assertEquals(sol[4], 8);
    }

}
