import java.util.Scanner;

// Custom Exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Custom {
    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be at least 18 years!");
        }
        System.out.println("Age validation successful: " + age + " years old");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

