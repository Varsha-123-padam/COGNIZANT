import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.io.IOException;

public class HttpClientExample {
    public static void main(String[] args) {
        // Create an HttpClient
        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();

        // Create an HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/repos/microsoft/vscode"))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            // Send request and get response
            HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());

            // Print status code
            System.out.println("Status Code: " + response.statusCode());
            
            // Print headers
            System.out.println("\nHeaders:");
            response.headers().map().forEach((k, v) -> System.out.println(k + ": " + v));
            
            // Print body
            System.out.println("\nBody:");
            System.out.println(response.body());

        } catch (IOException | InterruptedException e) {
            System.err.println("Error making request: " + e.getMessage());
        }
    }
}