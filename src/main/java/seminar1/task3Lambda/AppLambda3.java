package seminar1.task3Lambda;

/*
Задача 5. Написать функциональный интерфейс с методом, который принимает три дробных числа: a, b, c
и возвращает тоже дробное число. Написать реализацию такого интерфейса в виде анономного класса или лямбда-выражения,
которое возвращает дискриминант D = b^2 — 4ac.
 */

/**
 * Класс AppLambda3 демонстрирует использование функционального интерфейса DiscriminantCalculator с анономным классом
 * и с лямбда-выражением для вычисления дискриминанта квадратного уравнения.
 */
public class AppLambda3 {

    /**
     * Основной метод программы.
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {

        // 1. Использование анонимного класса
        DiscriminantCalculator discriminantCalculator = new DiscriminantCalculator() {
            @Override
            public double calculateDiscriminant(double first, double second, double third) {
                return second * second - 4 * first * third;
            }
        };
        System.out.println(discriminantCalculator.calculateDiscriminant(2.0, 5.0, - 3.0));

        // 2. Реализация интерфейса DiscriminantCalculator в виде лямбда-выражения,
        // которое вычисляет дискриминант D = b^2 - 4ac.
        DiscriminantCalculator discriminantCalculator1 = (a, b, c) -> {
            if (Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть бесконечностью");
            }
            else if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть NaN.");
            }
            else {
                return b * b - 4 * a * c;
            }
        };

        double a = 1.5;
        double b = 7.0;
        double c = 4.0;
        try {
            // Вычисляем дискриминант для a, b, c
            double discriminant = discriminantCalculator1.calculateDiscriminant(a, b, c);
            System.out.println(("Дискриминант для a = " + a + ", b = " + b + ", c = " + c + " равен " + discriminant));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        a = Double.POSITIVE_INFINITY;
        b = 2.0;
        c = 3.0;

        try {
            // Вычисляем дискриминант для a, b, c
            double discriminant = discriminantCalculator1.calculateDiscriminant(a, b, c);
            System.out.println("Дискриминант для a=" + a + ", b=" + b + ", c=" + c + ": " + discriminant);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        a = Double.NaN;
        b = 2.0;
        c = 3.0;

        try {
            // Вычисляем дискриминант для a, b, c
            double discriminant = discriminantCalculator1.calculateDiscriminant(a, b, c);
            System.out.println("Дискриминант для a=" + a + ", b=" + b + ", c=" + c + ": " + discriminant);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Функциональный интерфейс DiscriminantCalculator с методом calculateDiscriminant,
     * который принимает три дробных числа и возвращает дробное число.
     */
    @FunctionalInterface
    public interface DiscriminantCalculator {

        /**
         * Вычисляет дискриминант квадратного уравнения.
         * @param a Коэффициент a.
         * @param b Коэффициент b.
         * @param c Коэффициент c.
         * @return Значение дискриминанта.
         * @throws IllegalArgumentException Если любой из коэффициентов равен бесконечности или NaN.
         */
        double calculateDiscriminant (double a, double b, double c) throws IllegalArgumentException;
    }

}
