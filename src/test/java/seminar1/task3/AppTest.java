package seminar1.task3;

import org.junit.jupiter.api.Test;
import seminar1.task3Lambda.App;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    /**
     //     * Тест для проверки работы лямбда-выражения.
     //     * Проверяет, что метод divideByThirteen возвращает true для числа, делящегося на 13.
     //     */
    @Test
    void testDividedByThirteenWithLambda_Divisible() {
        // Arrange (Подготовка данных)
        App.Divideable d = (num) -> num % 13 == 0; // Создание лямбда-выражения

        // Act (Выполнение)
        boolean result = d.dividedByThirteen(39); // Вызов метода dividedByThirteen с числом, делящимся на 13

        // Assert (Проверка)
        assertTrue(result); // Проверка, что результат равен true
    }

    /**
     * Тест для проверки работы лямбда-выражения.
     * Проверяет, что метод dividedByTherteen возвращает false для числа, не делящегося на 13.
     */
    @Test
    void testDividedByTherteenWithLambda_NotDivisible() {
        // Arrange (Подготовка данных)
        App.Divideable d = (num) -> num % 13 == 0; // Создание лямбда-выражения

        // Act (Выполнение)
        boolean result = d.dividedByThirteen(47); // Вызов метода dividedByThirteen с числом,  не делящимся на 13

        // Assert (Проверка)
        assertFalse(result); // Проверка, что результат равен false

    }

    /**
     * Тест для проверки работы анонимного класса (закомментировано в основном классе).
     * Проверяет, что метод dividedByThirteen возвращает true для числа, делящегося на 13.
     */
    @Test
    void testDividedBytherteenWithAnonymousClass_Divisible() {
        // Arrange (Подготовка данных)
        App.Divideable d = new App.Divideable() {  // Создание экземпляра анонимного класса, реализующего интерфейс Divideable
            @Override
            public boolean dividedByThirteen(int num) {
                return num % 13 == 0;
            }
        };

        // Act (Выполнение)
        boolean result = d.dividedByThirteen(26);  // Вызов метода dividedByThirteen с числом, делящимся на 13

        // Assert (Проверка)
        assertTrue(result); // Проверка, что результат равен true
    }

    /**
     * Тест для проверки работы анонимного класса (закомментировано в основном классе).
     * Проверяет, что метод dividedByThirteen возвращает false для числа, не делящегося на 13.
     */
    @Test
    void testDividedByThirteenWithAnonymousClass_NotDivisiable() {
        // Arrange (Подготовка данных)
        App.Divideable d = new App.Divideable() {
            @Override
            public boolean dividedByThirteen(int num) {
                return num % 13 == 0;
            }
        };
        // Act (Выполнение)
        boolean result = d.dividedByThirteen(27); // Вызов метода dividedByThirteen с числом, не делящимся на 13

        // Assert (Проверка)
        assertFalse(result); // Проверка, что результат равен false
    }

}