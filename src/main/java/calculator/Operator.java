package calculator;

import java.util.HashMap;

public class Operator {
    private static HashMap<String, Integer> elements;

    static {
        elements = new HashMap<>();

        elements.put("(", 0);
        elements.put(")", 0);

        elements.put("*", 2);
        elements.put("/", 2);

        elements.put("+", 1);
        elements.put("-", 1);
    }

    public static boolean isOperator(String chr) {
        return elements.containsKey(chr);
    }

    public static boolean isSubExpression(String chr) {
        return chr.equals("(") || chr.equals(")");
    }


    public static int getPriority(String chr) {
        return elements.get(chr);
    }


    public static int calculate(int operand1, int operand2, String operator) {
        if (!elements.containsKey(operator)) {
            throw new RuntimeException("연산자가 올바르지 않습니다.");
        } else {
            switch (operator) {
                case "+":
                    return operand1 + operand2;
                case "-":
                    return operand1 - operand2;
                case "*":
                    return operand1 * operand2;
                default:
                    return operand1 / operand2;
            }
        }
    }
}
