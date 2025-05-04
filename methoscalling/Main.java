package methoscalling;

class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark");
    }

    void wagTail() {
        System.out.println("Wagging tail");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog(); // Upcasting
        animal.makeSound(); // Output: Bark

        if (animal instanceof Dog) {
            Dog dog = (Dog) animal; // Downcasting
            dog.wagTail(); // Output: Wagging tail
        }
    }
}
