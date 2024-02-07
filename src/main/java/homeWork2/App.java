package homeWork2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Animal[] animals = new Animal[4];
        animals[0] = new Dog("Rex", 3, "German Shepherd");
        animals[1] = new Cat("Mosya", 2, false);
        animals[2] = new Cat("Marta", 5, true);
        animals[3] = new Dog("Jack", 5, "Labrador");

        for(Animal animal : animals) {
            System.out.println("Name: " + animal.getName() + ", Age: " + animal.getAge() + ".");
            // Вывод породы собаки
            if(animal instanceof Dog) {
                Dog dog = (Dog) animal;
                System.out.println("Breed: " + dog.getBreed());
            // Проверяем кошка рыжая или нет
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                System.out.println("isGinger: " + cat.isGinger());
            }
            // Используется Reflection API, чтобы найти и вызвать метод makeSound()
            Method makeSoundMethod = animal.getClass().getDeclaredMethod("makeSound");
            if (makeSoundMethod != null) {
                makeSoundMethod.invoke(animal);
            }
            System.out.println();
        }
    }
}
