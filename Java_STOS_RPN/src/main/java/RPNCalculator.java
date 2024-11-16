import java.util.Stack;

public class RPNCalculator {
    public int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();

        // Rozdzielamy wyrażenie po spacji
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isOperator(token)) {
                // Jeśli token to operator, wykonujemy operację na dwóch ostatnich elementach stosu
                int b = stack.pop();
                int a = stack.pop();
                int result = performOperation(a, b, token);
                stack.push(result);
            } else {
                // Jeśli token to liczba, dodajemy ją na stos
                stack.push(Integer.parseInt(token));
            }
        }

        // Sprawdzamy, czy w stosie pozostał tylko jeden wynik
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression, multiple results found.");
        }

        // Zwracamy wynik
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int performOperation(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}