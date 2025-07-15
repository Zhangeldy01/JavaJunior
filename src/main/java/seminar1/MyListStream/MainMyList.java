package seminar1.MyListStream;

import seminar1.MyListStream.MyList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainMyList {
    public static void main(String[] args) {
        // 1-й вариант Создание ArrayList (Эффективна для большинства задач.)
//    List<String> initialList = new ArrayList<>();
//    initialList.add("apple");
//    initialList.add("banana");
//    initialList.add("orange");
//    initialList.add("grape");
//    initialList.add("watermelon");

        // 2-й вариант. Создание List из массива (удобно для небольших, фиксированных списков)
//        List<String> initialList = Arrays.asList("apple", "banana", "orange", "grape", "watermelon");
        // Важно: этот список нельзя изменять т.е. фиксированный по размеру (добавлять или удалять элементы)
        // initialList.add("melon"); // Выбросит UnsupportedOperationException

        // 3-й вариант. Создание неизменяемого List (Java 9+)
        List<String> initialList = List.of(new String("apple"), new String("banana"),
           new String("orange"),new String("grape"),new String("watermelon"));
        // Этот список тоже нельзя изменять
        // initialList.add("kiwi"); // Выбросит UnsupportedOperationException

        // 5-й вариант. Использование LinkedList (редко используется, подходит для частых вставок и удалений
        // в середине списка, но доступ по индексу (например, get(i)) медленнее)
//        List<String> initialList = new LinkedList<>();
//        initialList.add("apple");
//        initialList.add("banana");
//        initialList.add("orange");
//        initialList.add("grape");
//        initialList.add("watermelon");

        MyList myList = new MyList(initialList);

        System.out.println("Исходный список:");
        myList.printAll();

        System.out.println("\nДобавляем элемент 'kiwi': ");
        myList.addElement("kiwi");
        System.out.println("Добавляем элемент 'pear': ");
        myList.addElement("pear");

        System.out.println("\nИзмененный список:");
        myList.printAll();

        /**
         * Фильтрует элементы списка, оставляя только те, которые содержат заданную подстроку.
         * @param s Подстрока для фильтрации.
         * @return Stream<String> Стрим элементов, содержащих заданную подстроку.
         */
        System.out.println("\nСписок, содержащий 'l':");
        myList.myListStream().filter(s -> s.contains("l")).forEach(System.out::println);

        /**
         * Преобразует все элементы списка в верхний регистр.
         * @return Stream<String> Стрим элементов в верхнем регистре.
         */
        System.out.println("\nСписок в верхнем регистре:");
       // myList.myListStream().map(elem -> elem.toUpperCase()).forEach(System.out::println);
        myList.myListStream().map(String::toUpperCase).forEach(System.out::println); // Другой вариант записи

        /**
         * Сортирует элементы списка в алфавитном порядке.
         * @return Stream<String> Стрим отсортированных элементов.
         */
        System.out.println("\nОтсортированный список:");
        myList.myListStream().sorted().forEach(System.out::println);

        /**
         * Возвращает первый элемент списка, содержащий заданную подстроку (если такой есть).
         * @param substring Подстрока для поиска.
         * @return String Первый элемент, содержащий заданную подстроку, или null, если такого нет.
         */
        System.out.println("\nПервый элемент, содержащий 'w':");
        System.out.println(myList.myListStream().filter(substring -> substring.contains("w")).findFirst().orElse(null));

    }


}
