public class TypeCasting {
    public static void main(String[] args) {
        // Double to Int (explicit casting)
        double decimal = 9.99;
        int intValue = (int) decimal;
        System.out.println("Double value: " + decimal);
        System.out.println("After casting to int: " + intValue);
        
        // Int to Double (implicit casting)
        int number = 25;
        double doubleValue = number;
        System.out.println("\nInteger value: " + number);
        System.out.println("After casting to double: " + doubleValue);
    }
}

