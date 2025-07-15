package seminar1.MyListStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainMyListStreamApi {
    public static void main(String[] args) {
        // 4-й вариант. a) Создание List с преобразованием элементов
        List<String> stringList = Stream.of("apple", "banana", "orange", "grape") // Stream.of(): Создает поток (stream) из элементов.
                .map(String::toUpperCase) // Преобразование в верхний регистр
                .collect(Collectors.toList()); // Собирает элементы потока в новый List (который можно изменять).

        System.out.println(stringList); // Вывод: [APPLE, BANANA, ORANGE, GRAPE]

        // b) Создание List с использованием Stream API (более гибкий, позволяет выполнять преобразования)
        List<String> myList = Stream.of("apple", "banana", "orange", "grape", "watermelon")
                .collect(Collectors.toList());
        System.out.println("\n Исходный список:");
        System.out.println(myList);

        System.out.println("\nДобавляем элемент 'kiwi': ");
        myList.add("kiwi");
        System.out.println("Добавляем элемент 'pear': ");
        myList.add("pear");

        System.out.println("\nИзмененный список:");
        System.out.println(myList);

        System.out.println("\nПеребор элементов и вывод на консоль (без создания нового списка):");
        System.out.println(myList.stream()
                .sorted()
                .map(String::toUpperCase)
                .filter(substring -> substring.contains("W")).findFirst().orElse(null));

        System.out.println("\nВыводим отсортированные элементы на консоль (без создания нового списка):");
        myList.stream()
                .sorted().
                forEach(System.out::println);

        // Преобразование и сохранение в новый список:
        List<String> processedList =
        myList.stream()
                .sorted()
                .map(String::toUpperCase)
                .filter(s -> s.contains("L"))
                .collect(Collectors.toList());

        System.out.println("\nОбработанный список:");
        System.out.println(processedList);

    }
}
