
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        // Create a List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Display original list
        System.out.println("Original list: " + numbers);

        // Use Stream API to filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                                         .filter(num -> num % 2 == 0)
                                         .collect(Collectors.toList());

        // Display filtered list
        System.out.println("Even numbers: " + evenNumbers);
    }
}