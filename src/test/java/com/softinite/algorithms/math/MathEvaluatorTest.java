package com.softinite.algorithms.math;


import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Responsible for testing MathEvaluator
 * Created by Sergiu Ivasenco on 27/07/16.
 */
public class MathEvaluatorTest {

    @Test
    public void performOperationOnInt() {
        MathEvaluator evaluator = new MathEvaluator("");
        Assert.assertEquals("2", evaluator.performOperation(1, "+", 1));
        Assert.assertEquals("2", evaluator.performOperation(4, "/", 2));
        Assert.assertEquals("6", evaluator.performOperation(2, "*", 3));
        Assert.assertEquals("-2", evaluator.performOperation(-1, "+", -1));
        Assert.assertEquals("-2", evaluator.performOperation(-4, "/", 2));
    }

    @Test
    public void performOperationOnStrings() {
        MathEvaluator evaluator = new MathEvaluator("");
        Assert.assertEquals("2", evaluator.performOperation(" 1", "+", "1"));
        Assert.assertEquals("2", evaluator.performOperation("4", " / ", "2"));
        Assert.assertEquals("6", evaluator.performOperation("2", " *", "3"));
        Assert.assertEquals("-2", evaluator.performOperation("-1", "+", " -1"));
        Assert.assertEquals("-2", evaluator.performOperation("-4", "/", "2"));
    }

    @Test
    public void parseSimpleExpression() {
        MathEvaluator evaluator = new MathEvaluator("");
        Assert.assertEquals("2", evaluator.processSimpleExpression("1+1"));
        Assert.assertEquals("2", evaluator.processSimpleExpression("3-1"));
        Assert.assertEquals("2", evaluator.processSimpleExpression("4/2"));
        Assert.assertEquals("2", evaluator.processSimpleExpression("-8/-4"));
        Assert.assertEquals("2", evaluator.processSimpleExpression("2*1"));
        Assert.assertEquals("2", evaluator.processSimpleExpression("-2 * -1"));
        Assert.assertEquals("2", evaluator.processSimpleExpression("16/ 8"));
        Assert.assertEquals("-2", evaluator.processSimpleExpression("-16 /8"));
        Assert.assertEquals("-2", evaluator.processSimpleExpression("2 - 4"));
        Assert.assertEquals("-2", evaluator.processSimpleExpression("2 *-1"));
        Assert.assertEquals("-1", evaluator.processSimpleExpression("-1"));
        Assert.assertEquals("-1", evaluator.processSimpleExpression(" -1"));
        Assert.assertEquals("-1", evaluator.processSimpleExpression("-1 "));
        Assert.assertEquals("-1", evaluator.processSimpleExpression(" -1 "));
        Assert.assertEquals("4", evaluator.processSimpleExpression("4"));
    }

    @Test
    public void checkEvaluations() {
        Assert.assertEquals("1", new MathEvaluator("(3 + 2)/(4 + 1)").process());
        Assert.assertEquals("-2", new MathEvaluator("(2 - 7)*(4 / 2)/(1 + 1 + 1 + 1 + 1)").process());
        Assert.assertEquals("5", new MathEvaluator("1 + 1 + 1 + 1 + 1").process());
        Assert.assertEquals("-1", new MathEvaluator("(1+ 2)*3-4-(6+2)+8/4").process());
    }

    @Test
    public void stripMargins() {
        MathEvaluator evaluator = new MathEvaluator("");
        Assert.assertEquals("123", evaluator.stripMargins("(123)"));
        Assert.assertEquals("1+2+3", evaluator.stripMargins("(1+2+3)"));
        Assert.assertEquals("1/2/3", evaluator.stripMargins("(1/2/3)"));
        Assert.assertEquals("1", evaluator.stripMargins("(1)"));
        Assert.assertEquals("", evaluator.stripMargins("()"));
        Assert.assertEquals(null, evaluator.stripMargins(null));
        Assert.assertEquals("(", evaluator.stripMargins("("));
        Assert.assertEquals("", evaluator.stripMargins(""));
    }

}
