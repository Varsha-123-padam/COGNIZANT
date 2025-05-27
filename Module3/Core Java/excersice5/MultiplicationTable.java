import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();
            
            // Print table header
            System.out.println("\nMultiplication Table for " + number + ":");
            System.out.println("-------------------------");
            
            // Generate multiplication table using for loop
            for (int i = 1; i <= 10; i++) {
                int result = number * i;
                System.out.printf("%d x %d = %d%n", number, i, result);
            }
        }
    }
}

