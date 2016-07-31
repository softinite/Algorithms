package com.softinite.algorithms.array;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sergiu Ivasenco on 30/07/16.
 */
public class OddOccurencesInArrayTest {

    @Test
    public void checkOddOccurence() {
        assertOdd(new int[] {9, 3, 9, 3, 9, 7, 9}, 7);
        assertOdd(new int[] {1, 1, 1, 1, 4, 1000, 1000}, 4);
        assertOdd(new int[] {13, 3, 6, 2, 2, 6, 3}, 13);
        assertOdd(new int[] {13, 3, 6, 2, 3, 6, 13}, 2);
        assertOdd(new int[] {3}, 3);
    }

    private void assertOdd(int a[], int odd) {
        OddOccurencesInArray ooia = new OddOccurencesInArray();
        Assert.assertEquals(ooia.solution(a), odd);
    }

}
