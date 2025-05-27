public class PatternMatching {
    public static void main(String[] args) {
        // Test objects of different types
        Object[] objects = {
            "Hello",
            42,
            3.14,
            true,
            new int[]{1, 2, 3}
        };

        // Process each object using pattern matching
        for (Object obj : objects) {
            String result = checkType(obj);
            System.out.println("Object: " + obj + " -> " + result);
        }
    }

    public static String checkType(Object obj) {
        return switch (obj) {
            case String s -> "String with length " + s.length();
            case Integer i -> "Integer with value " + i;
            case Double d -> "Double with value " + d;
            case Boolean b -> "Boolean with value " + b;
            case null -> "Null value";
            case int[] arr -> "Integer array of length " + arr.length;
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };
    }
}

