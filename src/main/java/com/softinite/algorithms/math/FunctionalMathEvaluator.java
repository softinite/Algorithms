package com.softinite.algorithms.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Responsible for evaluating an expression in a functional way
 * Created by Sergiu Ivasenco on 27/07/16.
 */
public class FunctionalMathEvaluator {

    private static final Map<String, String> CACHE = new HashMap<>();
    public static final Pattern INTEGER_PATTERN = Pattern.compile("\\s*\\-?\\d+\\s*");
    public static final Pattern SIMPLE_PATTERN = Pattern.compile("\\s*(\\-?\\d+\\s?)([\\/\\*\\-\\+]\\s?)(\\-?\\d+)\\s*");

    private enum PatternHandler{
        INTEGER(INTEGER_PATTERN, FunctionalMathEvaluator::reduceInteger),
        SUM_SUB(Pattern.compile("(\\-?\\d+\\s?[\\-\\+]\\s?\\-?\\d+)(\\s?[\\-\\+]\\s?[\\d\\-\\+\\s]+)"), FunctionalMathEvaluator::reduceSumSubstraction),
        MULT_DIV(Pattern.compile(".*?((?:\\s\\-?)?\\d+\\s?[\\/\\*]\\s?\\-?\\d+).*"), FunctionalMathEvaluator::reduceMultiplicationDivision),
        SIMPLE(SIMPLE_PATTERN, FunctionalMathEvaluator::performOperation),
        BRAKETS(Pattern.compile("(.*?)\\((.*?)\\)(.*)"), FunctionalMathEvaluator::reduceBrakets);

        private Pattern pattern;
        private Function<Matcher, String> mainReducer;

        PatternHandler(Pattern pattern, Function<Matcher, String> mReducer) {
            this.pattern = pattern;
            this.mainReducer = mReducer;
        }

        public Pattern getPattern() {
            return pattern;
        }

        public Function<Matcher, String> getMainReducer() {
            return mainReducer;
        }
    }

    private String expression;
    private Stack<PatternHandler> patternHandlers;

    public FunctionalMathEvaluator(String e) {
        setExpression(e);
        Stack<PatternHandler> stack = new Stack<>();
        stack.push(PatternHandler.INTEGER);
        stack.push(PatternHandler.SIMPLE);
        stack.push(PatternHandler.SUM_SUB);
        stack.push(PatternHandler.MULT_DIV);
        stack.push(PatternHandler.BRAKETS);
        setPatternHandlers(stack);
    }

    public String process() {
        if (CACHE.containsKey(getExpression())) {
            return CACHE.get(getExpression());
        }
        String result = doReduce();
        CACHE.put(getExpression(), result);
        return result;
    }

    private String doReduce() {
        if (getPatternHandlers().empty()) {
            return getExpression();
        }
        PatternHandler patternHandler = getPatternHandlers().pop();
        Pattern pattern = patternHandler.getPattern();
        Matcher matcher = pattern.matcher(getExpression());
        if (matcher.matches()) {
            String newExpression = patternHandler.getMainReducer().apply(matcher);
            if (pattern.equals(INTEGER_PATTERN)) {
                return newExpression;
            }
            return new FunctionalMathEvaluator(newExpression).process();
        } else {
            return doReduce();
        }
    }

    protected static String reduceBrakets(Matcher matcher) {
        String before = matcher.group(1);
        String subExpr = new FunctionalMathEvaluator(matcher.group(2)).process();
        String after = matcher.group(3);
        return new FunctionalMathEvaluator(before + subExpr + after).process();
    }

    protected static String reduceSimple(String simpleExpression) {
        Matcher matcher = SIMPLE_PATTERN.matcher(simpleExpression);
        if (matcher.matches()) {
            return performOperation(matcher);
        } else {
            throw new RuntimeException("Not a simple expression: " + simpleExpression);
        }
    }

    protected static String reduceMultiplicationDivision(Matcher matcher) {
        String fullExpression = matcher.group(0);
        String subExpression = matcher.group(1);
        if (subExpression.length() == fullExpression.length()) {
            return reduceSimple(subExpression);
        } else {
            int mdIdx = fullExpression.indexOf(subExpression);
            String before = fullExpression.substring(0, mdIdx);
            String expr = reduceSimple(subExpression);
            String after = fullExpression.substring(mdIdx + subExpression.length());
            return new FunctionalMathEvaluator(before + expr + after).process();
        }
    }

    protected static String reduceSumSubstraction(Matcher matcher) {
        String head = reduceSimple(matcher.group(1));
        return new FunctionalMathEvaluator(head + matcher.group(2)).process();
    }

    protected static String reduceInteger(Matcher matcher) {
        return matcher.group(0).trim();
    }

    protected static String performOperation(Matcher matcher) {
        return performOperation(matcher.group(1), matcher.group(2), matcher.group(3));
    }

    protected static String performOperation(String fN, String op, String sN) {
        return performOperation(Integer.parseInt(fN.trim()), op.trim(), Integer.parseInt(sN.trim()));
    }

    protected static String performOperation(Integer fN, String op, Integer sN) {
        switch (op) {
            case "+": return "" + (fN + sN);
            case "-": return "" + (fN - sN);
            case "/": return "" + (fN / sN);
            case "*": return "" + (fN * sN);
            default: throw new RuntimeException("Invalid operation: " + op);
        }
    }

    public String getExpression() {
        return expression;
    }

    protected void setExpression(String expression) {
        this.expression = expression;
    }

    protected Stack<PatternHandler> getPatternHandlers() {
        return patternHandlers;
    }

    protected void setPatternHandlers(Stack<PatternHandler> patternHandlers) {
        this.patternHandlers = patternHandlers;
    }
}
