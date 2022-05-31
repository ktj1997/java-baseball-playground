package calculator;

public class Main {
    public static void main(String[] args) {
        String input = InputUtil.getInput();
        Calculator calc = new Calculator(input);

        int result = calc.calculate();
        System.out.println(result);
    }
}
