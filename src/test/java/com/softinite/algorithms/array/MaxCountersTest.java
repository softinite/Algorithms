package com.softinite.algorithms.array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by Sergiu Ivasenco on 31/07/16.
 */
public class MaxCountersTest {

    @Test
    public void checkCounters() {
        MaxCounters mc = new MaxCounters();
        assertSameArray(mc.solution(5, new int[] {3, 4, 4, 6, 1, 4, 4}), new int[] {3, 2, 2, 4, 2});
        assertSameArray(mc.solution(1, new int[] {1, 1, 2, 1}), new int[] {3});
        assertSameArray(mc.solution(1, new int[] {2}), new int[] {0});
        assertSameArray(mc.solution(1, new int[] {2, 2, 2, 2, 2}), new int[] {0});
        assertSameArray(mc.solution(1, new int[] {1}), new int[] {1});
        int in[] = new int[100_000];
        int out[] = new int[100_000];
        for(int i = 0; i < 100_000; i++) {
            in[i] = 100_000;
            out[99999]++;
        }
        assertSameArray(mc.solution(100_000, in), out);
        assertSameArray(mc.solution(5, new int[] {5, 5, 5, 5, 5, 6}), new int[] {5, 5, 5, 5, 5});
        assertSameArray(mc.solution(3, new int[] {1, 1, 4, 1, 1, 1, 2, 2}), new int[] {5, 4, 2});
    }

    private void assertSameArray(int[] actual, int[] expected) {
        for(int i = 0; i < expected.length; i++) {
            if (actual[i] != expected[i]) {
                Assert.fail("Expected " + expected[i] + " at position " + i + ", but found " + actual[i]);
            }
        }
    }

}
