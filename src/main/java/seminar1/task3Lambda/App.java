package seminar1.task3Lambda;
/*
 * Задача 3. Написать функциональный интерфейс с методом, который принимает число и возвращает булево значение.
 * Написать реализацию такого интерфейса в виде анонимного класса и лямбда-выражения, которое возвращает true
 * если переданное число делится без остатка на 13.
 */

/**
 * Класс App демонстрирует использование анонимного класса и лямбда-выражения для реализации интерфейса Divideable.
 */
public class App {

    /**
     * Основной метод, выполняемый при запуске приложения.
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {

        // Использование анонимного класса
        Divideable d = new Divideable() { // Создание экземпляра анонимного класса, реализующего интерфейс Divideable
            @Override
            public boolean dividedByThirteen(int num) { // Реализация метода dividedByThirteen
                return num % 13 == 0; // Проверка делимости числа на 13
            }
        };
        System.out.println(d.dividedByThirteen(39)); // Вызов метода dividedByThirteen и вывод результата (true)

        // Использование лямбда-выражения
        Divideable result = (num) -> num % 13 == 0; // Создание экземпляра интерфейса Divideable с использованием лямбда-выражения
        System.out.println(result.dividedByThirteen(67)); // Вызов метода dividedByThirteen и вывод результата (false)

    }

    /**
     * Интерфейс Divideable определяет метод для проверки делимости числа на 13.
     */
    public interface Divideable {

        /**
         * Проверяет, делится ли заданное число на 13.
         * @param num Число для проверки.
         * @return `true`, если число делится на 13, `false` в противном случае.
         */
        boolean dividedByThirteen(int num);
    }
}
