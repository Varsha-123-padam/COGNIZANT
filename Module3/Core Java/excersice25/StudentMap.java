import java.util.HashMap;
import java.util.Scanner;

public class StudentMap {
    public static void main(String[] args) {
        // Initialize HashMap and Scanner
        HashMap<Integer, String> students = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                // Display menu
                System.out.println("\nStudent ID Manager");
                System.out.println("1. Add student");
                System.out.println("2. Find student by ID");
                System.out.println("3. View all students");
                System.out.println("4. Exit");
                System.out.print("Choose an option (1-4): ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        students.put(id, name);
                        System.out.println("Student added successfully!");
                    }
                    case 2 -> {
                        System.out.print("Enter student ID to search: ");
                        int searchId = scanner.nextInt();
                        String studentName = students.get(searchId);
                        if (studentName != null) {
                            System.out.println("Student found: " + studentName);
                        } else {
                            System.out.println("No student found with ID: " + searchId);
                        }
                    }
                    case 3 -> {
                        if (students.isEmpty()) {
                            System.out.println("No students in the system.");
                        } else {
                            System.out.println("\nStudent List:");
                            for (Integer studentId : students.keySet()) {
                                System.out.println("ID: " + studentId + ", Name: " + students.get(studentId));
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }
}

