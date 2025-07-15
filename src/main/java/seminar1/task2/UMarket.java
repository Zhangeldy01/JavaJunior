package seminar1.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс UMarket представляет собой упрощенную модель магазина,
 * позволяющую работать с различными товарами, наследующими класс Thing.
 */
public class UMarket {

    /**
     * Метод для вывода списка товаров определенного типа.
     * Использует Stream API для фильтрации и форматированного вывода.
     *
     * @param clazz Класс, представляющий тип товаров для вывода.
     * @param <T>   Тип товаров, наследующий Thing.
     */
    public <T extends Thing> void printThings(Class<T> clazz){

        /*
        // Старый способ реализации с использованием цикла for:
        int index = 1;  // Счетчик для нумерации товаров
        for (var thing : things)  // Перебор всех товаров в списке things
        {
            if (clazz.isInstance(thing)) // Проверка, является ли товар экземпляром класса clazz
            {
                if (Food.class.isAssignableFrom(thing.getClass())) { // Проверка, является ли товар экземпляром класса Food
                    // Вывод информации о продукте питания с указанием белков, жиров и углеводов
                    System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, thing.getName(), ((Food)thing).getProteins() ? "Да" : "Нет",
                            ((Food)thing).getFats() ? "Да" : "Нет", ((Food)thing).getCarbohydrates() ? "Да" : "Нет");

                }
                else{
                // Вывод информации о товаре без указания пищевой ценности
                    System.out.printf("[%d] %s\n", index++, thing.getName());
                }
            }
        } */

        int[] index = {1}; // Массив из одного элемента для хранения индекса (нужен для лямбда-выражений)
        things.stream()  // Создание Stream из списка things
                .filter(clazz::isInstance) // Фильтрация Stream: оставляем только товары, являющиеся экземплярами класса clazz
                .forEach(thing -> {  // Для каждого оставшегося товара выполняем следующие действия
                    if (Food.class.isAssignableFrom(thing.getClass())) {  // Проверка, является ли товар экземпляром класса Food
                        Food foodThing = (Food) thing;  // Преобразование типа Thing к Food
                        // Вывод информации о продукте питания с указанием белков, жиров и углеводов
                        System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                                index[0]++, thing.getName(),
                                foodThing.getProteins() ? "Да" : "Нет",
                                foodThing.getFats() ? "Да" : "Нет",
                                foodThing.getCarbohydrates() ? "Да" : "Нет");
                    } else {
                        // Вывод информации о товаре без указания пищевой ценности
                        System.out.printf("[%d] %s\n", index[0]++, thing.getName());
                    }
                });
        /*
        Использование index[0]++ в лямбда-выражении в методе printThings - это пример побочного эффекта.
        Хотя это и работает, это не рекомендуется, так как может привести к проблемам с параллелизмом.
        Лучше использовать AtomicInteger или другие подходы, избегающие изменения состояния извне лямбда-выражения.
        Использование AtomicInteger более предпочтительно, так как оно потокобезопасно.
         */
    }

    /**
     * Метод для получения товара определенного типа по индексу.
     * Использует Stream API для поиска товара и возвращает его.
     *
     * @param clazz Класс, представляющий тип товара для поиска.
     * @param index Индекс товара в списке товаров определенного типа.
     * @param <T>   Тип товара, наследующий Thing.
     * @return Товар типа T с указанным индексом, или null, если товар не найден.
     */
    public <T extends Thing> T getThingByIndex(Class<T> clazz, int index)
    {
        /* // Старый способ реализации с использованием цикла for:
        int counter = 1; // Счетчик для нумерации товаров
        for (var thing : things)  // Перебор всех товаров в списке things
        {
            if (clazz.isAssignableFrom(thing.getClass())){ // Проверка, является ли товар экземпляром класса clazz
                if (index == counter++)  // Проверка, является ли текущий индекс равным заданному
                    return (T)thing; // Возвращаем товар, преобразованный к типу T
            }
        }
        return null; // Возвращаем null, если товар не найден
        */
        // Атомарный счетчик для нумерации товаров (нужен для лямбда-выражений)
        AtomicInteger counter = new AtomicInteger(1);
        return things.stream()  // Создание Stream из списка things
                .filter(clazz::isInstance)  // Фильтрация Stream: оставляем только товары, являющиеся экземплярами класса clazz
                .filter(thing -> index == counter.getAndIncrement()) // Фильтрация Stream: оставляем только товар с указанным индексом
                .map(clazz::cast)  // Преобразование типа Thing к типу clazz
                .findFirst()  // Получение первого элемента из Stream (если он есть)
                .orElse(null);  // Возвращаем товар или null, если товар не найден

    }

    /**
     * Метод для получения коллекции товаров определенного типа.
     * Использует Stream API для фильтрации и преобразования товаров.
     *
     * @param clazz Класс, представляющий тип товаров для поиска.
     * @param <T>   Тип товаров, наследующий Thing.
     * @return Коллекция товаров типа T.
     */
    public <T extends Thing> Collection<T> getThings(Class<T> clazz)
    {
        /*
        // Старый способ реализации с использованием цикла for:
        Collection<T> list = new ArrayList<>(); // Создание списка для хранения товаров типа T
        for (var thing : things)  // Перебор всех товаров в списке things
        {
            if (clazz.isAssignableFrom(thing.getClass())){  // Проверка, является ли товар экземпляром класса clazz
                list.add((T)thing);  // Добавление товара в список, преобразованного к типу T
            }
        }
        return list; // Возвращаем список товаров типа T
        */

        return things.stream()  // Создание Stream из списка things
                .filter(clazz::isInstance)  // Фильтрация Stream: оставляем только товары, являющиеся экземплярами класса clazz
                .map(clazz::cast)  // Преобразование типа Thing к типу clazz
                .toList(); // Преобразование Stream в List

        /*
        Immutable List (toList()):  toList() возвращает immutable list. Возможно, в будущем потребуется
        изменять список things. В этом случае стоит использовать collect(Collectors.toList()) вместо toList().
         */

    }

    /**
     * Метод для инициализации списка товаров начальными значениями.
     * Этот метод вызывается при создании экземпляра класса UMarket.
     */
    private void initializeThings()
    {
        things.add(new Pen()); // Добавление ручки в список товаров
        things.add(new Notebook()); // Добавление тетради в список товаров

        things.add(new Chicken());  // Добавление курицы в список товаров
        things.add(new Fruit());  // Добавление фрукта в список товаров
        things.add(new OliveOil());  // Добавление оливкового масла в список товаров

        things.add(new BalykCheese());  // Добавление балык-сыра в список товаров
        things.add(new Crisps());  // Добавление чипсов в список товаров
        things.add(new ChocolateBar());  // Добавление шоколадного батончика в список товаров

        things.add(new DumplingsBerries());  // Добавление вареников с ягодами в список товаров
        things.add(new DumplingsMeat());  // Добавление вареников с мясом в список товаров
        things.add(new Cheburek());  // Добавление чебурека в список товаров
    }

    //region Конструкторы

    public UMarket()
    {
        things = new ArrayList<>();
        initializeThings();
    }

    //endregion

    //region Поля

    /**
     * Товары в магазине
     */
    private final Collection<Thing> things;

    //endregion
}
