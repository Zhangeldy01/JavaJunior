package homeWork2;

public class Cat extends Animal {
    private boolean isGinger;

    public Cat(String name, int age, boolean isGinger) {
        super(name, age);
        this.isGinger = isGinger;
    }
    public boolean isGinger() {
        return isGinger;
    }

    // переопределение метода makeSound()
    @Override
    public void makeSound() {
        System.out.println("Кошка мурлычет: " + "Meow!");
    }
}
