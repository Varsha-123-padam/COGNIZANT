public class MethodOverloading {
    // Method to add two integers
    public static int add(int a, int b) {
        return a + b;
    }
    
    // Method to add two doubles
    public static double add(double a, double b) {
        return a + b;
    }
    
    // Method to add three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
    
    public static void main(String[] args) {
        // Test two integers
        int sum1 = add(5, 10);
        System.out.println("Sum of two integers: " + sum1);
        
        // Test two doubles
        double sum2 = add(5.5, 10.5);
        System.out.println("Sum of two doubles: " + sum2);
        
        // Test three integers
        int sum3 = add(5, 10, 15);
        System.out.println("Sum of three integers: " + sum3);
    }
}

