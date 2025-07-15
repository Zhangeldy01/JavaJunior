package seminar1.MyListStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MyList {
    private final List<String> myList; // Объявление private final List

    public MyList(List<String> initialList) { // Инициализация в конструкторе (или в блоке инициализации)
        this.myList = new ArrayList<>(initialList);
    }

//    public List<String> getMyList() { //  // Возвращает копию, чтобы избежать изменения извне
//        return new ArrayList<>(myList);
//    }

    /**
     * Возвращает стрим элементов списка.
     * @return Stream<String> Стрим элементов списка.
     */
    public Stream<String> myListStream() { // Метод getMyList() можно заменить на стрим
        return myList.stream();
    }

    /**
     * Добавляет элемент в список.
     * @param element Элемент для добавления.
     */
    public void addElement(String element) {
        myList.add(element); // Добавляем переданный элемент
    }

    /**
     * Выводит все элементы списка в консоль.
     */
    public void printAll() {
        myListStream().forEach(System.out::println);
    }
}
