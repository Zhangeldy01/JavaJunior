package homeWork1;

import java.util.Arrays;
import java.util.List;

/*
* Напишите программу, которая использует Stream API для обработки списка чисел.
* Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */
public class App {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        double averageOfEvenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0) // фильтруем только четные числа
                .mapToInt(Integer::intValue) // преобразуем Integer в int
                .average() // вычисляем среднее значение
                .orElse(0); // если списка четных чисел нет, то возвращаем 0

        System.out.println("Среднее значение всех четных чисел: " + averageOfEvenNumbers);
    }
}


