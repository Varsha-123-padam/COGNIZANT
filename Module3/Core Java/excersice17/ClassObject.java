public class ClassObject {
    // Car class definition
    static class Car {
        // Attributes
        private final String make;
        private final String model;
        private final int year;
        
        // Constructor
        public Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }
        
        // Method to display car details
        public void displayDetails() {
            System.out.println("\nCar Details:");
            System.out.println("Make: " + make);
            System.out.println("Model: " + model);
            System.out.println("Year: " + year);
        }
    }
    
    public static void main(String[] args) {
        // Create car objects
        Car car1 = new Car("Toyota", "Camry", 2022);
        Car car2 = new Car("Honda", "Civic", 2023);
        
        // Display details for each car
        car1.displayDetails();
        car2.displayDetails();
    }
}

