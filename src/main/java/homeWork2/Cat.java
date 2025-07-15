package homeWork2;

public class Cat extends Animal {
    private boolean ginger;

    public Cat(String name, int age, boolean ginger) {
        super(name, age);
        this.ginger = ginger;
    }
    public boolean isGinger() {
        return ginger;
    }

    // переопределение метода makeSound()
    @Override
    public void makeSound() {
        System.out.println(" Кошка мурлычет: " + "Meow!");
    }
}
