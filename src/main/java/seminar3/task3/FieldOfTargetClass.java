package seminar3.task3;

import java.io.Serializable;

/**
 * Класс, представляющий поле целевого класса для сериализации и десериализации.
 * Реализует интерфейс Serializable, чтобы объекты этого класса можно было сериализовать.
 */
public class FieldOfTargetClass implements Serializable {
    private int fieldInt;  // Целочисленное поле
    private String fieldString;  // Строковое поле

    /**
     * Конструктор класса FieldOfTargetClass.
     * @param fieldInt Целочисленное значение.
     * @param fieldString Строковое значение.
     */
    public FieldOfTargetClass (int fieldInt, String fieldString) {
        this.fieldInt = fieldInt;  // Инициализация целочисленного поля
        this.fieldString = fieldString;  // Инициализация строкового поля
    }

    /**
     * Переопределенный метод toString для представления объекта в виде строки.
     * @return Строковое представление объекта FieldOfTargetClass.
     */
    @Override
    public String toString() {
        return "{FieldOfTargetClass = " +
                "fieldInt: " + fieldInt +  // Добавляем значение целочисленного поля в строку
                ", fieldString: " + fieldString + "}";  // Добавляем значение строкового поля в строку
    }
}
