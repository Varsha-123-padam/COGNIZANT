import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        String filePath = "c:\\Users\\DELL\\OneDrive\\Desktop\\Module3\\Core Java\\excersice23\\output.txt";
        String content = "Hello, this is a test file!\nThis is line 2.\nThis is line 3.";
        
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("Successfully created and wrote to file!");
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }
}