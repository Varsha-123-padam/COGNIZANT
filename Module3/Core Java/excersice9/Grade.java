import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for marks
            System.out.print("Enter marks (0-100): ");
            int marks = scanner.nextInt();
            
            // Determine grade using if-else statements
            String grade;
            if (marks >= 90 && marks <= 100) {
                grade = "A";
            } else if (marks >= 80 && marks <= 89) {
                grade = "B";
            } else if (marks >= 70 && marks <= 79) {
                grade = "C";
            } else if (marks >= 60 && marks <= 69) {
                grade = "D";
            } else if (marks >= 0 && marks < 60) {
                grade = "F";
            } else {
                grade = "Invalid marks";
            }
            
            // Display result
            System.out.println("Grade: " + grade);
        }
    }
}