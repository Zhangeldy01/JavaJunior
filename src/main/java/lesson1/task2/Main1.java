package lesson1.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {
       List<String> list = Arrays.asList("Hi", "world", "!", "I", "was", "born", "!");

//        1 вариант решения со stream API
//        list = list.stream().filter(str -> str.length() > 3).collect(Collectors.toList());
//
//        for(String item : list){
//            System.out.println(item); // выведет слова длина которых больше 3-х символов
//        }

//        2 вариант решения cо (stream API для преобразования массивов данных) промежуточные
        list.stream().filter(str -> str.length() > 3).forEach(System.out::println);

        // можно создавать цепь фильтров
        list.stream().filter(str -> str.length() > 3).filter(str -> str.contains("b")).forEach(System.out::println);

        System.out.println("\nвозводим в квадрат");

        Arrays.asList(1,2,3,4,5).stream().map(chislo -> "число: " + chislo + ". квадрат числа - " + chislo * chislo).forEach(System.out::println);

        System.out.println("\nсортируем список");

        Arrays.asList(1,10,3,14,5).stream().sorted().map(chislo -> "число: " + chislo + ". квадрат числа - " + chislo * chislo).forEach(System.out::println);

        System.out.println("\nубираем дубликаты");

        Arrays.asList(1,10,3,14,1,3,5).stream().sorted().distinct().map(chislo -> "число: " + chislo + ". квадрат числа - " + chislo * chislo).forEach(System.out::println);

        // терминальные (возвращают н-р: результат, коллекцию)
        System.out.println(Arrays.asList(1,10,3,14,1,3,5).stream().sorted().distinct().findFirst().get());

    }
}
