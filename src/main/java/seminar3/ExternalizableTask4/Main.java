package seminar3.ExternalizableTask4;

import seminar3.task3.FieldOfTargetClass;
import seminar3.task3.TargetVer2;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        // Создание объекта TargetVer2 для сериализации
        TargetVer2 targetVer2 = new TargetVer2(47, "Externalizable", new FieldOfTargetClass(78, "transient"), 90);
        System.out.println("Исходный объект: " + targetVer2);  // Вывод исходного объекта

        // Сериализация объекта:
        try {
            // Создание потока вывода в файл
            var fileOutputStream = new FileOutputStream("ser_obj_1");
            // Создание потока вывода объектов
            var objectOutputStream = new ObjectOutputStream(fileOutputStream);
            // Запись объекта в поток
            objectOutputStream.writeObject(targetVer2);
            // Сброс буфера потока вывода в файл
            fileOutputStream.flush();
            objectOutputStream.flush();
            // Закрытие потока вывода объектов
            objectOutputStream.close();
            // Закрытие потока вывода в файл
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.getMessage());
        }

        // Десериализация объекта:
        try {
            // Создание потока ввода из файла
            var fileInputStream = new FileInputStream("ser_obj_1");
            // Создание потока ввода объектов
            var objectInputStream = new ObjectInputStream(fileInputStream);
            // Чтение объекта из потока
            TargetVer2 deserializeTarget = (TargetVer2) objectInputStream.readObject();
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
