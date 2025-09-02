import java.util.Stack;

public class Solution {

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = applyOperation(token, operand1, operand2);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int applyOperation(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2; // Integer division, truncates toward zero
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(evaluatePostfix("2 1 + 3 *")); // Output: 9
        System.out.println(evaluatePostfix("5 6 +")); // Output: 11
        System.out.println(evaluatePostfix("-5 6 -")); // Output: -11
        System.out.println(evaluatePostfix("15 7 1 1 + - / 3 * 2 1 1 + + -")); // Output: 5
        System.out.println(evaluatePostfix("5")); // Output: 5
    }
}
