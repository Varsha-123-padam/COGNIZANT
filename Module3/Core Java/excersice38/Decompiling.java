public class Decompiling {
    private final int secretNumber;
    private String message;

    public Decompiling(int secret) {
        this.secretNumber = secret;
        this.message = encryptMessage("Hello, World!");
    }

    private String encryptMessage(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            encrypted.append((char)(c + secretNumber));
        }
        return encrypted.toString();
    }

    private String decryptMessage() {
        StringBuilder decrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            decrypted.append((char)(c - secretNumber));
        }
        return decrypted.toString();
    }

    public void printSecretMessage() {
        System.out.println("Encrypted: " + message);
        System.out.println("Decrypted: " + decryptMessage());
    }

    public static void main(String[] args) {
        Decompiling demo = new Decompiling(5);
        demo.printSecretMessage();
    }
}

