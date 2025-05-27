import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in))) {
            
            System.out.println("Connected to server!");
            
            // Start a thread to read server messages
            Thread readerThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println("Server: " + serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Server disconnected");
                }
            });
            readerThread.start();
            
            // Main thread handles user input
            String userInput;
            while ((userInput = consoleIn.readLine()) != null) {
                out.println(userInput);
            }
            
        } catch (IOException e) {
            System.out.println("Client exception: " + e.getMessage());
        }
    }
}