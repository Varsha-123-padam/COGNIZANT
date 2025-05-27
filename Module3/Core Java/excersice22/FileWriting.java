import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriting {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get input from user
            System.out.print("Enter text to write to file: ");
            String userInput = scanner.nextLine();
            
            // Write to file using FileWriter
            try (FileWriter writer = new FileWriter("output.txt")) {
                writer.write(userInput);
                System.out.println("\nSuccessfully wrote to the file!");
                System.out.println("File location: " + System.getProperty("user.dir") + "\\output.txt");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
                System.out.println("Error details: " + e.getMessage());
            }
        }
    }
}

