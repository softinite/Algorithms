package com.softinite.algorithms.math;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Responsible for evaluating mathematical expressions on Integers without the use of any engine
 * Created by Sergiu Ivasenco on 27/07/16.
 */
public class MathEvaluator {

    private static final Pattern BRAKETS_EXPRESSION = Pattern.compile("(.*?)(\\(.*?\\))(.*)");
    private static final Pattern SIMPLE_EXPRESSION = Pattern.compile("(\\-?\\d+\\s?)([\\/\\*\\-\\+]\\s?)(\\-?\\d+)");
    private static final Pattern MD_EXPRESSION = Pattern.compile(".*?((?:\\s\\-?)?\\d+\\s?[\\/\\*]\\s?\\-?\\d+).*");
    private static final Pattern SUM_SUB_EXPRESSION = Pattern.compile("(\\-?\\d+\\s?[\\-\\+]\\s?\\-?\\d+)(\\s?[\\-\\+]\\s?[\\d\\-\\+\\s]+)");
    private static final Pattern INTEGER_EXPRESSION = Pattern.compile("\\s*\\-?\\d+\\s*");
    private static final Map<String, String> CACHE = new HashMap<>();

    private String expression;

    public MathEvaluator(String e) {
        setExpression(e);
    }

    public String process() {
        if (CACHE.containsKey(getExpression())) {
            return CACHE.get(getExpression());
        }
        String result;
        Matcher matcher = BRAKETS_EXPRESSION.matcher(getExpression());
        if (matcher.matches()) {
            String before = matcher.group(1);
            String braket = matcher.group(2);
            String after = matcher.group(3);
            MathEvaluator braketEvaluator = new MathEvaluator(stripMargins(braket));
            result = new MathEvaluator(before + braketEvaluator.process() + after).process();
        } else {
            result = processNonBrakets();
        }
        CACHE.put(getExpression(), result);
        return result;
    }

    protected String stripMargins(String marginString) {
        if (marginString == null || marginString.length() < 2) {
            return marginString;
        }
        return marginString.substring(1, marginString.length() - 1);
    }

    private String processNonBrakets() {
        Matcher matcher = MD_EXPRESSION.matcher(getExpression());
        if (matcher.matches()) {
            String mdExpression = matcher.group(1);
            if (mdExpression.equals(getExpression())) {
                return processSimpleExpression(mdExpression);
            } else {
                int mdIdx = getExpression().indexOf(mdExpression);
                String before = getExpression().substring(0, mdIdx);
                String expr = new MathEvaluator(mdExpression).process();
                String after = getExpression().substring(mdIdx + mdExpression.length());
                return new MathEvaluator(before + expr + after).process();
            }
        } else {
            return processNoDivisionMultiplication();
        }
    }

    protected String processSimpleExpression(String simpleExpression) {
        if (CACHE.containsKey(simpleExpression)) {
            return CACHE.get(simpleExpression);
        }
        Matcher matcher = SIMPLE_EXPRESSION.matcher(simpleExpression);
        String result;
        if (matcher.matches()) {
            result = performOperation(matcher.group(1), matcher.group(2), matcher.group(3));
        } else {
            matcher = INTEGER_EXPRESSION.matcher(simpleExpression);
            if (matcher.matches()) {
                result = simpleExpression.trim();
            } else {
                throw new RuntimeException("Invalid simple expression: " + simpleExpression);
            }
        }
        CACHE.put(simpleExpression, result);
        return result;
    }

    protected String performOperation(String fN, String op, String sN) {
        return performOperation(Integer.parseInt(fN.trim()), op.trim(), Integer.parseInt(sN.trim()));
    }

    protected String performOperation(Integer fN, String op, Integer sN) {
        switch (op) {
            case "+": return "" + (fN + sN);
            case "-": return "" + (fN - sN);
            case "/": return "" + (fN / sN);
            case "*": return "" + (fN * sN);
            default: throw new RuntimeException("Invalid operation: " + op);
        }
    }

    private String processNoDivisionMultiplication() {
        Matcher matcher = SUM_SUB_EXPRESSION.matcher(getExpression());
        if (matcher.matches()) {
            String head = processSimpleExpression(matcher.group(1));
            return new MathEvaluator(head + matcher.group(2)).process();
        } else {
            return processSimpleExpression(getExpression());
        }
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
