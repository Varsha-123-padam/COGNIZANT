import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get first number
            System.out.print("Enter the first number (numerator): ");
            int numerator = scanner.nextInt();
            
            // Get second number
            System.out.print("Enter the second number (denominator): ");
            int denominator = scanner.nextInt();
            
            try {
                // Attempt division
                int result = numerator / denominator;
                System.out.println("\nResult of " + numerator + " / " + denominator + " = " + result);
            } catch (ArithmeticException e) {
                // Handle division by zero
                System.out.println("\nError: Cannot divide by zero!");
                System.out.println("Exception details: " + e.getMessage());
            }
        }
    }
}

