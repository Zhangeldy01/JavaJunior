package seminar2.task1;

public class Person {
    private String name; // Приватное поле для имени
    private int age;  // Приватное поле для возраста
    private String occupation;  // Приватное поле для профессии

    // Конструктор по умолчанию
    public Person() {
        name = "Name";
        age = 25;
        occupation = "Stargazer";
    }

    // Конструктор с параметрами
    public Person (String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    /**
     * Геттер для поля name
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Геттер для поля age
     * @return возраст
     */
    public int getAge() {
        return age;
    }

    /**
     * Геттер для поля occupation
     * @return профессия
     */
    public String getOccupation() {
        return occupation;
    }


    /**
     * Метод для отображения информации о человеке.
     */
    public void displayInfo() {
        System.out.printf("Имя: %s; Возраст: %d; Профессия: %s.\n", name, age, occupation);
    }
}
