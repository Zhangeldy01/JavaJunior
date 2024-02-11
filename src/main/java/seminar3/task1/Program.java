package seminar3.task1;

import java.io.*;

/**
 * Задача 1
 * ========
 * <p>
 * Создайте класс UserData с полями String name, int age, transient String password.
 * Поле password должно быть отмечено ключевым словом transient.
 * Реализуйте интерфейс Serializable в вашем классе.
 * В методе main создайте экземпляр класса UserData и инициализируйте его данными.
 * Сериализуйте этот объект в файл, используя ObjectOutputStream в сочетании с FileOutputStream
 * <p>
 * Задача 2
 * ========
 * <p>
 * Десериализуйте объект из ранее созданного файла обратно в объект Java,
 * используя ObjectInputStream в сочетании с FileInputStream.
 * Выведите данные десериализованного объекта UserData.
 * Сравните данные до сериализации и после десериализации, особенно обратите внимание на поле,
 * помеченное как transient.
 * Обсудите, почему это поле не было сохранено после десериализации.
 */

public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Задача 1
        UserData user = new UserData("Stanislav", 37, "secret");
        System.out.println("Имя: " + user.getName());
        System.out.println("Возраст: " + user.getAge());
        System.out.println("Пароль: " + user.getPassword());
        System.out.println();

        try (FileOutputStream fileOutputStream = new FileOutputStream("userdata.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))
        {
            objectOutputStream.writeObject(user);
            System.out.println("Объект UserData сериализован.");
        }

        try (FileInputStream fileInputStream = new FileInputStream("userdata.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream))
        {
            user = (UserData) objectInputStream.readObject();
            System.out.println("Объект UserData десериализован.");
        }

        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Password (должен быть null, так как transient): " + user.getPassword());

    }
}
