package homeWork2;

public class Dog extends Animal {
    private String breed; // поле - порода собаки

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    // переопределение метода makeSound()
    @Override
    public void makeSound() {
        System.out.println("Собака лает: " +"Woof, woof!");
    }

}
