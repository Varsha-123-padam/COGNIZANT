import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server is listening on port 5000...");
            
            try (Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in))) {
                
                System.out.println("Client connected!");
                
                // Start a thread to read client messages
                Thread readerThread = new Thread(() -> {
                    try {
                        String inputLine;
                        while ((inputLine = in.readLine()) != null) {
                            System.out.println("Client: " + inputLine);
                        }
                    } catch (IOException e) {
                        System.out.println("Client disconnected");
                    }
                });
                readerThread.start();
                
                // Main thread handles server input
                String serverInput;
                while ((serverInput = consoleIn.readLine()) != null) {
                    out.println(serverInput);
                }
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }
    }
}

