package seminar3.task3;

import java.io.*;

/**
 * Класс, представляющий целевой объект для сериализации и десериализации (версия 2).
 * Реализует интерфейс Serializable, чтобы объекты этого класса можно было сериализовать.
 * В этой версии используются собственные методы `writeObject` и `readObject` для управления сериализацией.
 */
public class TargetVer2 implements Serializable {
    private int integerField;
    private String stringField;
    private FieldOfTargetClass field;
    private transient int transField;

    /**
     * Конструктор класса TargetVer2.
     * @param integerField Целочисленное значение.
     * @param stringField Строковое значение.
     * @param field Объект класса FieldOfTargetClass.
     * @param transField Транзитное целочисленное значение.
     */
    public TargetVer2(int integerField, String stringField, FieldOfTargetClass field, int transField) {
        this.integerField = integerField;
        this.stringField = stringField;
        this.field = field;
        this.transField = transField;
    }

    /**
     * Пользовательский метод для записи объекта в поток сериализации.
     * Этот метод вызывается вместо стандартной сериализации, когда он определен в классе.
     * @param output Поток вывода объектов.
     * @throws IOException Если произошла ошибка ввода/вывода.
     */
    private void writeObject(ObjectOutputStream output) throws IOException, FileNotFoundException {
        System.out.println("writeObject was executed!\n"); // Вывод сообщения о том, что метод был вызван
        output.defaultWriteObject(); // Вызов стандартной сериализации для большинства полей
        output.writeInt(transField); // Запись значения транзитного поля в поток (транзитные поля по умолчанию не сериализуются)
    }

    /**
     * Пользовательский метод для чтения объекта из потока десериализации.
     * Этот метод вызывается вместо стандартной десериализации, когда он определен в классе.
     * @param input Поток ввода объектов.
     * @throws IOException Если произошла ошибка ввода/вывода.
     * @throws ClassNotFoundException Если не удалось найти класс при десериализации.
     */
    private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
        System.out.println("readObject was executed!"); // Вывод сообщения о том, что метод был вызван
        input.defaultReadObject(); // Вызов стандартной десериализации для большинства полей
        this.transField = input.readInt(); // Чтение значения транзитного поля из потока
    }

    /**
     * Переопределенный метод toString для представления объекта в виде строки.
     * @return Строковое представление объекта TargetVer2.
     */
    @Override
    public String toString () {
        return "{Target = " +
                "integerField: " + integerField +
                ", stringField: " + stringField +
                ", transientField: " + transField +
                ", customObjectField: " + field.toString();
    }
}

