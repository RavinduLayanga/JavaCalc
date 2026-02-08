import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class JavaCalcTest {

    @Test
    void add() {
        assertEquals(15.0, JavaCalc.add(10.0, 5.0), "10 + 5 should be 15");
        assertEquals(-2.0, JavaCalc.add(-5.0, 3.0), "-5 + 3 should be -2");
    }

    @Test
    void sub() {
        assertEquals(5.0, JavaCalc.sub(10.0, 5.0), "10 - 5 should be 5");
        assertEquals(-8.0, JavaCalc.sub(-5.0, 3.0), "-5 - 3 should be -8");
    }

    @Test
    void multiply() {
        assertEquals(50.0, JavaCalc.multiply(10.0, 5.0), "10 * 5 should be 50");
        assertEquals(0.0, JavaCalc.multiply(10.0, 0.0), "Multiplication by zero should be zero");
    }

    @Test
    void divide() {
        assertEquals(2.0, JavaCalc.divide(10.0, 5.0), "10 / 5 should be 2");

        // Testing the Exception you wrote in your code
        assertThrows(ArithmeticException.class, () -> {
            JavaCalc.divide(10.0, 0.0);
        }, "Dividing by zero should throw ArithmeticException");
    }

    @Test
    void modulo() {
        assertEquals(1.0, JavaCalc.modulo(10.0, 3.0), "10 % 3 should be 1");

        assertThrows(ArithmeticException.class, () -> {
            JavaCalc.modulo(10.0, 0.0);
        }, "Modulo zero should throw ArithmeticException");
    }

    @Test
    void pow() {
        assertEquals(100.0, JavaCalc.pow(10.0, 2.0), "10^2 should be 100");
        assertEquals(1.0, JavaCalc.pow(10.0, 0.0), "Any number to power 0 should be 1");
    }
}