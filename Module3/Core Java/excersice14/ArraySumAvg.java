import java.util.Scanner;

public class ArraySumAvg {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get array size from user
            System.out.print("Enter the number of elements: ");
            int size = scanner.nextInt();
            
            // Create and populate the array
            double[] numbers = new double[size];
            for (int i = 0; i < size; i++) {
                System.out.print("Enter element " + (i + 1) + ": ");
                numbers[i] = scanner.nextDouble();
            }
            
            // Calculate sum
            double sum = 0;
            for (double number : numbers) {
                sum += number;
            }
            
            // Calculate average
            double average = sum / size;
            
            // Display results
            System.out.printf("\nSum: %.2f%n", sum);
            System.out.printf("Average: %.2f%n", average);
        }
    }
}

