package calculator;

import java.util.LinkedList;
import java.util.Stack;

public class Calculator {
    private final String input;
    private final LinkedList<Integer> operands;
    private final Stack<String> operators;


    public Calculator(String input) {
        this.input = input;
        this.operands = new LinkedList<>();
        this.operators = new Stack<>();
    }

    public int calculate() {
        String[] tokens = input.split(" ");
        for (int index = 0; index < tokens.length; index++) {
            String token = tokens[index];
            if (Operator.isOperator(token)) {
                insertOperator(token);
            } else {
                operands.addLast(Integer.parseInt(token));
            }
        }

        while (!isCalculateFinished()) {
            int result = subCalculate();
            operands.addLast(result);
        }

        return operands.getFirst();
    }

    private void insertOperator(String operator) {
        if (isOperatorPriorityHigherOrEqual(operator)) {
            operators.push(operator);
        } else {
            if (Operator.isSubExpression(operator)) {
                if (operator.equals("("))
                    operators.push(operator);
                else if (operator.equals(")")) {
                    while (!isOperatorPriorityHigherOrEqual(operator)) {
                        int result = subCalculate();
                        operands.addLast(result);
                    }
                    operators.pop();
                }
            } else {
                while (!isOperatorPriorityHigherOrEqual(operator)) {
                    int result = subCalculate();
                    operands.addLast(result);
                }
                operators.push(operator);
            }
        }
    }

    private boolean isOperatorPriorityHigherOrEqual(String operator) {
        return operators.isEmpty() || Operator.getPriority(operators.peek()) <= Operator.getPriority(operator);
    }

    private int subCalculate() {
        int operand1 = operands.removeLast();
        int operand2 = operands.removeLast();
        String operator = operators.pop();

        System.out.println(operand2 + " " + operator + " " + operand1);

        return Operator.calculate(operand2, operand1, operator);
    }

    private boolean isCalculateFinished() {
        return operands.size() == 1 && operators.isEmpty();
    }
}
