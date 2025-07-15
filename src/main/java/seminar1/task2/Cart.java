package seminar1.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * Корзина для хранения продуктов питания определенного типа.
 * @param <T> Тип продуктов питания, которые может содержать корзина.
 * Ограничен классом Food и его подклассами.
 */
public class Cart<T extends Food> {

    // Список продуктов в корзине.
    private final ArrayList<T> foodstuffs;

    // Магазин, которому принадлежит корзина.
    private final UMarket market;

    // Класс продуктов, которые может содержать корзина.
    private final Class<T> clazz;

    /**
     * Создание нового экземпляра корзины.
     * @param clazz  Класс продуктов, которые может содержать корзина.
     * @param market принадлежность к магазину
     */
    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz; // Инициализация класса продуктов
        this.market = market; // Инициализация магазина
        foodstuffs = new ArrayList<>(); // Создание нового списка для хранения продуктов
    }

    /**
     * Балансировка корзины по БЖУ (белки, жиры, углеводы).
     * Метод пытается добавить в корзину продукты, чтобы в ней были представлены
     * продукты, содержащие белки, жиры и углеводы.
     */
//    public void cardBalancing() {
//        boolean proteins = false;  // Проверка наличия продуктов с белками в корзине
//        boolean fats = false; // Проверка наличия продуктов с жирами в корзине
//        boolean carbohydrates = false;  // Проверка наличия продуктов с углеводами в корзине

          // Проверка, сбалансирована ли корзина
//        for (var food : foodstuffs) { // Перебор всех продуктов в корзине
//            if (!proteins && food.getProteins())  // Если нет продуктов с белками и текущий продукт содержит белки
//                proteins = true;  // Устанавливаем флаг наличия белков
//            else if (!fats && food.getFats()) // Если нет продуктов с жирами и текущий продукт содержит жиры
//                fats = true;  // Устанавливаем флаг наличия жиров
//            else if (!carbohydrates && food.getCarbohydrates())  // Если нет продуктов с углеводами и текущий продукт содержит углеводы
//                carbohydrates = true;  // Устанавливаем флаг наличия углеводов

//            if (proteins && fats && carbohydrates) // Если все флаги установлены, корзина сбалансирована
//                break; // Прерываем цикл
//        }
          // Если корзина уже сбалансирована
//        if (proteins && fats && carbohydrates) {   // Если все флаги установлены
//            System.out.println("Корзина уже сбалансирована по БЖУ."); // Выводим сообщение
//            return;  // Завершаем метод
//        }
          // Добавление недостающих продуктов из магазина
//        for (var thing : market.getThings(clazz)) { // Перебор всех продуктов в магазине заданного класса
//            Food food = (Food) thing; // Преобразование типа Thing к типу Food
//            if (!proteins && food.getProteins()) { // Если нет продуктов с белками и текущий продукт содержит белки
//                proteins = true;  // Устанавливаем флаг наличия белков/
//                foodstuffs.add((T) food);  // Добавляем продукт в корзину
//            } else if (!fats && food.getFats()) {  // Если нет продуктов с жирами и текущий продукт содержит жиры
//                fats = true;  // Устанавливаем флаг наличия жиров
//                foodstuffs.add((T) food); // Добавляем продукт в корзину
//            } else if (!carbohydrates && food.getCarbohydrates()){  // Если нет продуктов с углеводами и текущий продукт содержит углеводы
//                carbohydrates = true;  // Устанавливаем флаг наличия углеводов
//                foodstuffs.add((T) food);  // Добавляем продукт в корзину
//            } if (proteins && fats && carbohydrates) // Если все флаги установлены, корзина сбалансирована
//                break;  // Прерываем цикл
//        }
          // Вывод сообщения о результате балансировки
