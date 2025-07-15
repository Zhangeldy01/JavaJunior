package seminar2.task3;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMain {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        // Создаем объект (экземпляр класса) класса MessageExample
         MessageExample messageOb = new MessageExample();

         // Получаем класс объекта message
        Class<?> messageClass = messageOb.getClass();

        // Получаем доступ к приватному полю
        Field messageField = messageClass.getDeclaredField("message");
        messageField.setAccessible(true); // Разрешаем доступ к приватному полю
        messageField.set(messageOb, "Reflection API is a strong tool!");

        // Получаем доступ к приватному методу
        Method messageMethod = messageClass.getDeclaredMethod("printMessage");
        messageMethod.setAccessible(true); // Разрешаем доступ к приватному методу
        messageMethod.invoke(messageOb);
    }
}
