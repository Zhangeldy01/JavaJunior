package seminar1.task3;

import org.junit.jupiter.api.Test;
import seminar1.task3Lambda.AppLambda3;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс AppLambda3Test содержит unit-тесты для класса AppLambda3 и интерфейса DiscriminantCalculator.
 */
class AppLambda3Test {

    /**
     * Тест для проверки правильности вычисления дискриминанта с положительным результатом.
     */
    @Test
    void testCalculateDiscriminant_PositiveResult() {
        AppLambda3.DiscriminantCalculator discriminantCalculator1 = (a, b, c) -> {
            if (Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть бесконечностью.");
            }
            if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть NaN.");
            }
            return b * b - 4 * a * c;
        };
        double a = 1.5;
        double b = 7.0;
        double c = 4.0;
        assertEquals(25.0, discriminantCalculator1.calculateDiscriminant(a, b, c), 0.0001);
    }

    /**
     * Тест для проверки правильности вычисления дискриминанта с отрицательным результатом.
     */
    @Test
    void testCalculateDiscriminant_NegativeResult() {
        AppLambda3.DiscriminantCalculator discriminantCalculator1 = (a, b, c) -> {
            if (Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть бесконечностью.");
            }
            if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть NaN.");
            }
            return b * b - 4 * a * c;
        };
        double a = 1.0;
        double b = 2.0;
        double c = 3.0;
        assertEquals(-8.0, discriminantCalculator1.calculateDiscriminant(a, b, c), 0.0001);
    }

    /**
     * Тест для проверки выбрасывания исключения IllegalArgumentException при a = Double.POSITIVE_INFINITY.
     */
    @Test
    void testCalculateDiscriminant_InfinityA() {
        AppLambda3.DiscriminantCalculator discriminantCalculator1 = (a, b, c) -> {
            if (Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть бесконечностью.");
            }
            if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть NaN.");
            }
            return b * b - 4 * a * c;
        };
        double a = Double.POSITIVE_INFINITY;
        double b = 2.0;
        double c = 3.0;
        assertThrows(IllegalArgumentException.class, () -> discriminantCalculator1.calculateDiscriminant(a, b, c));
    }

    /**
     * Тест для проверки выбрасывания исключения IllegalArgumentException при b = Double.NEGATIVE_INFINITY.
     */
    @Test
    void testCalculateDiscriminant_InfinityB() {
        AppLambda3.DiscriminantCalculator discriminantCalculator1 = (a, b, c) -> {
            if (Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть бесконечностью.");
            }
            if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть NaN.");
            }
            return b * b - 4 * a * c;
        };
        double a = 1.0;
        double b = Double.NEGATIVE_INFINITY;
        double c = 3.0;
        assertThrows(IllegalArgumentException.class, () -> discriminantCalculator1.calculateDiscriminant(a, b, c));
    }

    /**
     * Тест для проверки выбрасывания исключения IllegalArgumentException при c = Double.NEGATIVE_INFINITY.
     */
    @Test
    void testCalculateDiscriminant_InfinityC() {
        AppLambda3.DiscriminantCalculator discriminantCalculator1 = (a, b, c) -> {
            if (Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть бесконечностью.");
            }
            if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть NaN.");
            }
            return b * b - 4 * a * c;
        };
        double a = 1.0;
        double b = 2.0;
        double c = Double.NEGATIVE_INFINITY;
        assertThrows(IllegalArgumentException.class, () -> discriminantCalculator1.calculateDiscriminant(a, b, c));
    }

    /**
     * Тест для проверки выбрасывания исключения IllegalArgumentException при a = Double.NaN.
     */
    @Test
    void testCalculateDiscriminant_NaNA() {
        AppLambda3.DiscriminantCalculator discriminantCalculator1 = (a, b, c) -> {
            if (Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть бесконечностью.");
            }
            if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть NaN.");
            }
            return b * b - 4 * a * c;
        };
        double a = Double.NaN;
        double b = 2.0;
        double c = 3.0;
        assertThrows(IllegalArgumentException.class, () -> discriminantCalculator1.calculateDiscriminant(a, b, c));
    }

    /**
     * Тест для проверки выбрасывания исключения IllegalArgumentException при b = Double.NaN.
     */
    @Test
    void testCalculateDiscriminant_NaNB() {
        AppLambda3.DiscriminantCalculator discriminantCalculator1 = (a, b, c) -> {
            if (Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть бесконечностью.");
            }
            if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть NaN.");
            }
            return b * b - 4 * a * c;
        };
        double a = 1.0;
        double b = Double.NaN;
        double c = 3.0;
        assertThrows(IllegalArgumentException.class, () -> discriminantCalculator1.calculateDiscriminant(a, b, c));
    }

    /**
     * Тест для проверки выбрасывания исключения IllegalArgumentException при c = Double.NaN.
     */
    @Test
    void testCalculateDiscriminant_NaNC() {
        AppLambda3.DiscriminantCalculator discriminantCalculator1 = (a, b, c) -> {
            if (Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть бесконечностью.");
            }
            if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
                throw new IllegalArgumentException("Коэффициенты не должны быть NaN.");
            }
            return b * b - 4 * a * c;
        };
        double a = 1.0;
        double b = 2.0;
        double c = Double.NaN;
        assertThrows(IllegalArgumentException.class, () -> discriminantCalculator1.calculateDiscriminant(a, b, c));
    }

}