//        if (proteins && fats && carbohydrates) // Если все флаги установлены
//            System.out.println("Корзина сбалансирована по БЖУ.");  // Выводим сообщение об успешной балансировке
//        else // Если не все флаги установлены
//            System.out.println("Невозможно сбалансировать корзину по БЖУ.");  // Выводим сообщение о невозможности балансировки
//    }

    /*
    * Домашняя работа №1. *Дополнительная задча:
    * 2.  Переработать метод балансировки корзины товаров cardBalancing() с использованием Stream API
     */

    /**
     * Балансировка корзины по БЖУ (белки, жиры, углеводы).
     * Метод пытается добавить в корзину продукты, чтобы в ней были представлены
     * продукты, содержащие белки, жиры и углеводы.
     */
    public void cardBalancing()
    {
        boolean proteins = checkNutrientFlag(Food::getProteins); // Проверка наличия продуктов с белками в корзине
        boolean fats = checkNutrientFlag(Food::getFats); // Проверка наличия продуктов с жирами в корзине
        boolean carbohydrates = checkNutrientFlag(Food::getCarbohydrates); // Проверка наличия продуктов с углеводами в корзине


        if (proteins && fats && carbohydrates) { // Если все питательные вещества уже есть в корзине
            System.out.println("Корзина уже сбалансирована по БЖУ."); // Выводим сообщение
            return; // Завершаем метод
        }

        Collection<T> marketFoods = market.getThings(clazz); // Получаем список всех доступных продуктов в магазине
        proteins = checkNutrientFlag(proteins, Food::getProteins, marketFoods); // Добавляем продукты с белками, если их нет
        fats = checkNutrientFlag(fats, Food::getFats, marketFoods); // Добавляем продукты с жирами, если их нет
        carbohydrates = checkNutrientFlag(carbohydrates, Food::getCarbohydrates, marketFoods);  // Добавляем продукты с углеводами, если их нет

        if (proteins && fats && carbohydrates) { // Если теперь все питательные вещества есть в корзине
            System.out.println("Корзина сбалансирована по БЖУ."); // Выводим сообщение об успехе
        } else { // Если не удалось сбалансировать корзину
            System.out.println("Невозможно сбалансировать корзину по БЖУ."); // Выводим сообщение о неудаче
        }

    }

    /**
     * Проверка наличия конкретного питательного элемента в корзине
     * @param nutrientCheck Предикат (условие) для проверки наличия питательного элемента в продукте.
     * @return `true`, если в корзине есть хотя бы один продукт, удовлетворяющий условию `nutrientCheck`,
     * `false` в противном случае.
     */
    private boolean checkNutrientFlag(Predicate<Food> nutrientCheck) {
        Optional<T> optionalFood = foodstuffs.stream() // Создаем поток данных из списка продуктов
                .filter(nutrientCheck) // Фильтруем продукты, оставляя только те, которые удовлетворяют условию nutrientCheck
                .findFirst(); // Берем первый попавшийся продукт (если он есть)
        return optionalFood.isPresent(); // Возвращаем true, если продукт найден, false - если нет
    }

    /**
     * Поиск недостающих питательных элементов в корзине и добавление питательно элемента
     * исходя из общего фильтра продуктов
     * @param nutrientFlag  Флаг, показывающий, есть ли уже продукт с данным питательным элементом в корзине.
     * @param nutrientCheck Предикат (условие) для проверки наличия питательного элемента в продукте.
     * @param foods         Доступный список продуктов (исходя из текущего фильтра).
     * @return Состояние обновленного флага питательного элемента.
     *         `true` - если продукт с нужным питательным элементом найден и добавлен в корзину,
     *         `false` - если невозможно найти продукт с нужным питательным элементом.
     *         В этом случае, невозможно сбалансировать корзину по БЖУ.
     */
    private boolean checkNutrientFlag(boolean nutrientFlag, Predicate<Food> nutrientCheck, Collection<T> foods) {
        if (!nutrientFlag) {  // Если флаг показывает, что продукт с нужным питательным элементом ещё не найден
            Optional<T> optionalFood = foods.stream() // Создаем поток данных из списка доступных продуктов
                    .filter(nutrientCheck) // Фильтруем продукты, оставляя только те, которые удовлетворяют условию nutrientCheck
                    .findFirst(); // Берем первый попавшийся продукт (если он есть)
            optionalFood.ifPresent(foodstuffs::add); // Если продукт найден, добавляем его в корзину
            return optionalFood.isPresent(); // Возвращаем true, если продукт найден и добавлен, false - если нет
        }
        return true; // Если продукт с нужным питательным элементом уже был найден, возвращаем true
    }

    /**
     * Получить список продуктов в корзине.
     * @return Список продуктов в корзине.
     */
    public Collection<T> getFoodstuffs() {
        return foodstuffs; // Возвращаем коллекцию продуктов
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs(){
        /*
        int index = 1;
        for (var food : foodstuffs)
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, food.getName(), food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет", food.getCarbohydrates() ? "Да" : "Нет");
         */
        AtomicInteger index = new AtomicInteger(1); // Создание AtomicInteger для нумерации продуктов
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", // Для каждого продукта выводим информацию
                index.getAndIncrement(), food.getName(), // Выводим индекс и имя продукта
                food.getProteins() ? "Да" : "Нет", // Выводим информацию о белках
                food.getFats() ? "Да" : "Нет", // Выводим информацию о жирах
                food.getCarbohydrates() ? "Да" : "Нет")); // Выводим информацию об углеводах

    }

}
