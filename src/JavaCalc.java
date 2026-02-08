import java.util.Scanner;

public class JavaCalc {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to the JavaCalc!");
        System.out.println("JavaCalc is simple calculator and you can use this for below calculations, \nAdding (+), Substraction (-), Multiplication (*), Division (/), Moduleo (%) and Power (^).\n" +
                "Please use above Operators only. \nTo Quit type \"exit.\" \n" +
                "Here is the Example to add two numbers type: 10+5");
        System.out.println("\nPlease Enter the Number1 Operator and Numebr2");
        try (Scanner sc = new Scanner(System.in)) {
            while (true){
                System.out.print(">");
                String input= sc.nextLine().trim();
                if(input.equalsIgnoreCase("exit")){
                    System.out.println("Goodbye!");
                    break;
                }
                if (input.isEmpty()){
                    continue;
                }
                try {
                    String[] parts = input.split("\\s+");
                    double result = calculate(parts);
                    System.out.println("= " + result);
                } catch (NumberFormatException nfe) {
                    System.out.println("Error: Invalid number format.");
                } catch (ArithmeticException ae) {
                    System.out.println("Error: " + ae.getMessage());
                } catch (IllegalArgumentException iae) {
                    System.out.println("Error: " + iae.getMessage());
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

            }
            }catch (Exception e){
            System.out.println("Please enter a valid Number1 Operator and Numebr2");
        }


    }


    private static double calculate(String[] parts){
        if (parts.length ==3) {
            double a = Double.parseDouble(parts[0]);
            double b = Double.parseDouble(parts[2]);
            String op = parts[1];

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
        throw new IllegalArgumentException("Wrong input format. Example: 12 + 5");
    }

    public static double add (double a, double b){
        return a+b;
    }
    public static double sub (double a, double b){
        return a-b;
    }
    public static double multiply ( double a, double b){
        return a*b;
    }
    public static double divide(double a, double b){
        if(b==0.0) throw new ArithmeticException("Division by zero!");
        return a/b;
    }
    public static double modulo(double a, double b){
        if (b == 0.0) throw new ArithmeticException("Modulo by zero");
        return a % b;
    }
    public static double pow(double a, double b){
        return Math.pow(a,b);
    }



}