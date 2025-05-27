import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        // Initialize ArrayList and Scanner
        ArrayList<String> students = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                // Display menu
                System.out.println("\nStudent Names Manager");
                System.out.println("1. Add student");
                System.out.println("2. View all students");
                System.out.println("3. Exit");
                System.out.print("Choose an option (1-3): ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        students.add(name);
                        System.out.println("Student added successfully!");
                    }
                    case 2 -> {
                        if (students.isEmpty()) {
                            System.out.println("No students in the list.");
                        } else {
                            System.out.println("\nStudent List:");
                            for (int i = 0; i < students.size(); i++) {
                                System.out.println((i + 1) + ". " + students.get(i));
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }
}

