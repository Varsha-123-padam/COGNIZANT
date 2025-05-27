public class InheritenceImplimentation {
    // Define the Playable interface
    interface Playable {
        void play();
    }
    
    // Implement interface in Guitar class
    static class Guitar implements Playable {
        @Override
        public void play() {
            System.out.println("Guitar: Strumming the strings");
        }
    }
    
    // Implement interface in Piano class
    static class Piano implements Playable {
        @Override
        public void play() {
            System.out.println("Piano: Playing the keys");
        }
    }
    
    public static void main(String[] args) {
        // Create instances of both classes
        Guitar guitar = new Guitar();
        Piano piano = new Piano();
        
        // Demonstrate polymorphism using interface type
        System.out.println("Testing instruments:");
        
        Playable instrument1 = guitar;
        Playable instrument2 = piano;
        
        System.out.println("\nUsing Guitar:");
        instrument1.play();
        
        System.out.println("\nUsing Piano:");
        instrument2.play();
    }
}