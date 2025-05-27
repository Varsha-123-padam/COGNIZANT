import java.util.Scanner;
public class SimpleCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        
            // Get first number
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
        
            // Get second number
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
        
            // Get operation choice
            System.out.println("Choose operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.print("Enter choice (1-4): ");
            int choice = scanner.nextInt();
        
            // Perform calculation
            switch (choice) {
                case 1 -> {
                    double result = num1 + num2;
                    System.out.println(num1 + " + " + num2 + " = " + result);
                }
                case 2 -> {
                    double result = num1 - num2;
                    System.out.println(num1 + " - " + num2 + " = " + result);
                }
                case 3 -> {
                    double result = num1 * num2;
                    System.out.println(num1 + " * " + num2 + " = " + result);
                }
                case 4 -> {
                    if (num2 != 0) {
                        double result = num1 / num2;
                        System.out.println(num1 + " / " + num2 + " = " + result);
                    } else {
                        System.out.println("Error: Division by zero!");
                    }
                }
                default -> System.out.println("Invalid choice!");
            }
        
        }
    }
}

