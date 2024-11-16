import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RPNCalculatorTest {

    RPNCalculator calculator = new RPNCalculator();

    @Test
    void testEvaluateSimpleExpression() {
        // Proste wyrażenie: 5 3 +
        assertEquals(8, calculator.evaluate("5 3 +"));
    }

    @Test
    void testEvaluateComplexExpression() {
        // Złożone wyrażenie: 5 3 + 2 *
        assertEquals(16, calculator.evaluate("5 3 + 2 *"));
    }

    @Test
    void testEvaluateExpressionWithDivision() {
        // Wyrażenie z dzieleniem: 6 3 /
        assertEquals(2, calculator.evaluate("6 3 /"));
    }

    @Test
    void testEvaluateExpressionWithMultipleResults() {
        // Wyrażenie, które powinno wygenerować błąd: 5 3 + 2 + 3
        // Oczekiwany błąd - za dużo wyników na stosie
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate("5 3 + 2 + 3");
        });
    }

    @Test
    void testEvaluateExpressionWithZeroDivision() {
        // Wyrażenie, które ma dzielenie przez 0
        assertThrows(ArithmeticException.class, () -> {
            calculator.evaluate("6 0 /");
        });
    }
}