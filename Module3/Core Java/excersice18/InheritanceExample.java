public class InheritanceExample {
    // Base class Animal
    static class Animal {
        protected String name;
        
        public Animal(String name) {
            this.name = name;
        }
        
        public void makeSound() {
            System.out.println("Animal makes a sound");
        }
    }
    
    // Derived class Dog
    static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
        
        @Override
        public void makeSound() {
            System.out.println(name + " says: Bark!");
        }
    }
    
    public static void main(String[] args) {
        // Create instances
        Animal genericAnimal = new Animal("Generic");
        Dog dog = new Dog("Buddy");
        
        // Test makeSound() method
        System.out.println("Testing Animal class:");
        genericAnimal.makeSound();
        
        System.out.println("\nTesting Dog class:");
        dog.makeSound();
    }
}