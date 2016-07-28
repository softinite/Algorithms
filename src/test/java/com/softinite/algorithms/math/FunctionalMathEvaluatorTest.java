package com.softinite.algorithms.math;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Responsible for testing the FunctionalMathEvaluator
 * Created by Sergiu Ivasenco on 27/07/16.
 */
public class FunctionalMathEvaluatorTest {

    @Test
    public void reduceSimpleExpression() {
        Assert.assertEquals(FunctionalMathEvaluator.reduceSimple("2*3"), "6");
        Assert.assertEquals(FunctionalMathEvaluator.reduceSimple("2 *3"), "6");
        Assert.assertEquals(FunctionalMathEvaluator.reduceSimple("2* 3"), "6");
        Assert.assertEquals(FunctionalMathEvaluator.reduceSimple("2 * 3"), "6");
        Assert.assertEquals(FunctionalMathEvaluator.reduceSimple(" 2*3"), "6");
        Assert.assertEquals(FunctionalMathEvaluator.reduceSimple("2*3 "), "6");
        Assert.assertEquals(FunctionalMathEvaluator.reduceSimple(" 2 *3"), "6");
        Assert.assertEquals(FunctionalMathEvaluator.reduceSimple("2* 3 "), "6");
        Assert.assertEquals(FunctionalMathEvaluator.reduceSimple("-2*-3"), "6");
        Assert.assertEquals(FunctionalMathEvaluator.reduceSimple("2 * -3"), "-6");
    }

    @Test
    public void checkReduceInteger() {
        assertMatch(FunctionalMathEvaluator.INTEGER_PATTERN, "1", "1");
        assertMatch(FunctionalMathEvaluator.INTEGER_PATTERN, " 1", "1");
        assertMatch(FunctionalMathEvaluator.INTEGER_PATTERN, "1 ", "1");
        assertMatch(FunctionalMathEvaluator.INTEGER_PATTERN, " 1 ", "1");
        assertMatch(FunctionalMathEvaluator.INTEGER_PATTERN, "-1", "-1");
        assertMatch(FunctionalMathEvaluator.INTEGER_PATTERN, " -1", "-1");
        assertMatch(FunctionalMathEvaluator.INTEGER_PATTERN, "-1 ", "-1");
        assertMatch(FunctionalMathEvaluator.INTEGER_PATTERN, " -1 ", "-1");
    }

    private void assertMatch(Pattern pattern, String input, String actual) {
        Matcher matcher = pattern.matcher(input);
        Assert.assertTrue(matcher.matches());
        Assert.assertEquals(FunctionalMathEvaluator.reduceInteger(matcher), actual);
    }

    @Test
    public void checkEvaluations() {
        Assert.assertEquals(new FunctionalMathEvaluator("(3 + 2)/(4 + 1)").process(), "1");
        Assert.assertEquals(new FunctionalMathEvaluator("(2 - 7)*(4 / 2)/(1 + 1 + 1 + 1 + 1)").process(), "-2");
        Assert.assertEquals(new FunctionalMathEvaluator("1 + 1 + 1 + 1 + 1").process(), "5");
        Assert.assertEquals(new FunctionalMathEvaluator("(1+ 2)*3-4-(6+2)+8/4").process(), "-1");
    }

}
