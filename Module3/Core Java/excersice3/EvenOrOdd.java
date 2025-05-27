import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();
            
            // Check if even or odd using modulus operator
            if (number % 2 == 0) {
                System.out.println(number + " is even.");
            } else {
                System.out.println(number + " is odd.");
            }
        }
    }
}

