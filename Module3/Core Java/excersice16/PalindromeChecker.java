import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter a string to check: ");
            String input = scanner.nextLine();
            
            // Clean the string
            String cleanString = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            
            // Check if it's a palindrome
            boolean isPalindrome = true;
            int length = cleanString.length();
            for (int i = 0; i < length / 2; i++) {
                if (cleanString.charAt(i) != cleanString.charAt(length - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }
            
            // Display result
            System.out.println("\nOriginal string: " + input);
            System.out.println("Cleaned string: " + cleanString);
            if (isPalindrome) {
                System.out.println("This is a palindrome!");
            } else {
                System.out.println("This is not a palindrome.");
            }
        }
    }
}

