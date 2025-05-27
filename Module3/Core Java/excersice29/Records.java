import java.util.ArrayList;
import java.util.List;

// Define a record for Person
record Person(String name, int age) {}

public class Records {
    public static void main(String[] args) {
        // Create instances of Person record
        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Bob", 30);
        Person person3 = new Person("Charlie", 20);

        // Print individual persons
        System.out.println("Individual persons:");
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        // Create a list of persons
        List<Person> people = new ArrayList<>(List.of(person1, person2, person3));

        // Filter persons older than 25 using Stream
        System.out.println("\nPeople older than 25:");
        people.stream()
             .filter(person -> person.age() > 25)
             .forEach(System.out::println);
    }
}

