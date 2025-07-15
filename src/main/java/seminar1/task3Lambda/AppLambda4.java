package seminar1.task3Lambda;
/*
Задача 6. Написать функциональный интерфейс с методом, который принимает три дробных числа: a, b, c
и возвращает тоже дробное число. Написать реализацию такого интерфейса в виде анономного класса или лямбда-выражения,
которое возвращает результат операции a * b^c.
 */

public class AppLambda4 {
    public static void main(String[] args) {

        // 1. Использование анонимного класса
        Calculator calculator = new Calculator() {
            @Override
            public double calculate(double a, double b, double c) {
                // используя цикл for
//                double result = 1;
//                for (int i = 0; i < c; i++) {
//                    result = b * result;
//                }
//                return result * a;

                // используя рекурсию
                if (c == 0) {
                    return a;
                } else {
                    return b * calculate(a, b, c - 1);
                }
            }
        };
        System.out.println(calculator.calculate(2.5, 3, 4));

        // 2. Реализация интерфейса Calculator в виде лямбда-выражения,
        // которое возвращает результат операции a * b^c.
        Calculator calc = (a, b, c) -> {
            // 1) используя цикл for (Итерация)
//            double result = a;
//                for (int i = 0; i < c; i++) {
//                    result *= b;
//                }
//            return result;

            // 2) Используя Math.pow вместо for
            return a * Math.pow(b, c);

        };
        System.out.println(calculator.calculate(2.5, 3, 5));
    }
    @FunctionalInterface
    interface Calculator {
        double calculate(double a, double b, double c);
    }
}
