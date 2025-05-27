public class SampleClass {
    private String message;
    
    public SampleClass() {
        this.message = "Default message";
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    private void printMessage() {
        System.out.println(message);
    }
    
    public int add(int a, int b) {
        return a + b;
    }
}