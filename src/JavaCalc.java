import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaCalc {

    public static void main(String[] args) {
        System.out.println("Hello and welcome to the JavaCalc!");
        System.out.println("JavaCalc is a simple calculator. Supported operations:");
        System.out.println("Adding (+), Subtraction (-), Multiplication (*), Division (/), Modulo (%), and Power (^).");
        System.out.println("To Quit type \"exit.\"");
        System.out.println("Example: 10+5 or 10 + 5");

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print(">");
                String input = sc.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Goodbye!");
                    break;
                }
                if (input.isEmpty()) {
                    continue;
                }

                try {
                    //  pass the whole string to the calculate method
                    double result = calculate(input);
                    System.out.println("= " + result);
                } catch (NumberFormatException nfe) {
                    System.out.println("Error: Invalid number format.");
                } catch (ArithmeticException | IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error: An unexpected error occurred.");
                }
            }
        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
        }
    }

    private static double calculate(String input) {
        // Regex: (Number1) (Optional Spaces) (Operator) (Optional Spaces) (Number2)
        String regex = "(-?\\d+\\.?\\d*)\\s*([+\\-*/%^])\\s*(-?\\d+\\.?\\d*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            // matcher.group(1) is the first number, group(2) is the operator, group(3) is the second number
            double a = Double.parseDouble(matcher.group(1));
            String op = matcher.group(2);
            double b = Double.parseDouble(matcher.group(3));

            switch (op) {
                case "+": return add(a, b);
                case "-": return sub(a, b);
                case "*": return multiply(a, b);
                case "/": return divide(a, b);
                case "^": return pow(a, b);
                case "%": return modulo(a, b);
                default:  throw new IllegalArgumentException("Unsupported operator: " + op);
            }
        }
        throw new IllegalArgumentException("Invalid format. Use: Number Operator Number (e.g., 12+5)");
    }

    public static double add(double a, double b) { return a + b; }
    public static double sub(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }

    public static double divide(double a, double b) {
        if (b == 0.0) throw new ArithmeticException("Division by zero!");
        return a / b;
    }

    public static double modulo(double a, double b) {
        if (b == 0.0) throw new ArithmeticException("Modulo by zero!");
        return a % b;
    }

    public static double pow(double a, double b) { return Math.pow(a, b); }
}