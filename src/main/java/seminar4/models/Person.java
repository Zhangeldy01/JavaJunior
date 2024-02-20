package seminar4.models;

public class Person {

    private String name;
    private int age;

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public static Person create(String name, int age) {
        // TODO: Проверка параметров
        return new Person(name, age);
    }
}
