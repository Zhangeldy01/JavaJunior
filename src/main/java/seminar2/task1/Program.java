package seminar2.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Задача 1: Основы Reflection API
 * ================================
 * <p>
 *     Получите информацию о классе "Person" с использовванием Reflection API:
 *     выведите на экран все поля и методы класса.
 *     Создайте экземпляр класса "Person" с использованием Reflection API,
 *     установите значения полей и вызовите методы.
 *     Реализуйте обработку исключений для обеспечения корректного взаимодействия с Reflection API.
 * </p>
 */

/**
 * Класс Program для демонстрации Reflection API
 */
public class Program {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {

        // 1. Получение класса Person по имени (полное имя класса)
        Class<?> personalClass = Class.forName(Person.class.getName()); // либо в аргумент передать полный путь к файлу Class.forName("seminar2.task1.Person");

        // 2. Получение списка полей класса
        Field[] fields = personalClass.getDeclaredFields(); // getDeclaredFields() позволяет получить все поля, включая приватные
        System.out.println("Список полей класса Person:");
        for (Field field : fields) {
            System.out.println("Поле: " + field.getName());
        }

        // 3. Получение списка конструкторов
        Constructor<?>[] constructors = personalClass.getConstructors();  // getConstructors() - только public конструкторы

        System.out.println("\nСписок конструкторов класса Person:");
        for (Constructor<?> constructor : constructors) {
            System.out.println("Конструктор: " + constructor);
        }

        // 4. Создание экземпляра класса Person с использованием конструктора по умолчанию (без параметров)
        Object personInstance = constructors[0].newInstance(null); // Вызов конструктора по умолчанию

        // 5. Работа с полями через Reflection
        // 5.1. Получение поля 'name'
        Field nameField = personalClass.getDeclaredField("name"); // getDeclaredField() позволяет получить поле, включая приватное
        nameField.setAccessible(true); // Разрешение доступа к приватному полю (важно для приватных полей)
        nameField.set(personInstance, "Alice"); // Установка значения поля 'name'

        // 5.2. Получение поля 'age'
        Field ageField = personalClass.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(personInstance, 30);

        // 5.3. Получение и вызов метода 'displayInfo'
        Method displayInfoMethod = personalClass.getDeclaredMethod("displayInfo"); // getDeclaredMethod() позволяет получить метод, включая приватный
        displayInfoMethod.invoke(personInstance);  // Вызов метода displayInfo для объекта personInstance.

        // 6. Создание экземпляра класса Person с использованием конструктора с параметрами
        // Находим конструктор, принимающий String, int, String
        Constructor<?> constructorWithParams = personalClass.getConstructor(String.class, int.class, String.class);

        // Создаем экземпляр Person, используя найденный конструктор
        Object personWithParams = constructorWithParams.newInstance("John", 47, "Developer");

        // Вызываем метод displayInfo для нового объекта
        Method displayInfoMethod2 = personalClass.getDeclaredMethod("displayInfo");
        displayInfoMethod2.invoke(personWithParams);

        // 7.  Получение значений полей
        Field nameField2 = personalClass.getDeclaredField("name");
        nameField2.setAccessible(true);
        String nameValue = (String) nameField2.get(personWithParams); // Получаем значение поля name
        System.out.println("\nИмя (получено через Reflection API): " + nameValue);

        Field ageField2 = personalClass.getDeclaredField("age");
        ageField2.setAccessible(true);
        int ageValue = ageField2.getInt(personWithParams);
        System.out.println("Возраст (получен через Reflection API): " + ageValue);

        Field occupationField = personalClass.getDeclaredField("occupation");
        occupationField.setAccessible(true);
        String occupationValue = (String) occupationField.get(personWithParams);
        System.out.println("Профессия (получена через Reflection API): " + occupationValue);

    }

}
