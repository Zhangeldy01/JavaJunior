package seminar3.task3;

import java.io.Serializable;

/**
 * Класс, представляющий целевой объект для сериализации и десериализации.
 * Реализует интерфейс Serializable, чтобы объекты этого класса можно было сериализовать.
 */
public class Target implements Serializable {
    private int integerField;   // Целочисленное поле
    private String stringField;  // Строковое поле
    private FieldOfTargetClass field;  // Поле, содержащее объект класса FieldOfTargetClass
    private transient int transField;  // Транзитное поле (не сериализуется)

    /**
     * Конструктор класса Target.
     *
     * @param integerField Целочисленное значение.
     * @param stringField Строковое значение.
     * @param field Объект класса FieldOfTargetClass.
     * @param transField Транзитное целочисленное значение.
     */
    public Target (int integerField, String stringField, FieldOfTargetClass field, int transField) {
        this.integerField = integerField;  // Инициализация целочисленного поля
        this.stringField = stringField;  // Инициализация строкового поля
        this.field = field;            // Инициализация поля типа FieldOfTargetClass
        this.transField = transField;  // Инициализация транзитного поля
    }

    /**
     * Переопределенный метод toString для представления объекта в виде строки.
     *
     * @return Строковое представление объекта Target.
     */
        @Override
    public String toString() {
        return "{Target = " +
                "integerField: " + integerField + // Добавляем значение целочисленного поля в строку
                ", stringField: " + stringField + // Добавляем значение строкового поля в строку
                ", transientField: " + transField +  // Добавляем значение транзитного поля в строку
                ", customObjectField: " + field.toString() + "}";// Добавляем строковое представление объекта FieldOfTargetClass
        }
}

