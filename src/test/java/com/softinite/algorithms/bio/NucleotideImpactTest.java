package com.softinite.algorithms.bio;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

/**
 * Created by Sergiu Ivasenco on 31/07/16.
 */
public class NucleotideImpactTest {

    private NucleotideImpact ni;

    @BeforeClass
    public void setup() {
        ni = new NucleotideImpact();
    }

    @Test
    public void checkImpact() {
        assertSameArray(ni.solution("CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6}), new int[] {2, 4, 1});
        assertSameArray(ni.solution("A", new int[] {0}, new int[] {0}), new int[] {1});
        assertSameArray(ni.solution("C", new int[] {0}, new int[] {0}), new int[] {2});
        assertSameArray(ni.solution("G", new int[] {0}, new int[] {0}), new int[] {3});
        assertSameArray(ni.solution("T", new int[] {0}, new int[] {0}), new int[] {4});
        assertSameArray(ni.solution("ACGT", new int[] {1}, new int[] {3}), new int[] {2});
    }

    private void assertSameArray(int[] actual, int[] expected) {
        for(int i = 0; i < expected.length; i++) {
            if (actual[i] != expected[i]) {
                Assert.fail("Expected " + expected[i] + " at position " + i + ", but found " + actual[i]);
            }
        }
    }

    @Test
    public void checkMaxLimits() {
        final StringBuilder sb = new StringBuilder();
        IntStream.range(0, 100_000).forEach(i -> {
            sb.append("A");
        });
        int []p = new int[50_000];
        int []q = new int[50_000];
        int []res = new int[50_000];
        IntStream.range(0, 50_000).forEach(i -> {
            p[i] = 0;
            q[i] = i;
            res[i] = 1;
        });
        assertSameArray(ni.solution(sb.toString(), p, q), res);

        StringBuilder sb1 = new StringBuilder();
        IntStream.range(0, 100_000).forEach(i -> {
            sb1.append("C");
        });
        int []p1 = new int[50_000];
        int []q1 = new int[50_000];
        int []res1 = new int[50_000];
        IntStream.range(0, 50_000).forEach(i -> {
            p1[i] = 0;
            q1[i] = i;
            res1[i] = 2;
        });
        assertSameArray(ni.solution(sb1.toString(), p1, q1), res1);

        StringBuilder sb2 = new StringBuilder();
        IntStream.range(0, 100_000).forEach(i -> {
            sb2.append("G");
        });
        int []p2 = new int[50_000];
        int []q2 = new int[50_000];
        int []res2 = new int[50_000];
        IntStream.range(0, 50_000).forEach(i -> {
            p2[i] = 0;
            q2[i] = i;
            res2[i] = 3;
        });
        assertSameArray(ni.solution(sb2.toString(), p2, q2), res2);

        StringBuilder sb3 = new StringBuilder();
        IntStream.range(0, 100_000).forEach(i -> {
            sb3.append("T");
        });
        int []p3 = new int[50_000];
        int []q3 = new int[50_000];
        int []res3 = new int[50_000];
        IntStream.range(0, 50_000).forEach(i -> {
            p3[i] = 0;
            q3[i] = i;
            res3[i] = 4;
        });
        assertSameArray(ni.solution(sb3.toString(), p3, q3), res3);
    }

}
