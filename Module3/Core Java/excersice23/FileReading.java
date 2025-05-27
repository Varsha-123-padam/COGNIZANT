import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {
    public static void main(String[] args) {
        // Path to the file
        String filePath = "c:\\Users\\DELL\\OneDrive\\Desktop\\Module3\\Core Java\\excersice23\\output.txt";
        
        // Read file using BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("File contents:");
            System.out.println("-------------");
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            System.out.println("-------------");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

