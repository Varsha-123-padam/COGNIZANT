import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        // Create a List of strings
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Purple");

        // Display original list
        System.out.println("Original list: " + colors);

        // Sort using lambda expression
        Collections.sort(colors, (s1, s2) -> s1.compareTo(s2));

        // Display sorted list
        System.out.println("Sorted list: " + colors);
    }
}