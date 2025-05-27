public class Operator {
    public static void main(String[] args) {
        // Expression 1: Arithmetic precedence
        int result1 = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result1);
        System.out.println("(Multiplication before addition)\n");
        
        // Expression 2: Parentheses changing precedence
        int result2 = (10 + 5) * 2;
        System.out.println("(10 + 5) * 2 = " + result2);
        System.out.println("(Parentheses evaluated first)\n");
        
        // Expression 3: Multiple operators
        int result3 = 20 / 4 * 3 + 2 - 1;
        System.out.println("20 / 4 * 3 + 2 - 1 = " + result3);
        System.out.println("(Division and multiplication before addition and subtraction)\n");
        
        // Expression 4: Combined with assignment
        int x = 5;
        x *= 3 + 2;  // equivalent to x = x * (3 + 2)
        System.out.println("x *= 3 + 2 (where x = 5) = " + x);
        System.out.println("(Addition inside assignment operator evaluated first)");
    }
}

