package seminar1.task3Lambda;
/*
Задача 4. Написать функциональный интерфейс с методом, который принимает две строки и возвращает тоже строку.
Написать реализацию такого интерфейса в виде анинонимного класса и лямбды-выражения, которая возвращает ту строку, которая длиннее.
 */

/**
 * Класс AppLambda2 демонстрирует использование функционального интерфейса StringCombiner
 * с анинонимным классом и с лямбда-выражением, которое возвращает более длинную строку из двух.
 */
public class AppLambda2 {
    public static void main(String[] args) {

        // 1. Реализация интерфейса StringCombiner в виде анонимного класса,
        //     которое возвращает строку, которая длиннее.
        StringCombiner stringCombiner = new StringCombiner() {
            @Override
            public String longerString(String str1, String str2) {
//                if (str1.length() >= str2.length()) {
//                    return str1;
//                } else {
//                    return str2;
//                }
                if (str1 == null && str2 == null) {
                    return null;
                }
                else if (str1 == null && str2 != null) {
                    return str2;
                }
                else if (str1 != null && str2 == null) {
                    return str1;
                }
                else {
                    return (str1.length() >= str2.length() ? str1 : str2);
                }
            }
        };
        System.out.println(stringCombiner.longerString("null", "aerrtt"));

        // 2. Реализация интерфейса StringCombiner в виде лямбда-выражения,
        //    которое возвращает строку, которая длиннее.
        StringCombiner stringCombiner1 = (str1, str2) -> (str1.length() >= str2.length()) ? str1 : str2;
        System.out.println(stringCombiner1.longerString("daa", "bbb"));
    }

    /**
     * Функциональный интерфейс StringCombiner с методом longerString,
     * который принимает две строки и возвращает строку.
     */
    @FunctionalInterface
    interface StringCombiner {

        /**
         * Принимает две строки и возвращает строку.
         * @param str1 Первая строка.
         * @param str2 Вторая строка.
         * @return Результирующая строка.
         */
        String longerString(String str1, String str2);
    }
}
