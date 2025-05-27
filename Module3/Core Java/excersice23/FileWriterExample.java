import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterExample {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter text to write to file: ");
            String content = scanner.nextLine();
            
            try (FileWriter writer = new FileWriter("output.txt")) {
                writer.write(content);
                System.out.println("\nSuccessfully wrote to output.txt");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}