import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter a string to reverse: ");
            String input = scanner.nextLine();
            
            // Method 1: Using StringBuilder
            String reversed1 = new StringBuilder(input).reverse().toString();
            
            // Method 2: Using loop
            char[] chars = input.toCharArray();
            String reversed2 = "";
            for (int i = chars.length - 1; i >= 0; i--) {
                reversed2 += chars[i];
            }
            
            // Display results
            System.out.println("\nUsing StringBuilder:");
            System.out.println("Original: " + input);
            System.out.println("Reversed: " + reversed1);
            
            System.out.println("\nUsing Loop:");
            System.out.println("Original: " + input);
            System.out.println("Reversed: " + reversed2);
        }
    }
}

