package seminar3.task3;

import java.io.*;

/**
 * Главный класс приложения, демонстрирующий сериализацию и десериализацию объектов.
 */
public class Main {

    /**
     * Основной метод программы.
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {

        // Создание объекта Target для сериализации
        Target target = new Target(47, "Serial", new FieldOfTargetClass(78, "izable"), 90);
        System.out.println("Исходный объект: " + target);  // Вывод исходного объекта

        // Сериализация объекта:
        try {
            // Создание потока вывода в файл
            var fileOutputStream = new FileOutputStream("ser_obj");
            // Создание потока вывода объектов
            var objectOutputStream = new ObjectOutputStream(fileOutputStream);
            // Запись объекта в поток
            objectOutputStream.writeObject(target);
            // Сброс буфера потока вывода в файл
            fileOutputStream.flush();
            objectOutputStream.flush();
            // Закрытие потока вывода объектов
            objectOutputStream.close();
            // Закрытие потока вывода в файл
            fileOutputStream.close();

            System.out.println("Объект сериализован!\n");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.getMessage());
        }

        // Десериализация объекта:
        try {
            // Создание потока ввода из файла
            var fileInputStream = new FileInputStream("ser_obj");
            // Создание потока ввода объектов
            var objectInputStream = new ObjectInputStream(fileInputStream);
            // Чтение объекта из потока
            Target deserializeTarget = (Target) objectInputStream.readObject();
            // Закрытие потока ввода из файла
            fileInputStream.close();
            // Закрытие потока ввода объектов
            objectInputStream.close();

            // Вывод десериализованного объекта
            System.out.println("Десериализованный объект: " + deserializeTarget);

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Класс не найден: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода: " + e.getMessage());
        }
    }
}
