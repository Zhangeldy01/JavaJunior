package homeWork2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*
Задача 1:
Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
Выведите на экран информацию о каждом объекте.
Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */
public class App {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Animal[] animals = new Animal[4];
        animals[0] = new Dog("Rex", 3, "German Shepherd");
        animals[1] = new Cat("Mosya", 1, false);
        animals[2] = new Cat("Marta", 5, true);
        animals[3] = new Dog("Jack", 1, "Labrador");

        for(Animal animal : animals) {
            System.out.printf("Name: %s, Age: %s, ", animal.getName(), animal.getAge());
            // Вывод породы собаки
            if(animal instanceof Dog) {
                Dog dog = (Dog) animal;
                System.out.printf("Breed: %s,", dog.getBreed());
            // Проверяем кошка рыжая или нет
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                System.out.printf("isGinger: %s,", cat.isGinger());
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
