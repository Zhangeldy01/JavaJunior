package homeWork1;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Напишите программу, которая использует Stream API для обработки списка чисел.
* Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */
public class App {
    public static void main(String[] args) {
        // Фильтрация с использованием цикла for
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = findEvenNumbers(numbers);
        double averageEvenNumbers = findAverageEvenNumbers(evenNumbers);
        System.out.println("Вывод четных чисел: " + evenNumbers);
        System.out.println("Среднее значение всех четных чисел: " + averageEvenNumbers);

        // Фильтрация с использованием Stream API
        double averageOfEvenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0) // фильтруем только четные числа
                .mapToInt(Integer::intValue) // преобразуем Integer в int
                .average() // вычисляем среднее значение
                .orElse(0); // если списка четных чисел нет, то возвращаем 0
        System.out.println("Среднее значение всех четных чисел (Stream API): " + averageOfEvenNumbers);

        System.out.println("\n_______Если это массив чисел__________");
        // Фильтрация с использованием цикла for
        int [] arrays = {1, 5, 14, 8, 67, 16, 6, 10, 18, 11, 30};
        findAverageOfEvenNumbers(arrays);

        // Фильтрация с использованием Stream API
        double evenAverageList = Arrays.stream(arrays)
                .filter(n -> n % 2 == 0)
                .average()
                .orElse(0);
        System.out.println("Average of numbers (Stream API): " + evenAverageList);
    }
    private static List<Integer> findEvenNumbers(List<Integer> number1) {
        List<Integer> evenNum = new ArrayList<>();
        for (int num : number1) {
            if (num % 2 == 0) {
                evenNum.add(num);
            }
        }
        return evenNum;
    }

    private static double findAverageEvenNumbers (List<Integer> numbers2) {
        int sum = 0;
        for (int i = 0; i < numbers2.size(); i++) {
            sum += numbers2.get(i);
        }
        return sum / numbers2.size();
    }

    private static void findAverageOfEvenNumbers(int[] arr) {
        int sum = 0;
        int evenCount = 0;
        System.out.print("Even number: ");
        for (int i = 0; i < arr.length; i ++) {
            if ( arr[i] % 2 == 0 ) {
                System.out.print(arr[i] + " ");
                evenCount++;
                sum += arr[i];
            }
        }
        System.out.println();
        double average = (double) sum / evenCount;
        System.out.println("Average of numbers: " + average);
    }

}


