public class InspectBytecode {
    private int value;

    public InspectBytecode(int value) {
        this.value = value;
    }

    public int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        InspectBytecode obj = new InspectBytecode(5);
        System.out.println("Initial value: " + obj.getValue());
        System.out.println("Factorial of 5: " + obj.factorial(5));
        obj.setValue(10);
        System.out.println("New value: " + obj.getValue());
    }
}

