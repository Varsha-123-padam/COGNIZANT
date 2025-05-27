import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter a non-negative integer: ");
            int number = scanner.nextInt();
            
            // Validate input
            if (number < 0) {
                System.out.println("Error: Please enter a non-negative number.");
                return;
            }
            
            // Calculate factorial using for loop
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            
            // Display result
            System.out.println(number + "! = " + factorial);
        }
    }
}

